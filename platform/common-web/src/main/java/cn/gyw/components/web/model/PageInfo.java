package cn.gyw.components.web.model;

import java.io.Serializable;

public class PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean hasmore;

    private int page;
    
    private int limit;

    private int count;

    private long total;
    
    public PageInfo() {
	}

	public PageInfo(int count, int limit) {
    	this.count = count;
    	this.limit = limit;
    }

	public boolean isHasmore() {
		return hasmore;
	}

	public void setHasmore(boolean hasmore) {
		this.hasmore = hasmore;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
