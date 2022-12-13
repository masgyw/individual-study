package cn.gyw.corejava;

import cn.gyw.corejava.util.SystemUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 系统工具类测试
 */
public class SystemUtilTest {

    public static void main(String[] args) throws IOException {
        byte[] bytes = Files.readAllLines(Paths.get("D:\\3.txt")).get(0).getBytes(StandardCharsets.UTF_8);

        OutputStream outputStream = new FileOutputStream("D:\\5.pdf");

        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        bos.write(bytes);

        bos.flush();
    }

	
	@Test
	public void showSystemProperties() {
		SystemUtil.printProperties();
	}

    @Test
    public void getCpuNums() {
        System.out.println(SystemUtil.getCpuCnt());
    }

}
