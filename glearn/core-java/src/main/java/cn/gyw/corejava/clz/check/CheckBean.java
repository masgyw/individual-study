package cn.gyw.corejava.clz.check;

import lombok.Data;

import java.util.List;

/**
 * @date 2022/11/16
 */
@Data
public class CheckBean {

    private Person person;

    private List<Address> addressList;
}
