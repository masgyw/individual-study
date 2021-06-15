package cn.gyw.platform.common.web.base.mgb;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.github.pagehelper.PageInfo;
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

import com.github.pagehelper.PageHelper;

import cn.gyw.platform.common.web.base.AbstractController;
import cn.gyw.platform.common.web.enums.CommonRespEnum;
import cn.gyw.platform.common.web.model.DataResponse;
import cn.gyw.platform.common.web.model.PageData;
import cn.gyw.platform.common.web.utils.PageHelperUtil;
import tk.mybatis.mapper.entity.Example;

/**
 * 通用Controller
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
		Example example = buildExample(fillVariablesMapWithIncomingRequestParameters(webRequest.getParameterMap()));
		return baseService.query(example);
	}

	@GetMapping("/")
	public DataResponse<PageData<T>> queryByPage(WebRequest webRequest) {
		Map<String, String> params = fillVariablesMapWithIncomingRequestParameters(webRequest.getParameterMap());
		// PageData<T> pageData = new PageData<>();
		Example example = buildExample(params);
		String page = params.get("page");
		String limit = params.get("limit");
		CommonRespEnum.PARAM_NULL.assertNotNull(page, "page");
		CommonRespEnum.PARAM_NULL.assertNotNull(limit, "limit");

		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
		List<T> data = baseService.query(example);
		PageInfo<T> pageObj = new PageInfo<>(data);
		return DataResponse.success(PageHelperUtil.resetPage(pageObj));
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public int add(@RequestBody DTO dto) throws IllegalAccessException, InstantiationException {
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
		baseService = (IBaseService<T>) FieldUtils.readField(this, serviceBuilder.toString(), true);
	}

	public Example buildExample(Map<String, String> requestMap) {
		return null;
	}

}
