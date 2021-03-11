package cn.gyw.platform.common.web.base.mgb;

import java.util.List;

public abstract class AbstractDao<Record, Example> implements BaseDao<Record, Example> {

	public Record selectOne(Example example) {
		List<Record> list = selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
