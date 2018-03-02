package com.dangdang.bean;
/**
 * 用户bean
 * @author Jelly
 */
public class User {
	//用户的id
	private int id;
	//用户名
	private String username;
	//用户密码
	private String userpass;
	//用户地址
	private String useradd;
	
	public User(){
		
	}
	public User(String username,String userpass){
		this.username = username;
		this.userpass =userpass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getUseradd() {
		return useradd;
	}
	public void setUseradd(String useradd) {
		this.useradd = useradd;
	}
	

}
