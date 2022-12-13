package cn.gyw.frame.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

/**
 * @desc 本地配置文件读取工具
 * @createdTime 2022/4/20
 */
public final class LocalConfigReader {

    /**
     * 本地配置文件
     */
    private static String LOCAL_FILE = "/data/my-config.properties";

    /**
     * 从本地文件中读取配置
     *
     * @param key 键
     * @param clz 调用类
     * @return value 值
     */
    public static String read(String key, Class<?> clz) {
        Path path = Paths.get(LOCAL_FILE);
        if (Files.exists(path)) {
            Properties properties = new Properties();
            try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                properties.load(br);
                return properties.getProperty(buildKey(clz, key));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 写入到本地文件中
     *
     * @param key   键
     * @param clz   调用类
     * @param value 值
     */
    public static void write(String key, String value, Class<?> clz) {
        Path path = Paths.get(LOCAL_FILE);
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path,
                    (buildKey(clz, key) + "=" + value + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String buildKey(Class<?> clz, String key) {
        return clz.getName() + "." + key;
    }

    private LocalConfigReader() {
    }
}
