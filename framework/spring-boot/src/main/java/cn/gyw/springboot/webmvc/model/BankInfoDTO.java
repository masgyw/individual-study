package cn.gyw.springboot.webmvc.model;

import cn.gyw.springboot.util.DateUtil;
import lombok.Data;
import org.apache.commons.lang3.RandomUtils;

import java.util.Date;

/**
 * @date 2023/6/10
 */
@Data
public class BankInfoDTO {

    private String bankCode;

    private String bankName;

    private String bankAcct;

    private Date createTime;

    public static BankInfoDTO newBank() {
        BankInfoDTO data = new BankInfoDTO();
        data.setBankCode(String.valueOf(RandomUtils.nextInt(100, 999)));
        data.setBankName("测试银行");
        data.setBankAcct(DateUtil.currentMill());
        data.setCreateTime(new Date());
        return data;
    }
}
