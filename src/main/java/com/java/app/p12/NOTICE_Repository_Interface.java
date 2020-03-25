package com.java.app.p12;

import java.util.List;

public interface NOTICE_Repository_Interface {

	public NOTICE_User login(NOTICE_User user);
	public int insert(NOTICE_Bean bean);
	public List<NOTICE_Bean> select(NOTICE_User user);
	public int update(NOTICE_Bean bean);
	public int delete(NOTICE_Bean bean);
	
}
