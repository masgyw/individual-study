package cn.gyw.components.web.model;

import java.util.List;

/**
 * 分页返回值
 * @param <E>
 */
public class QueryDataResponse<E> extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	private QueryData<E> data;

	public QueryDataResponse() {
		data = new QueryData<>();
		data.setPageInfo(new PageInfo());
	}
	
    public QueryData<E> getData() {
        return data;
    }

    public void setData(QueryData<E> data) {
        this.data = data;
    }
    
    public void setData(List<E> list) {
    	data.setRecords(list);
    }
    
    public void setPageInfo(int page, int limit, int total) {
    	PageInfo pageInfo = data.getPageInfo();
    	pageInfo.setPage(page);
    	pageInfo.setLimit(limit);
    	pageInfo.setTotal(total);
    }
}
