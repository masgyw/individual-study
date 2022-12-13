package cn.gyw.frame.thirdpart.media;

import cn.gyw.frame.util.LocalConfigReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 音视频工具类测试
 */
public class MediaUtilTest {

    private static final Logger log = LoggerFactory.getLogger(MediaUtilTest.class);
    private static final Logger mainLog = LoggerFactory.getLogger("media.result");

    private static final String KEY_FFMPEG_HOME = "ffmpeg-home";
    private static final String KEY_DIR_PATH = "dirPath";

    /**
     * 处理B站音、视频文件
     */
    @Test
    public void handleBili() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ExecutorCompletionService<MediaResult> completionService = new ExecutorCompletionService<>(executor);
        // 任务数计数
        AtomicInteger counter = new AtomicInteger(0);
        AtomicInteger totalCnt = new AtomicInteger(0);

        String baseDir = LocalConfigReader.read(KEY_DIR_PATH, MediaUtil.class);
        assert baseDir != null;
        Path basePath = Paths.get(baseDir);
        try {
            List<Path> dirList = Files.walk(basePath, 1)
                    .filter(Files::isDirectory)
                    .filter(path -> (basePath.getNameCount() + 1) == path.getNameCount())
                    .collect(Collectors.toList());
            log.info("视频目录：{}", dirList);

            for (Path videoPath : dirList) {
                List<Path> list = Files.walk(videoPath, 1)
                        .filter(Files::isDirectory)
                        .filter(path -> (videoPath.getNameCount() + 1) == path.getNameCount())
                        .collect(Collectors.toList());
                for (Path path : list) {
                    MediaTask task = new MediaTask(counter);
                    Files.walk(path)
                            .filter(subPath -> !Files.isDirectory(subPath))
                            .parallel()
                            .forEach(filePath -> {
                                String fileName = filePath.getFileName().toString();
                                switch (fileName) {
                                    case "video.m4s":
                                        task.setVideoPath(filePath);
                                        break;
                                    case "audio.m4s":
                                        task.setAudioPath(filePath);
                                        break;
                                    case "entry.json":
                                        task.setEntryPath(filePath);
                                        break;
                                }
                            });
                    counter.addAndGet(1);
                    totalCnt.addAndGet(1);
                    completionService.submit(task);
                }
            }
            // 获取执行结果
            while (counter.get() != 0) {
                mainLog.info("已处理任务结果：{}", completionService.take().get());
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        mainLog.info("任务已全部处理完成，总文件数：{}", totalCnt.get());
    }

    @BeforeEach
    void setUp() {
        String ffmpegPath = LocalConfigReader.read(KEY_FFMPEG_HOME, MediaUtil.class);
        MediaUtil.setFFmpegPath(ffmpegPath);
        log.info("ffmpeg 程序目录：{}", ffmpegPath);
    }

    static class MediaTask implements Callable<MediaResult> {

        /**
         * 视频文件路径
         */
        private Path videoPath;
        /**
         * 音频文件路径
         */
        private Path audioPath;
        /**
         * 元数据文件路径
         */
        private Path entryPath;
        /**
         * 当前计数
         */
        private AtomicInteger counter;

        @Override
        public MediaResult call() throws Exception {
            String entryStr = String.join("", Files.readAllLines(entryPath, StandardCharsets.UTF_8));
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> entryMap =
                    objectMapper.readValue(entryStr, new TypeReference<Map<String, Object>>() {
                    });
            String title = entryMap.get("title").toString();
            String outFileName = ((Map) entryMap.get("page_data")).get("part").toString();
            String storagePath = "G:/Videos";
            Path titleDir = Paths.get(storagePath + File.separator + title);
            if (!titleDir.toFile().exists()) {
                Files.createDirectory(titleDir);
                log.info("创建视频输出目录：{}", titleDir);
            }
            // -i -i audio.m4s -c:v copy -strict experimental 1.MP4
            List<String> commandList = new ArrayList<>();
            commandList.add("-i");
            commandList.add(videoPath.toString());
            commandList.add("-i");
            commandList.add(audioPath.toString());
            commandList.add("-c:v");
            commandList.add("copy");
            commandList.add("-strict");
            commandList.add("experimental");
            commandList.add("\"" + titleDir + File.separator + outFileName + ".mp4\"");
            String ret = MediaUtil.executeCommand(commandList);
            // 完成后，计数-1，用于判断任务是否全部结束
            counter.decrementAndGet();

            MediaResult result = new MediaResult();
            result.setFileName(outFileName);
            result.setExecRet(ret);
            return result;
        }

        MediaTask(AtomicInteger counter) {
            this.counter = counter;
        }

        public void setVideoPath(Path videoPath) {
            this.videoPath = videoPath;
        }

        public void setAudioPath(Path audioPath) {
            this.audioPath = audioPath;
        }

        public void setEntryPath(Path entryPath) {
            this.entryPath = entryPath;
        }

        @Override
        public String toString() {
            return "MediaTask{" +
                    "videoPath='" + videoPath + '\'' +
                    ", audioPath='" + audioPath + '\'' +
                    ", entryPath='" + entryPath + '\'' +
                    '}';
        }
    }

    static class MediaResult {

        String fileName;
        String execRet;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getExecRet() {
            return execRet;
        }

        public void setExecRet(String execRet) {
            this.execRet = execRet;
        }

        @Override
        public String toString() {
            return "{" +
                    "fileName='" + fileName + '\'' +
                    ", execRet='" + execRet + '\'' +
                    '}';
        }
    }
}