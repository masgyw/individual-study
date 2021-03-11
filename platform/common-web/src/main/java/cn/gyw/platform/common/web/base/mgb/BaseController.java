package cn.gyw.platform.common.web.base.mgb;

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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.gyw.platform.common.web.base.AbstractController;
import cn.gyw.platform.common.web.enums.ArgumentExceptionEnum;
import cn.gyw.platform.common.web.model.PageInfo;
import cn.gyw.platform.common.web.model.QueryData;

/**
 * TODO： Controller 不能直接使用DAO 层的T 和 Example
 *
 * @param <T>
 * @param <Example>
 * @param <Dto>
 */
public abstract class BaseController<T, Example, Dto> extends AbstractController {

	public final Logger log = LoggerFactory.getLogger(this.getClass());

	protected String entityClassFullName;
	protected String entityClassSimpleName;
	protected Class<T> entityClass;
	protected Class<Example> exampleClass;

	private IBaseService<T, Example> baseService;
	
	@GetMapping
	public List<T> query(WebRequest webRequest) {
		Example example = buildExample(fillVariablesMapWithIncomingRequestParameters(webRequest.getParameterMap()));
		return baseService.query(example);
	}

	@GetMapping("/")
	public QueryData<T> queryByPage(WebRequest webRequest) {
		Map<String, String> params = fillVariablesMapWithIncomingRequestParameters(webRequest.getParameterMap());
		QueryData<T> queryData = new QueryData<>();
		Example example = buildExample(params);
		String page = params.get("page");
		String limit = params.get("limit");
		ArgumentExceptionEnum.NULL_ERROR.assertNotNull(page, "page");
		ArgumentExceptionEnum.NULL_ERROR.assertNotNull(limit, "limit");
		
		Page<T> pageObj = PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
		List<T> data = baseService.query(example);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setTotal(pageObj.getTotal());
		pageInfo.setPage(pageObj.getPageNum());
		pageInfo.setLimit(pageObj.getPageSize());
		pageInfo.setCount(pageObj.getPages());
		
		queryData.setRecords(data);
		queryData.setPageInfo(pageInfo);
		return queryData;
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public int add(@RequestBody Dto dto) throws IllegalAccessException, InstantiationException {
		log.info("Add api data：{}", dto);
		T bean = entityClass.newInstance();
		BeanUtils.copyProperties(dto, bean);
		log.info("Add api entity is :{}", bean);
		return baseService.save(bean);
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@DeleteMapping
	public int delete(WebRequest webRequest) throws IllegalAccessException, InstantiationException {
		Example example = buildExample(fillVariablesMapWithIncomingRequestParameters(webRequest.getParameterMap()));
		return baseService.remove(example);
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
		baseService = (IBaseService<T, Example>) FieldUtils.readField(this, serviceBuilder.toString(), true);

		exampleClass = (Class<Example>) params[1];
	}

	public Example buildExample(Map<String, String> requestMap) {
		return null;
	}

}
