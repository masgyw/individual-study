package cn.gyw.components.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 分页模型
 */
public class QueryData<E> implements Serializable {

	private static final long serialVersionUID = 1L;

	private PageInfo pageInfo;

    private Collection<E> records = new ArrayList<>();

    public QueryData() {
    }

	public PageInfo getPageInfo() {
		return pageInfo;
	}
	
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public Collection<E> getRecords() {
		return records;
	}

	public void setRecords(Collection<E> records) {
		this.records = records;
	}
}
