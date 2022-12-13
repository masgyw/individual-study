package cn.gyw.frame.thirdpart.hutool;

import cn.hutool.crypto.digest.Digester;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.crypto.symmetric.SM4;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @desc 加解密工具类测试
 * @createdTime 2022/4/20 23:28
 */
public class CryptoTest {

    /**
     * 国密SM4
     */
    @Test
    public void sm4() {
        byte[] key = new byte[1];
        SM4 sm4 = new SM4(key);
    }

    @Test
    public void fileMd5() {
        String fileName = ".txt";
        Digester digester = MD5.create();
        digester.setSalt("unicompay".getBytes());
        // 4009c93c8b274e3dbceb45ad2c42697f
        // f3ac8077f4c1d66119e55a92c9a76a35
        System.out.println(digester.digestHex(new File(fileName)));
    }

}
