package com.java.app.p12;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NOTICE_Repository implements NOTICE_Repository_Interface {

	@Autowired private SqlSession session;
	
	@Override
	public NOTICE_User login(NOTICE_User user) {
		return session.selectOne("notice.login", user);
	}

	@Override
	public int insert(NOTICE_Bean bean) {
		return session.insert("notice.insert", bean);
	}

	@Override
	public List<NOTICE_Bean> select(NOTICE_User user) {
		return session.selectList("notice.select", user);
	}

	@Override
	public int update(NOTICE_Bean bean) {
		return session.update("notice.update", bean);
	}

	@Override
	public int delete(NOTICE_Bean bean) {
		return session.update("notice.delete", bean);
	}

}
