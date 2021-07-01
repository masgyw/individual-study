package cn.gyw.community.content.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.content.entity.PrefrenceArea;
import cn.gyw.community.content.dto.PrefrenceAreaDto;
import cn.gyw.community.content.service.PrefrenceAreaService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/prefrenceArea")
public class PrefrenceAreaController extends BaseController<PrefrenceArea,PrefrenceAreaDto> {

    @Autowired
    private PrefrenceAreaService prefrenceAreaService;
	
}
