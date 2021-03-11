package cn.gyw.community.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.system.service.IRedisService;

@RestController
public class StatsController {

    @Autowired
    private IRedisService redisService;
    
    @GetMapping("/stats/userLogin")
    public Map<String, Long> userLoginRank(@RequestParam("userId") String userId) {
        
        Map<String, Long> data = new HashMap<>();
        
        data.put(userId, redisService.daysOfUserLogin(userId));
        
        return data;
    }
}
