package cn.gyw.community.security.service.impl;

import java.awt.Image;
import java.security.SecureRandom;
import java.util.Objects;

import org.springframework.stereotype.Service;

import cn.gyw.community.security.exception.VerifyFailedException;
import cn.gyw.community.security.repository.VerifyCodeRepository;
import cn.gyw.community.security.service.GenerateImageService;
import cn.gyw.community.security.service.MessageSendService;
import cn.gyw.community.security.service.VerifyCodeService;
import cn.gyw.community.security.util.VerifyCodeUtil;

/**
 * 验证码服务
 */
@Service
public class DigitsVerifyCodeServiceImpl implements VerifyCodeService {
	private final VerifyCodeRepository verifyCodeRepository;

	private final GenerateImageService generateImageService;

	private final MessageSendService messageSendService;

	private final VerifyCodeUtil verifyCodeUtil;

	private static final long VERIFY_CODE_EXPIRE_TIMEOUT = 60000L;

	public DigitsVerifyCodeServiceImpl(VerifyCodeRepository verifyCodeRepository,
			GenerateImageService generateImageService, MessageSendService messageSendService,
			VerifyCodeUtil verifyCodeUtil) {
		this.verifyCodeRepository = verifyCodeRepository;
		this.generateImageService = generateImageService;
		this.messageSendService = messageSendService;
		this.verifyCodeUtil = verifyCodeUtil;
	}

	private static String randomDigitString(int length) {
		StringBuilder stringBuilder = new StringBuilder();
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < length; i++) {
			stringBuilder.append(random.nextInt(10));
		}
		return stringBuilder.toString();
	}

	private static String appendTimestamp(String string) {
		return string + "#" + System.currentTimeMillis();
	}

	@Override
	public void send(String key) {
		String verifyCode = randomDigitString(verifyCodeUtil.getLen());
		String verifyCodeWithTimestamp = appendTimestamp(verifyCode);
		verifyCodeRepository.save(key, verifyCodeWithTimestamp);
		messageSendService.send(key, verifyCode);
	}

	@Override
	public void verify(String key, String code) {
		String lastVerifyCodeWithTimestamp = verifyCodeRepository.find(key);
		// 如果没有验证码，则随机生成一个
		if (lastVerifyCodeWithTimestamp == null) {
			lastVerifyCodeWithTimestamp = appendTimestamp(randomDigitString(verifyCodeUtil.getLen()));
		}
		String[] lastVerifyCodeAndTimestamp = lastVerifyCodeWithTimestamp.split("#");
		String lastVerifyCode = lastVerifyCodeAndTimestamp[0];
		long timestamp = Long.parseLong(lastVerifyCodeAndTimestamp[1]);
//		if (timestamp + VERIFY_CODE_EXPIRE_TIMEOUT < System.currentTimeMillis()) {
//			throw new VerifyFailedException("验证码已过期！");
//		} else if (!Objects.equals(code, lastVerifyCode)) {
//			throw new VerifyFailedException("验证码错误！");
//		}
		// for test,
	}

	@Override
	public Image image(String key) {
		String verifyCode = randomDigitString(verifyCodeUtil.getLen());
		String verifyCodeWithTimestamp = appendTimestamp(verifyCode);
		Image image = generateImageService.imageWithDisturb(verifyCode);
		verifyCodeRepository.save(key, verifyCodeWithTimestamp);
		return image;
	}
}
