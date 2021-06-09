package cn.gyw.platform.common.web.utils;

import org.springframework.data.domain.Page;

import cn.gyw.platform.common.web.model.PageData;
import cn.gyw.platform.common.web.model.PageInfo;

/**
 * 基于Spring data 工具类
 */
public class SpringDataUtil {

	/**
	 * 将SpringData分页后的Page转为分页信息
	 */
	public static <T> PageData<T> resetPage(Page<T> page) {
		PageData<T> result = new PageData<>();
		PageInfo pageInfo = PageInfo.Builder.aPageInfo().pageNum(page.getNumber()).pageSize(page.getSize())
				.total(page.getTotalElements()).totalPage(page.getTotalPages()).build();
		result.setRecords(page.getContent());
		result.setPageInfo(pageInfo);
		return result;
	}

	private SpringDataUtil() {
	}
}
