package com.java.app.p9;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CRUD_MODEL {
	
	@Autowired private CRUD_Service service;

	@PostMapping("/crud/create")
	public int create(HttpServletRequest req) {
		return service.create(getBean(req));
	}
	
	@PostMapping("/crud/read")
	public List<MessageBean> read(HttpServletRequest req) {
		return service.read(req.getParameter("keyword"));
	}
	
	@PostMapping("/crud/update")
	public int update(HttpServletRequest req) {
		return service.update(getBean(req));
	}
	
	@PostMapping("/crud/delete")
	public int delete(HttpServletRequest req) {
		return service.delete(getBean(req));
	}
	
	public MessageBean getBean(HttpServletRequest req) {
		MessageBean mb = new MessageBean();
		if(req.getParameter("no") == null || ("").equals(req.getParameter("no"))) {
			mb.setNo(0);
		} else {
			mb.setNo(Integer.parseInt(req.getParameter("no")));
		}
		String msg = req.getParameter("msg");
		mb.setMsg(msg);
		return mb;
	}
	
}
