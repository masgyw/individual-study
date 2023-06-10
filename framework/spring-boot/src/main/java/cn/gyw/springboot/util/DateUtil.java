package cn.gyw.springboot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @date 2023/6/10
 */
public final class DateUtil {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    public static String currentMill() {
        return DTF.format(LocalDateTime.now());
    }

    private DateUtil() {
        throw new UnsupportedOperationException();
    }
}
