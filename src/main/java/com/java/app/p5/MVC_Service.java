package com.java.app.p5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MVC_Service {
	
	@Autowired
	private MVC_Repository repository;

	public MVC_Bean getModel() {
		return repository.getModel();
	}
	
}
