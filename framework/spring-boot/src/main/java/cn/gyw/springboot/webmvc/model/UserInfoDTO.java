package cn.gyw.springboot.webmvc.model;

import cn.gyw.springboot.util.UserGenerator;
import lombok.Data;

import java.util.Date;

/**
 * @date 2023/6/10
 */
@Data
public class UserInfoDTO {

    private String name;
    private Integer age;
    private String gender;
    private String birthday;
    private Date createTime;

    public static UserInfoDTO newUser() {
        UserInfoDTO user = new UserInfoDTO();
        user.setName(UserGenerator.getName());
        user.setAge(UserGenerator.getAge());
        user.setGender("0");
        user.setBirthday("20001111");
        user.setCreateTime(new Date());
        return user;
    }

    @Data
    public static class DetailInfo {
        private String nation;
        private String vocation;
        private String address;
    }
}
