package cn.gyw.community.product.external;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

/**
 * Dubbo RPC support
 * 
 * Note: no effective
 */
public class DubboTypeExcludeFilter extends TypeExcludeFilter implements ApplicationContextAware {

	private static final Logger LOGGER = LoggerFactory.getLogger(DubboTypeExcludeFilter.class);

	private static final String PATTERN_STANDARD = ClassUtils
			.convertClassNameToResourcePath("cn.gyw.community.product.rpc.*");

	private ApplicationContext context;

	private PathMatcher pathMatcher;

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		String className = metadataReader.getClassMetadata().getClassName();
		LOGGER.info("Current class name is :{}", className);
		if (!isPotentialPackageClass(className)) {
			return false;
		}
		return true;
	}

	private boolean isPotentialPackageClass(String className) {
		// 将类名转换为资源路径, 以进行匹配测试
		final String path = ClassUtils.convertClassNameToResourcePath(className);
		return pathMatcher.match(PATTERN_STANDARD, path);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
}
