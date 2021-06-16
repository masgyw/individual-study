package cn.gyw.platform.common.web.base.mgb;

import java.util.List;

public interface IBaseService<T> {

	List<T> queryAll();

	List<T> query(T condition);
	
	List<T> query(T condition, Integer pageNum, Integer pageSize);

	int remove(T record);

	int save(T record);

	T selectOne(T record);

}
