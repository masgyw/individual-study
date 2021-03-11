package cn.gyw.community.security.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.security.service.SystemDataService;

@RestController
@RequestMapping("/api")
public class HomeController {
	private final SystemDataService systemDataService;

	@Autowired
	public HomeController(SystemDataService systemDataService) {
		this.systemDataService = systemDataService;
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/home")
	public Map<String, Object> home() {
		Map<String, Object> map = new HashMap<>();
		map.put("homeMessage", "this is hello home");
		return map;
	}

	@GetMapping("/data")
	public HttpEntity select(@RequestParam(value = "id", required = false) String id) {
		if (id == null) {
			return ResponseEntity.ok().body(systemDataService.get());
		}
		return ResponseEntity.ok().body(systemDataService.select(id));
	}
}
