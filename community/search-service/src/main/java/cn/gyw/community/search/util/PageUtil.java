package cn.gyw.community.search.util;

import cn.gyw.platform.common.web.model.PageData;
import org.springframework.data.domain.Page;


/**
 * 分页工具
 */
public final class PageUtil {

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

    private PageUtil() {}
}
