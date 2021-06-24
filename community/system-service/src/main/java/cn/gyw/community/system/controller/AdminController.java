package cn.gyw.community.system.controller;

import cn.gyw.community.system.enums.SystemRespEnum;
import cn.gyw.platform.common.web.model.BaseResponse;
import cn.gyw.platform.common.web.model.DataResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.Admin;
import cn.gyw.community.system.dto.AdminDto;
import cn.gyw.community.system.service.AdminService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

/**
 * 后台用户管理
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController<Admin,AdminDto> {

    @Autowired
    private AdminService adminService;

    /**
     * 用户注册
     * @param adminDto
     * @return
     */
    @PostMapping(value = "/register")
    public BaseResponse register(@Validated @RequestBody AdminDto adminDto) {
        Admin umsAdmin = adminService.register(adminDto);
        if (umsAdmin == null) {
            return BaseResponse.error(SystemRespEnum.REGISTER_FAILED);
        }
        return DataResponse.success(umsAdmin);
    }



}
