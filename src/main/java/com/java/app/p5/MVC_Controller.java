package com.java.app.p5;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MVC_Controller {
	
	@Autowired private MVC_Service service;

	@RequestMapping("/View1")
	public String view1(Model model) {
		model.addAttribute("data", service.getModel());
		return "view";
	}
	
	@RequestMapping("/View2")
	public ModelAndView view2(ModelAndView mav) {
		mav.addObject("data", service.getModel());
		mav.setViewName("view");
		return mav;
	}
	
	@RequestMapping("/View3")
	public String view3(RedirectAttributes ra) {
		ra.addAttribute("data", service.getModel().getNo());
		return "redirect:/View5";
	}
	
	@RequestMapping("/View4")
	public RedirectView view4(RedirectView rv, RedirectAttributes ra) {
		ra.addAttribute("data", service.getModel().getNo());
		rv.setUrl("/View5");
		return rv;
	}
	
	@RequestMapping("/View5")
	public @ResponseBody String view5(HttpServletRequest req) {
		return req.getParameter("data");
	}
	
}
