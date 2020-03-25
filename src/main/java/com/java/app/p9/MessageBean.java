package com.java.app.p9;

public class MessageBean {
	
	int no;
	String msg;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "MessageBean [no=" + no + ", msg=" + msg + "]";
	}

}
