package cn.gyw.components.web.base.mgb;

import java.util.List;

public interface IBaseService<T, Example> {

	List<T> queryAll();
	
	List<T> query(Example example);
	
	int remove(Example example);
	
	int save(T record);
	
	T selectOne(Example example);
}
