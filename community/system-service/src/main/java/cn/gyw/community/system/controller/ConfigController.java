package cn.gyw.community.system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.platform.configuration.interfaces.IConfiguration;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private IConfiguration configurationService;

    @GetMapping
    public Map<String, String> getSections() {

        System.out.println(configurationService);

        return configurationService.getSection("test");
    }
}
