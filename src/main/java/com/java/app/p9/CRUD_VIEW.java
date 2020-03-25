package com.java.app.p9;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CRUD_VIEW {

	@Autowired private CRUD_Service service;
	
	@GetMapping("/crud/view")
	public ModelAndView view(HttpServletRequest req, ModelAndView mav) {
		mav.addObject("list", service.getMessage(req.getParameter("keyword")));
		mav.setViewName("crud/view1");
		return mav; 
	}
	
	@PostMapping("/crud/insert")
	public RedirectView view(HttpServletRequest req, RedirectView rv) {
		service.setMessage(req.getParameter("message"));
		rv.setUrl("/crud/view");
		return rv;
	}
	
	@GetMapping("/crud/ajax")
	public String view() {
		return "crud/view2"; 
	}
	
}
