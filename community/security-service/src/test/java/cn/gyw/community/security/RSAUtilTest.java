package cn.gyw.community.security;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

import org.junit.Before;
import org.junit.Test;

import cn.gyw.community.security.util.RSAUtil;

public class RSAUtilTest {

	private KeyStore keyStore;
	private String keyFile = "rsa/server.p12";
	private String keyPass = "123456";
	private String storePass = "123456";

	private String alais = "serverkey";

	@Before
	public void loadP12File() {
		try {
			keyStore = KeyStore.getInstance("PKCS12");
			InputStream fis = this.getClass().getClassLoader().getResourceAsStream(keyFile);
			char[] password = keyPass.toCharArray();
			keyStore.load(fis, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成公钥、私钥文件
	 */
	@Test
	public void createPubAndPriKey() {
		try {
			Certificate certificate = keyStore.getCertificate(alais);
			PublicKey publicKey = certificate.getPublicKey();
			PrivateKey privateKey = (PrivateKey) keyStore.getKey(alais, storePass.toCharArray());
			
			RSAUtil.generatePublicKey(publicKey);
			RSAUtil.generatePrivateKey(privateKey);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 私钥加密/公钥解密
	 * 
	 * @throws Exception
	 */
	@Test
	public void encrypt() throws Exception {
		PrivateKey privateKey = RSAUtil.getPrivateKey("rsa/rsa.pri");

		byte[] emsg = RSAUtil.encrypt("this is new Message", privateKey);

		PublicKey publicKey = RSAUtil.getPublicKey("rsa/rsa.pub");

		String result = new String(RSAUtil.decrypt(emsg, publicKey), "UTF-8");
		System.out.println(">>" + result);
	}
}
