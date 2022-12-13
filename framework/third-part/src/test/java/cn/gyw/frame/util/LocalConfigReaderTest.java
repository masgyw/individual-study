package cn.gyw.frame.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocalConfigReaderTest {

    @Test
    void read() {
        System.out.println(LocalConfigReader.read("test-1", this.getClass()));
    }

    @Test
    void write() {
        LocalConfigReader.write("test-1", "demo", this.getClass());
    }
}