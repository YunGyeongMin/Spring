package com.java.app.p12;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NOTICE_Controller {

	@Autowired private NOTICE_Service_Interface service;
	
	@GetMapping("/notice")
	public String index(HttpSession session) {
		session.invalidate();
		return "notice/index";
	}
	@GetMapping("/main")
	public String main(HttpSession session) {
		if(session.getAttribute("USER") == null) {
			return "redirect:/notice";
		}
		return "notice/main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/notice";
	}
	
	@PostMapping("/login")
	public @ResponseBody Map<String, Object> login(@RequestBody NOTICE_User user, HttpSession session) {
		return service.login(user, session);
	}
	
	@PostMapping("/insert")
	public @ResponseBody Map<String, Object> insert(@RequestBody NOTICE_Bean bean, HttpSession session) {
		return service.insert(bean, session);
	}
	
	@PostMapping("/select")
	public @ResponseBody Map<String, Object> select(HttpSession session) {
		return service.select(session);
	}
	
	@PostMapping("/update")
	public @ResponseBody Map<String, Object> update(@RequestBody NOTICE_Bean bean, HttpSession session) {
		return service.update(bean, session);
	}
	
	@PostMapping("/delete")
	public @ResponseBody Map<String, Object> delete(@RequestBody NOTICE_Bean bean, HttpSession session) {
		return service.delete(bean, session);
	}
}
