package cn.gyw.spring.web.controller;

import cn.gyw.spring.db.service.TxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TxUserService txUserService;

    @GetMapping
    public List<Map<String, Object>> queryAll() {
        List<Map<String, Object>> datas = txUserService.findUsers();
        return datas;
    }
}
