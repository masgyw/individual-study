package cn.gyw.community.security.util;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * RSA 非对称加密工具
 * 
 * 生成公钥和私钥
 * 
 * 说明： 1. 同时生成两把密钥：私钥和公钥，私钥隐秘保存，公钥可以下发给信任客户端 2. 私钥加密，持有私钥或公钥才可以解密 3.
 * 公钥加密，持有私钥才可解密
 */
public final class RSAUtil {

	public static final String KEY_ALGORITHM = "RSA"; // 加密算法RSA

	private static final String publicKeyFile = "rsa.pub";
	private static final String privateKeyFile = "rsa.pri";
	
	public static final Charset UTF8 = Charset.forName("UTF-8");

	// TODO: 可以使用spring bean 管理
	private static RSAPublicKey rsaPublicKey;
	private static RSAPrivateKey rsaPrivateKey;
	static {
		// 初始化加载公钥、私钥文件
		rsaPublicKey = getRsaPublicKey("rsa/rsa.pub");
		rsaPrivateKey = getRsaPrivateKey("rsa/rsa.pri");
	}
	
	public static RSAPublicKey getDefaultPublicKey() {
		return rsaPublicKey;
	}
	
	public static RSAPrivateKey getDefaultPrivateKey() {
		return rsaPrivateKey;
	}

	public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
		final int keySize = 2048;
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGenerator.initialize(keySize);
		return keyPairGenerator.genKeyPair();
	}

	/**
	 * 私钥加密
	 * 
	 * @param data
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(String message, PrivateKey privateKey) throws Exception {
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);

		return cipher.doFinal(message.getBytes(UTF8));
	}

	/**
	 * 公钥解密
	 * 
	 * @param publicKey
	 * @param encrypted
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] encrypted, PublicKey publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, publicKey);

		return cipher.doFinal(encrypted);
	}

	/**
	 * 从文件中获取公钥
	 * 
	 * @param filePath
	 * @return
	 */
	public static PublicKey getPublicKey(String filePath) {
		byte[] bytes;
		try {
			bytes = readFile(filePath);
			return getPublicKey(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static RSAPublicKey getRsaPublicKey(String filePath) {
		return (RSAPublicKey) getPublicKey(filePath);
	}

	/**
	 * 从文件获取私钥
	 * @param filePath
	 * @return
	 */
	public static PrivateKey getPrivateKey(String filePath) {
		byte[] bytes;
		try {
			bytes = readFile(filePath);
			return getPrivateKey(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static RSAPrivateKey getRsaPrivateKey(String filePath) {
		return (RSAPrivateKey) getPrivateKey(filePath);
	}

	/**
	 * 获取公钥
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static PublicKey getPublicKey(byte[] bytes) throws Exception {
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
		return keyFactory.generatePublic(keySpec);
	}

	/**
	 * 获取私钥
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(byte[] bytes) throws Exception {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		return keyFactory.generatePrivate(keySpec);
	}
	
	/**
	 * 生成公钥文件
	 * @param publicKey
	 * @throws IOException
	 */
	public static void generatePublicKey(PublicKey publicKey) throws IOException {
		writeFile(publicKeyFile, publicKey.getEncoded());
	}

	/**
	 * 生成私钥文件
	 * @param privateKey
	 * @throws IOException
	 */
	public static void generatePrivateKey(PrivateKey privateKey) throws IOException {
		writeFile(privateKeyFile, privateKey.getEncoded());
	}

	private static byte[] readFile(String fileName) throws IOException, URISyntaxException {
		URI uri = RSAUtil.class.getClassLoader().getResource(fileName).toURI();
		return Files.readAllBytes(Paths.get(uri));
	}

	private static void writeFile(String fileName, byte[] bytes) {
		try {
			Files.write(buildPath(fileName), bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Path buildPath(String fileName) throws URISyntaxException {
		return new File(fileName).toPath();
	}
}
