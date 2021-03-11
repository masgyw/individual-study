package cn.gyw.community.system.service.impl;

import static cn.gyw.community.system.constants.RedisKeys.KEY_SEPARATOR;
import static cn.gyw.community.system.constants.RedisKeys.USER_LOGIN;

import java.io.Serializable;
import java.time.LocalDate;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.gyw.community.system.service.IRedisService;

@Service("redisService")
public class RedisServiceImpl implements IRedisService {
    
    private final static Logger LOG = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Resource(name="serialRedisTemplate")
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public boolean userLogin(String userId) {
        String key = USER_LOGIN + KEY_SEPARATOR + userId;
        boolean ret = redisTemplate.opsForValue().setBit(key, LocalDate.now().getDayOfYear(), true);
        LOG.debug("user login save redis result:{}", ret);
        return ret;
    }

    @Override
    public Long daysOfUserLogin(String userId) {
        String key = USER_LOGIN + KEY_SEPARATOR + userId;
        return redisTemplate.execute((RedisCallback<Long>) con -> con.bitCount(key.getBytes()));
    }
    
}
