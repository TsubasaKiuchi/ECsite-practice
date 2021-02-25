package model;

import java.io.Serializable;

public class UserBean implements Serializable {
	private String loginid = "";
	private String pass = "";
	private int userid	  ;

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginrid) {
		this.loginid = loginrid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


}