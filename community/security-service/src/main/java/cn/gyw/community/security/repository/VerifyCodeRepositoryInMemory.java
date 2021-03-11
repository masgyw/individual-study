package cn.gyw.community.security.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

@Repository
public class VerifyCodeRepositoryInMemory implements VerifyCodeRepository {

	private static final Map<String, String> REPOSITORY = new ConcurrentHashMap<>();

	@Override
	public void save(String key, String code) {
		REPOSITORY.put(key, code);
	}

	@Override
	public String find(String key) {
		return REPOSITORY.get(key);
	}

	@Override
	public void remove(String key) {
		REPOSITORY.remove(key);
	}

}
