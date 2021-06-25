package cn.gyw.platform.common.web.base.mgb;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageHelper;

import cn.gyw.platform.common.web.utils.BeanMapUtil;
import tk.mybatis.mapper.entity.Example;

public abstract class BaseService<T> implements IBaseService<T> {

	public final Logger log = LoggerFactory.getLogger(this.getClass());

	protected String entityClassFullName;
	protected String entityClassSimpleName;
	protected Class<T> entityClass;

	protected BaseDao<T> baseDao;
	private static final String SUFFIX = "Mapper";
	private static final String KEY_KEYWORD = "keyword";

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
		baseDao = (BaseDao<T>) FieldUtils.readField(this, serviceBuilder.toString(), true);
	}

	@Override
	public List<T> queryAll() {
		return baseDao.selectAll();
	}

	@Override
	public List<T> query(T record) {
		Example example = new Example(entityClass);
		example.createCriteria().andEqualTo(record);
		return baseDao.selectByExample(example);
	}
	
	@Override
	public List<T> query(Map<String, Object> params, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		T condition;
		try {
			condition = BeanMapUtil.mapToBean(params, entityClass);
			log.debug("query condition bean :{}", condition);
			Example example = new Example(entityClass);
			Example.Criteria criteria = example.createCriteria();
			criteria.andEqualTo(condition);
			if (params.containsKey(KEY_KEYWORD)) {
				String keywordProp = getFieldValue(KEY_KEYWORD.toUpperCase());
				criteria.andLike(keywordProp, "%" + params.get(KEY_KEYWORD) + "%");
			}
			return baseDao.selectByExample(example);
		} catch (Exception e) {
			log.error("Map to bean error :", e);
		}
		return Collections.emptyList();
	}

	@Override
	public int remove(T record) {
		Example example = new Example(entityClass);
		example.createCriteria().andEqualTo(record);
		return baseDao.deleteByExample(example);
	}

	@Override
	public int save(T record) {
		return baseDao.insertSelective(record);
	}

	@Override
	public T selectOne(T record) {
		return baseDao.selectOne(record);
	}

	private String getFieldValue(String fieldName) {
		try {
			Field field = entityClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(entityClass).toString();
		} catch (NoSuchFieldException e) {
			log.debug("No field[keyword] , do not to search by like");
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
}
