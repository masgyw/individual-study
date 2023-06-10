package cn.gyw.springboot.webmvc.controller;

import cn.gyw.springboot.webmvc.common.JsonResult;
import cn.gyw.springboot.webmvc.common.PageResult;
import cn.gyw.springboot.webmvc.model.BankInfoDTO;
import cn.gyw.springboot.webmvc.model.UserInfoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 用户信息Controller
 *
 * @date 2023/6/10
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @RequestMapping("/info")
    public PageResult<List<UserInfoDTO>> queryUserInfo(HttpServletRequest request) {
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            String value = request.getParameter(paramName);
            System.out.println("paramName = " + paramName + " > value = " + value);
        }

        String page = request.getParameter("page");
        String pageSize = request.getParameter("rows");

        List<UserInfoDTO> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add(UserInfoDTO.newUser());
        }
        return PageResult.of(dataList, (long) dataList.size(), Integer.getInteger(pageSize), Integer.parseInt(page));
    }

    @RequestMapping("/detail")
    public JsonResult<List<UserInfoDTO.DetailInfo>> queryDetail(String name) {
        System.out.println("name = " + name);

        UserInfoDTO.DetailInfo detailInfo = new UserInfoDTO.DetailInfo();
        detailInfo.setAddress("这是一个测试的地址");
        detailInfo.setNation("中国内地");
        detailInfo.setVocation("无业游民");
        List<UserInfoDTO.DetailInfo> dataList = new ArrayList<>();
        dataList.add(detailInfo);
        return JsonResult.success(dataList);
    }

    @RequestMapping("/bankInfo")
    public JsonResult<List<BankInfoDTO>> queryBankInfo() {
        List<BankInfoDTO> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add(BankInfoDTO.newBank());
        }
        return JsonResult.success(dataList);
    }

}
