package cn.gyw.community.security.service;

import java.awt.Image;

/**
 * 验证码图片生成服务
 */
public interface GenerateImageService {

	Image imageWithDisturb(String string);
	
}
