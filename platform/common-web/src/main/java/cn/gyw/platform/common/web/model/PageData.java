package cn.gyw.platform.common.web.model;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据对象
 */
public class PageData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private PageInfo pageInfo;

    private List<T> records;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
