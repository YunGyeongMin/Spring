package com.java.app.p9;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CRUD_Service {

	// VIEW1 
	@Autowired private CRUD_Repository repository1;
	
	public void setMessage(String message) {
		repository1.setMessage(message);
	}
	
	public List<String> getMessage(String keyword) {
		if(null == keyword || ("").equals(keyword)) {
			return repository1.getMessage();
		} else {
			return repository1.getMessage(keyword);
		}
	}
	
	// VIEW2
	@Autowired private CRUD_Repository repository2;
	
	public int create(MessageBean mb) {
		return repository2.create(mb);
	}
	
	public List<MessageBean> read(String keyword) {
		return repository2.read(keyword);
	}
	
	public int update(MessageBean mb) {
		return repository2.update(mb);
	}
	
	public int delete(MessageBean mb) {
		return repository2.delete(mb);
	}
	
}
