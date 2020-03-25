package com.java.app.p7;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONObject;

@Controller
public class OpenAPI {

	@RequestMapping("/view")
	public String view(Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name",   "자바");
		map.put("age",    20);
		map.put("gender", "여자");
		
		JSONObject jObject = JSONObject.fromObject(map);
		
		model.addAttribute("data", jObject.toString());
		return "view";
	}
	
}
