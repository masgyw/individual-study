package cn.gyw.platform.common.web.base.mgb;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.WebRequest;

import cn.gyw.platform.common.web.base.AbstractController;
import cn.gyw.platform.common.web.enums.CommonRespEnum;
import cn.gyw.platform.common.web.model.PageData;
import cn.gyw.platform.common.web.utils.BeanMapUtil;
import cn.gyw.platform.common.web.utils.PageHelperUtil;

/**
 * 通用Controller
 * 
 * @param <T>
 * @param <DTO>
 */
public abstract class BaseController<T, DTO> extends AbstractController {

	protected static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	protected String entityClassFullName;
	protected String entityClassSimpleName;
	protected Class<T> entityClass;

	private IBaseService<T> baseService;

	@GetMapping
	public List<T> query(WebRequest webRequest) {
		Map<String, Object> params = fillVariablesMapWithIncomingRequestParameters(webRequest.getParameterMap());
		log.debug("query params:{}", params);
		T condition;
		try {
			condition = BeanMapUtil.mapToBean(params, entityClass);
			log.debug("query condition bean :{}", condition);
			List<T> data = baseService.query(condition);
			return data;
		} catch (Exception e) {
			log.error("New instance error :", e);
		}
		return null;
	}

	@GetMapping("/")
	public PageData<T> queryByPage(WebRequest webRequest) {
		Map<String, Object> params = fillVariablesMapWithIncomingRequestParameters(webRequest.getParameterMap());
		log.debug("queryByPage params:{}", params);
		String pageNum = params.get("pageNum").toString();
		String pageSize = params.get("pageSize").toString();
		CommonRespEnum.PARAM_NULL.assertNotNull(pageNum, "page");
		CommonRespEnum.PARAM_NULL.assertNotNull(pageNum, "limit");
		T condition;
		try {
			condition = BeanMapUtil.mapToBean(params, entityClass);
			log.debug("query condition bean :{}", condition);
			List<T> data = baseService.query(condition, Integer.parseInt(pageNum), Integer.parseInt(pageSize));
			return PageHelperUtil.resetPage(data);
		} catch (Exception e) {
			log.error("Map to bean error :", e);
		}
		return null;
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public int add(@RequestBody DTO dto) throws IllegalAccessException, InstantiationException {
		log.info("add data：{}", dto);
		T bean = entityClass.newInstance();
		BeanUtils.copyProperties(dto, bean);
		return baseService.save(bean);
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@DeleteMapping
	public int delete(@RequestBody DTO dto) throws IllegalAccessException, InstantiationException {
		log.info("delete data：{}", dto);
		T bean = entityClass.newInstance();
		BeanUtils.copyProperties(dto, bean);
		return baseService.remove(bean);
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
				.append(entityClassSimpleName.substring(1)).append("Service");
		log.info("base service name:{}", serviceBuilder.toString());
		// forceAccess: 访问非public 属性
		baseService = (IBaseService<T>) FieldUtils.readField(this, serviceBuilder.toString(), true);
	}

}
