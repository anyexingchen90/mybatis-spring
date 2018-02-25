package com.lh.pojo;
/**
 *
 * @author liuhao
 * @date 2017-12-08 11:12:18
 */
public class User {
	private String name;
	private String email;
	public User() {
	}
	
	public User(String name,String email) {
		this.name = name;
		this.email = email;
		System.out.println("构造方法注入输出名称："+name + "  构造方法注入输出邮箱："+email);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
