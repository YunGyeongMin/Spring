package com.java.app.p6;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {

	@Autowired
	SqlSession session;
	
	@RequestMapping("/DB")
	public String view() {
		int result = session.selectOne("test.test");
		System.out.println("result : " + result);
		return "view";
	}
	
}
