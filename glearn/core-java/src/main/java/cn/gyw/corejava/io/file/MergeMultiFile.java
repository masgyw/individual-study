package cn.gyw.corejava.io.file;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多个文件合并
 * 目的：写入1亿行，7位以内的随机的数字
 *
 * @date 2022/8/26
 */
public class MergeMultiFile {

    public static void main(String[] args) throws Exception {
        int total = 1_0000_0000;
        // 分段
        int segment = 20;

        ExecutorService executor = Executors.newFixedThreadPool(segment);
        AtomicInteger incr = new AtomicInteger(0);
        CountDownLatch downLatch = new CountDownLatch(segment);

        long start = System.nanoTime();
        for (int j = 0; j < segment; j++) {
            executor.execute(() -> {
                RandomAccessFile acf;
                FileChannel fc = null;
                try {
                    String fileName = "E:\\tmp_" + incr.getAndIncrement() + ".txt";
                    acf = new RandomAccessFile(fileName, "rw");
                    fc = acf.getChannel();
                    int offset = 0;
                    for (int i = 0, len = total / segment / 100000; i < len; i++) {
                        // 每次写1w
                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < 10000; k++) {
                            sb.append(new Random().nextInt(1000_0000)).append("\n");
                        }
                        byte[] bytes = sb.toString().getBytes(StandardCharsets.UTF_8);
                        MappedByteBuffer buf = fc.map(FileChannel.MapMode.READ_WRITE, offset, bytes.length);
                        buf.put(bytes);
                        offset = offset + bytes.length;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    downLatch.countDown();
                    try {
                        fc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        downLatch.await();
        System.out.println("小文件写入完毕! 耗时：" + (System.nanoTime() - start));

        List<File> allFile = new ArrayList<>(segment);
        for (int i = 0; i < segment; i++) {
            allFile.add(new File("E:\\tmp_" + i + ".txt"));
        }
        start = System.nanoTime();

        merge(allFile, "E:\\last.txt");
        System.out.println("合并文件完成，耗时：" + (System.nanoTime() - start));
        executor.awaitTermination(3, TimeUnit.SECONDS);
    }

    private static void merge(List<File> allFile, String toFile) {
        try (FileOutputStream out = new FileOutputStream(new File(toFile), true);
             FileChannel outFc = out.getChannel()) {
            // 记录新文件最后一个数据位置
            long pos = 0L;
            for (File file : allFile) {
                try (FileInputStream in = new FileInputStream(file);
                    FileChannel inFc = in.getChannel()) {
                    // 从inChannel中读取file.length()长度的数据，写入outChannel的start处
                    outFc.transferFrom(inFc, pos, file.length());

                    pos += file.length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
