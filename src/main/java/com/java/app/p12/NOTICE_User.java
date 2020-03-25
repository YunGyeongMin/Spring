package com.java.app.p12;

public class NOTICE_User {

	int no;
	String id;
	String pwd;
	String nm;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	@Override
	public String toString() {
		return "NOTICE_User [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nm=" + nm + "]";
	}
	
}
