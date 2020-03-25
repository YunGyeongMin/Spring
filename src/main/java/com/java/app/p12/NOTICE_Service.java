package com.java.app.p12;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NOTICE_Service implements NOTICE_Service_Interface {

	@Autowired private NOTICE_Repository_Interface repository;
	private Map<String, Object> resultMap = null;

	@Override
	public Map<String, Object> login(NOTICE_User user, HttpSession session) {
		resultMap = new HashMap<String, Object>();
		resultMap.put("state", 0);
		NOTICE_User uBean = repository.login(user);
		if(uBean != null) {
			if(user.getPwd().equals(uBean.getPwd())) {
				session.setAttribute("USER", uBean);
				resultMap.put("state", 1);
				resultMap.put("id", uBean.getId());
				resultMap.put("nm", uBean.getNm());
			} else {
				resultMap.put("msg", "비밀번호가 잘못 되었습니다.");
			}
		} else {
			resultMap.put("msg", "회원 정보가 잘못 되었습니다.");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> insert(NOTICE_Bean bean, HttpSession session) {
		resultMap = new HashMap<String, Object>();
		resultMap.put("state", 0);
		Object obj = session.getAttribute("USER");
		if(obj != null) {
			NOTICE_User user = (NOTICE_User) obj;
			bean.setuNo(user.getNo());
			if(repository.insert(bean) > 0) {
				resultMap.put("state", 1);
				resultMap.put("result", select(session));
			} else {
				resultMap.put("msg", "입력 중 오류가 발생했습니다.");
			}
		} else {
			resultMap.put("msg", "로그인이 되어 있지 않습니다.");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> select(HttpSession session) {
		resultMap = new HashMap<String, Object>();
		resultMap.put("state", 0);
		Object obj = session.getAttribute("USER");
		if(obj != null) {
			NOTICE_User user = (NOTICE_User) obj;
			resultMap.put("state", 1);
			resultMap.put("result", repository.select(user));
		} else {
			resultMap.put("msg", "로그인이 되어 있지 않습니다.");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> update(NOTICE_Bean bean, HttpSession session) {
		resultMap = new HashMap<String, Object>();
		resultMap.put("state", 0);
		Object obj = session.getAttribute("USER");
		if(obj != null) {
			NOTICE_User user = (NOTICE_User) obj;
			if(bean.getuNo() == user.getNo()) {
				if(repository.update(bean) > 0) {
					resultMap.put("state", 1);
					resultMap.put("result", select(session));
				} else {
					resultMap.put("msg", "수정 대상이 없습니다.");
				}
			} else {
				resultMap.put("msg", "수정 권한이 없습니다.");
			}
		} else {
			resultMap.put("msg", "로그인이 되어 있지 않습니다.");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> delete(NOTICE_Bean bean, HttpSession session) {
		resultMap = new HashMap<String, Object>();
		resultMap.put("state", 0);
		Object obj = session.getAttribute("USER");
		if(obj != null) {
			NOTICE_User user = (NOTICE_User) obj;
			if(bean.getuNo() == user.getNo()) {
				if(repository.delete(bean) > 0) {
					resultMap.put("state", 1);
					resultMap.put("result", select(session));
				} else {
					resultMap.put("msg", "삭제 대상이 없습니다.");
				}
			} else {
				resultMap.put("msg", "삭제 권한이 없습니다.");
			}
		} else {
			resultMap.put("msg", "로그인이 되어 있지 않습니다.");
		}
		return resultMap;
	}
	
}
