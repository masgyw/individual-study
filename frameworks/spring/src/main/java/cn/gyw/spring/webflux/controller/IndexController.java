package cn.gyw.spring.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webflux")
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
