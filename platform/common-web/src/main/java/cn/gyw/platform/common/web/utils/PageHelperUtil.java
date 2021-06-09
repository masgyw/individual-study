package cn.gyw.platform.common.web.utils;

import com.github.pagehelper.Page;

import cn.gyw.platform.common.web.model.PageData;
import cn.gyw.platform.common.web.model.PageInfo;

public class PageHelperUtil {

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
}
