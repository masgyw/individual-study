package cn.gyw.platform.common.model;

import java.util.List;

/**
 * 省市模型
 *
 * @date 2022/1/25 17:25
 */
public class ProvinceCity extends ToStringObject {

    /**
     * 名称
     */
    private String name;
    /**
     * 区域代码
     */
    private String code;
    /**
     * 子区域
     */
    private List<ProvinceCity> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ProvinceCity> getChildren() {
        return children;
    }

    public void setChildren(List<ProvinceCity> children) {
        this.children = children;
    }
}
