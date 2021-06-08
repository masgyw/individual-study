package cn.gyw.platform.common.web.model;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据对象
 */
public class PageData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private PageInfo pageInfo;

    private List<T> records;

    /**
     * 将PageHelper分页后的Page转为分页信息
     */
    public static <T> PageData<T> resetPage(Page<T> page) {
        PageData<T> result = new PageData<>();
        PageInfo pageInfo = PageInfo.Builder.aPageInfo()
                .pageNum(page.getPageNum()).pageSize(page.getPageSize())
                .totalPage(page.getPages()).total(page.getTotal()).build();
        result.setRecords(page.getResult());
        result.setPageInfo(pageInfo);
        return result;
    }

    /**
     * 将MybatisPlus分页后的IPage转为分页信息
     */
    public static <T> PageData<T> resetPage(IPage<T> page) {
        PageData<T> result = new PageData<>();
        PageInfo pageInfo = PageInfo.Builder.aPageInfo()
                .pageNum((int) page.getCurrent()).pageSize((int) page.getSize())
                .totalPage((int) page.getPages()).total(page.getTotal()).build();
        result.setRecords(page.getRecords());
        result.setPageInfo(pageInfo);
        return result;
    }

    /**
     * 将SpringData分页后的Page转为分页信息
     */
    public static <T> PageData<T> resetPage(org.springframework.data.domain.Page<T> page) {
        PageData<T> result = new PageData<>();
        PageInfo pageInfo = PageInfo.Builder.aPageInfo()
                .pageNum(page.getNumber())
                .pageSize(page.getSize())
                .total(page.getTotalElements())
                .totalPage(page.getTotalPages()).build();
        result.setRecords(page.getContent());
        result.setPageInfo(pageInfo);
        return result;
    }

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
