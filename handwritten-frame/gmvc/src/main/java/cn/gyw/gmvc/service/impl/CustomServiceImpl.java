package cn.gyw.gmvc.service.impl;

import cn.gyw.gmvc.annotation.MyService;
import cn.gyw.gmvc.service.CustomService;

import java.util.Arrays;
import java.util.List;

@MyService(value = "customService")
public class CustomServiceImpl implements CustomService {

	@Override
	public List<String> queryAll(String... args) {
		return Arrays.asList(args);
	}

}
