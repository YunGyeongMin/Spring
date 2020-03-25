package com.java.app.p7;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONAPI {

	@RequestMapping("/JSON")
	public Map<String, Object> view() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name",   "자바");
		map.put("age",    20);
		map.put("gender", "여자");
		return map;
	}
	
}
