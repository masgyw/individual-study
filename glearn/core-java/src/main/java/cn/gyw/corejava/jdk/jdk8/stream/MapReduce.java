package cn.gyw.corejava.jdk.jdk8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author
 * @desc 并行读取所有日志、映射、排序和过滤相关日志条目，收集和规约结果，如果产生结果，则将其打印到控制台，
 * 导入的日期、时间用于排序比较，flatMap代码用于处理异常
 * @createdTime 2022/8/16
 */
public class MapReduce {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public void run() {
        try (Stream<Path> files = Files.find(Paths.get("D:/"), 1,
                (path, attr) -> String.valueOf(path).endsWith(".log"))) {
            files.parallel()
                    .flatMap(x -> {
                        try {
                            return Files.lines(x);
                        } catch (IOException e) {
                        }
                        return null;
                    })
                    .filter(x -> x.contains("242355"))
                    .map(x -> x.substring(0, 23) + " " + x.split(":")[3])
                    .sorted((x, y) -> LocalDateTime.parse(x.substring(0, 23), dtf)
                            .compareTo(LocalDateTime.parse(y.substring(0, 23), dtf)))
                    .collect(Collectors.toList()).stream().sequential()
                    .reduce((acc, x) -> {
                        if (acc.length() > 0) {
                            Long duration = Long.valueOf(Duration.between(LocalDateTime.parse(acc.substring(0, 23), dtf),
                                    LocalDateTime.parse(x.substring(0, 23), dtf)).toMillis());
                            acc += "n after " + duration.toString() + "ms" + x.substring(24);
                        } else {
                            acc = x;
                        }
                        return acc;
                    }).ifPresent(System.out::println);
        } catch (Exception e) {

        }
    }
}
