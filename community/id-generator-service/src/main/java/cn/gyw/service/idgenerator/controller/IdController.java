package cn.gyw.service.idgenerator.controller;

import cn.gyw.service.idgenerator.dto.IdStrategyDto;
import cn.gyw.service.idgenerator.service.IdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdController {

    private IdGeneratorService idGeneratorService;

    @GetMapping("/{bizTag}")
    public IdStrategyDto currentId(@PathVariable("bizTag") String bizTag) {
        return this.idGeneratorService.queryAndUpdate(bizTag);
    }

    @Autowired
    public void setIdGeneratorService(IdGeneratorService idGeneratorService) {
        this.idGeneratorService = idGeneratorService;
    }
}
