package cn.gyw.community.security.util;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * Java web token util
 */
public final class JwtUtil {
	
	public static final String AUTHORIZATION = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer";
	
	/**
	 * 生成Token
	 * 
	 * @param subject
	 * @param claimMap
	 * @param expirationTime
	 * @return
	 */
	public static String createToken(String subject, Map<String, String> claimMap, long expirationTime,
			RSAPublicKey publicKey, RSAPrivateKey privateKey) {
		JWTCreator.Builder builder = JWT.create();
		builder.withSubject(subject);
		claimMap.forEach((key, value) -> {
			builder.withClaim(key, value);
		});
		builder.withExpiresAt(new Date(System.currentTimeMillis() + expirationTime));
		return builder.sign(Algorithm.RSA256(publicKey, privateKey));
	}

	private JwtUtil() {
	}
}
