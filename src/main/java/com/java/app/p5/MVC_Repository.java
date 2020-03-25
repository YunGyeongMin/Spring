package com.java.app.p5;

import org.springframework.stereotype.Repository;

@Repository
public class MVC_Repository {

	private MVC_Bean bean;
	
	public MVC_Bean getModel() {
		bean = new MVC_Bean();
		bean.setNo(1);
		return bean;
	}
	
}
