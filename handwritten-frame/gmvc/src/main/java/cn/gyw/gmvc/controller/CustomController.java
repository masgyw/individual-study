package cn.gyw.gmvc.controller;

import cn.gyw.gmvc.annotation.MyAutowired;
import cn.gyw.gmvc.annotation.MyController;
import cn.gyw.gmvc.annotation.MyRequestMapping;
import cn.gyw.gmvc.annotation.MyRequestParam;
import cn.gyw.gmvc.service.CustomService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MyController
@MyRequestMapping(value = "/custom")
public class CustomController {

	@MyAutowired(value = "customService")
	private CustomService customService;

	@MyRequestMapping(value = "/all")
	public void queryAll(HttpServletRequest request, HttpServletResponse response,
			@MyRequestParam(value = "name") String name,
			@MyRequestParam(value = "age") String age) {
//		List<String> datas = customService.queryAll(name, age);
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write("Hello " + name + ", age = " + age);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@MyRequestMapping(value = "/add")
	public void add(@MyRequestParam(value = "name") String name) {
		System.out.println("add data");
	}

}
