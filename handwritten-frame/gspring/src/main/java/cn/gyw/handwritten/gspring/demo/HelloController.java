package cn.gyw.handwritten.gspring.demo;

import cn.gyw.handwritten.gspring.annotation.GController;
import cn.gyw.handwritten.gspring.annotation.GRequestMapping;
import cn.gyw.handwritten.gspring.web.servlet.GModelAndView;

@GController
@GRequestMapping("/hello")
public class HelloController {

	@GRequestMapping
	public GModelAndView sayHello() {
		System.out.println("111111>>>");
		
		return new GModelAndView("404");
	}
}
