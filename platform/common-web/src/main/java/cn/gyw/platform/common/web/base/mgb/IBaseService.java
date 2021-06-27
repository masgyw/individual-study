package cn.gyw.platform.common.web.base.mgb;

import java.util.List;
import java.util.Map;

public interface IBaseService<T> {

	List<T> queryAll();

	List<T> query(T condition);
	
	List<T> query(Map<String, Object> params, Integer pageNum, Integer pageSize);

	int remove(Object key);

	int save(T record);

	int update(T record);

	T selectOne(T record);
}
