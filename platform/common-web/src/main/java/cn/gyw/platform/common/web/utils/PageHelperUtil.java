package cn.gyw.platform.common.web.utils;

import cn.gyw.platform.common.web.model.PageData;
import com.github.pagehelper.PageInfo;

public class PageHelperUtil {

    /**
     * 将PageHelper分页后的Page转为分页信息
     */
    public static <T> PageData<T> resetPage(PageInfo<T> page) {
        PageData<T> result = new PageData<>();
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setTotalPage(page.getPages());
        result.setTotal(page.getTotal());
        result.setRecords(page.getList());
        return result;
    }

    private PageHelperUtil() {
    }
}
