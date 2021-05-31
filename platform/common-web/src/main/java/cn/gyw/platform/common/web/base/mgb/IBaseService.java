package cn.gyw.platform.common.web.base.mgb;

import java.util.List;

import tk.mybatis.mapper.entity.Example;

public interface IBaseService<T> {

	List<T> queryAll();

	List<T> query(Example example);

	int remove(Example example);

	int save(T record);

	T selectOne(T record);

	T selectOne(Example example);

}
