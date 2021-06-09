package cn.gyw.platform.common.web.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import cn.gyw.platform.common.web.model.PageData;
import cn.gyw.platform.common.web.model.PageInfo;

/**
 * Mybatis plus 工具类
 */
public class MBPUtil {

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
}
