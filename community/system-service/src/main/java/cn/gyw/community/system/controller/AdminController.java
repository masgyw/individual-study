package cn.gyw.community.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.Admin;
import cn.gyw.community.system.dto.AdminDto;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/Admin")
public class AdminController extends BaseController<Admin,AdminDto> {

}
