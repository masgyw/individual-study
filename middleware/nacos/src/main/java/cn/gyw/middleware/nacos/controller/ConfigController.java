package cn.gyw.middleware.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置中心测试
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public boolean get() {
        return useLocalCache;
    }

    @GetMapping("/ping")
    public String ping() {
        return "pone";
    }

}
