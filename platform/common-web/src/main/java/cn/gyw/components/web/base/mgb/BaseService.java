package cn.gyw.components.web.base.mgb;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService<T, Example> implements IBaseService<T, Example> {

	public final Logger log = LoggerFactory.getLogger(this.getClass());

	protected String entityClassFullName;
	protected String entityClassSimpleName;
	protected Class<T> entityClass;

	private BaseDao<T, Example> baseDao;
	private static final String SUFFIX = "Mapper";

	@Override
	public List<T> query(Example example) {
		return baseDao.selectByExample(example);
	}

	@Override
	public List<T> queryAll() {
		return baseDao.selectByExample(null);
	}

	@Override
	public int save(T record) {
		return baseDao.insertSelective(record);
	}

	@Override
	public int remove(Example example) {
		return baseDao.deleteByExample(example);
	}

	@Override
	public T selectOne(Example example) {
		List<T> dataList = baseDao.selectByExample(example);
		if (dataList != null && dataList.size() > 0) {
			return dataList.get(0);
		}
		return null;
	}

	/**
	 * 初始化方法
	 */
	@PostConstruct
	@SuppressWarnings("unchecked")
	public void init() throws IllegalAccessException {
		Type genericInterfaces = this.getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genericInterfaces).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
		entityClassFullName = entityClass.getName();
		entityClassSimpleName = entityClass.getSimpleName();
		StringBuilder serviceBuilder = new StringBuilder();
		serviceBuilder.append(entityClassSimpleName.substring(0, 1).toLowerCase())
				.append(entityClassSimpleName.substring(1)).append(SUFFIX);
		log.info("base service name:{}", serviceBuilder.toString());
		// forceAccess: 访问非public 属性
		baseDao = (BaseDao<T, Example>) FieldUtils.readField(this, serviceBuilder.toString(), true);
	}

}
