package com.java.app.p8;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@GetMapping("/ui/page1")
	public String view1() {
		return "ui/page1";
	}
	@RequestMapping("/ui/page2")
	public String view2() {
		return "ui/page2";
	}
	@PostMapping("/ui/page3")
	public String view3() {
		return "ui/page3";
	}
	
	@GetMapping("/ui/view")
	public String view() {
		return "ui/view";
	}
	
}
