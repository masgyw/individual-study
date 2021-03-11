package cn.gyw.community.system.service;

public interface IRedisService {

    boolean userLogin(String userId);
    
    Long daysOfUserLogin(String userId);
}
