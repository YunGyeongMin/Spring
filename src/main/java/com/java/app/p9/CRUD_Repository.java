package com.java.app.p9;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CRUD_Repository {

	// VIEW1
	private static List<String> list = new ArrayList<String>();
	
	public void setMessage(String message){
		CRUD_Repository.list.add(message);
	}
	
	public List<String> getMessage() {
		return CRUD_Repository.list;
	}
	
	public List<String> getMessage(String keyword) {
		List<String> resultList = new ArrayList<String>();
		for(String message : CRUD_Repository.list) {
			if(message.indexOf(keyword) > -1) {
				resultList.add(message);
			}
		}
		return resultList;
	}
	
	// VIEW2
	@Autowired private SqlSession sqlSession;
	
	public int create(MessageBean mb) {
		return sqlSession.insert("crud.create", mb);
	}
	
	public List<MessageBean> read(String keyword) {
		return sqlSession.selectList("crud.read", keyword);
	}
	
	public int update(MessageBean mb) {
		return sqlSession.update("crud.update", mb);
	}
	
	public int delete(MessageBean mb) {
		return sqlSession.delete("crud.delete", mb);
	}
}
