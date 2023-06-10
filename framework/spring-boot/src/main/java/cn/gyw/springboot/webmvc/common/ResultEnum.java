package cn.gyw.springboot.webmvc.common;

import lombok.Getter;

/**
 * @date 2023/6/10
 */
@Getter
public enum ResultEnum {

    SUCCESS("0", "成功"),
    FAIL("1000000", "失败"),
    SYSTEM_ERROR("9000000", "系统异常");

    private String code;

    private String desc;

    ResultEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
