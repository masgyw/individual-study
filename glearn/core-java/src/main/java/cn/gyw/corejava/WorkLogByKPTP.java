package cn.gyw.corejava;

import cn.gyw.corejava.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 基于KPTP 的工作模板生成
 */
public final class WorkLogByKPTP {

    private final static Logger LOGGER = LoggerFactory.getLogger(WorkLogByKPTP.class);
    private final static DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final Map<DayOfWeek, String> WEEK_MAP = new HashMap<>();

    /**
     * 文件模板
     */
    private static final String TEMPLATE_NAME = "KPTP.txt";

    /**
     * 生成每周工作日志文件
     *
     * @param targetDir 工作日志目录
     */
    public static boolean generateWorkLogOfWeek(String targetDir) {
        URI templateUri;
        try {
            templateUri = Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
                    .getResource(TEMPLATE_NAME)).toURI();

            Path template = Paths.get(templateUri);
            LocalDate startDt = LocalDate.now();
            LocalDate endDay = LocalDate.of(startDt.getYear(), Month.DECEMBER,
                    Month.DECEMBER.length(startDt.isLeapYear()));
            LOGGER.info("文件生成周期：{}-{}", startDt, endDay);

            String content = String.join(System.lineSeparator(), Files.readAllLines(template, StandardCharsets.UTF_8));

            List<String> weekLines = new ArrayList<>();
            String filename = DAY_FORMATTER.format(startDt) + ".txt";
            while (!startDt.isAfter(endDay)) {
                // 非工作日跳过
                if (isWeekDay(startDt.getDayOfWeek())) {
                    String oneDay = getSplitLine(30L) + System.lineSeparator()
                            + SystemUtil.printBlack(1) + DAY_FORMATTER.format(startDt)
                            // 空格
                            + SystemUtil.printBlack(4)
                            // 星期
                            + WEEK_MAP.get(startDt.getDayOfWeek())
                            // 换行
                            + System.lineSeparator() + System.lineSeparator()
                            + content + System.lineSeparator();
                    weekLines.add(oneDay);
                }
                // 周日 或 当年最后一天
                if (DayOfWeek.SUNDAY.equals(startDt.getDayOfWeek()) || startDt.equals(endDay)) {
                    Path filePath = Paths.get(targetDir + File.separator + filename);
                    Path target = createTargetPath(targetDir + File.separator + filename);
                    Objects.requireNonNull(target);
                    Collections.reverse(weekLines);
                    // 写入到文件中
                    Files.write(filePath, weekLines, StandardOpenOption.APPEND);
                    // 周日修改文件名=下周一
                    filename = DAY_FORMATTER.format(startDt.plusDays(1)) + ".txt";
                    // 清空
                    weekLines.clear();
                }
                startDt = startDt.plusDays(1);
            }
            return true;
        } catch (Exception e) {
            LOGGER.error("异常：", e);
            return false;
        }
    }

    /**
     * 生成分隔线
     */
    private static String getSplitLine(long count) {
        return Stream.iterate("-", i -> "-")
                .limit(count).collect(Collectors.joining());
    }

    /**
     * 在指定目录下生成工作日志文件
     */
    public static boolean buildCurrentYearWorkLog(String targetDir) throws URISyntaxException {
        Path target = createTargetPath(targetDir);

        URI templateUri = Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
                .getResource(TEMPLATE_NAME)).toURI();
        Path template = Paths.get(templateUri);

        LocalDate tmp = LocalDate.now();
        LocalDate endDay = LocalDate.of(tmp.getYear(), Month.DECEMBER, Month.DECEMBER.length(tmp.isLeapYear()));
        String filename = "";
        while (tmp.isBefore(endDay)) {
            tmp = tmp.plusDays(1);
            if (isWeekDay(tmp.getDayOfWeek())) {
                continue;
            }
            filename = DAY_FORMATTER.format(tmp) + ".txt";
            try {
                Files.copy(template, Paths.get(target + "/" + filename));
            } catch (IOException e) {
                LOGGER.error("error:", e);
            }
        }
        return true;
    }

    private static boolean isWeekDay(DayOfWeek dayOfWeek) {
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }

    private static Path createTargetPath(String targetPath) {
        Path target = Paths.get(targetPath);
        try {
            if (Files.exists(target)) {
                Files.deleteIfExists(target);
            }
            if (!Files.exists(target)) {
                if (Files.isDirectory(target)) {
                    Files.createDirectories(target);
                } else {
                    Files.createFile(target);
                }
            }
            return target;
        } catch (IOException e) {
            LOGGER.error("", e);

        }
        return null;
    }

    static {
        WEEK_MAP.put(DayOfWeek.MONDAY, "星期一");
        WEEK_MAP.put(DayOfWeek.TUESDAY, "星期二");
        WEEK_MAP.put(DayOfWeek.WEDNESDAY, "星期三");
        WEEK_MAP.put(DayOfWeek.THURSDAY, "星期四");
        WEEK_MAP.put(DayOfWeek.FRIDAY, "星期五");
    }

    private WorkLogByKPTP() {
    }
}
