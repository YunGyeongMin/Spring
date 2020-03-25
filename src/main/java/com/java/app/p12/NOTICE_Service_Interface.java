package com.java.app.p12;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface NOTICE_Service_Interface {

	public Map<String, Object> login(NOTICE_User user, HttpSession session);
	public Map<String, Object> insert(NOTICE_Bean bean, HttpSession session);
	public Map<String, Object> select(HttpSession session);
	public Map<String, Object> update(NOTICE_Bean bean, HttpSession session);
	public Map<String, Object> delete(NOTICE_Bean bean, HttpSession session);
	
}
