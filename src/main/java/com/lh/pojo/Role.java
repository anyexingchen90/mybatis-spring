package com.lh.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ע��bean
 * @author liuhao
 * @date 2017-12-08 13:52:13
 */
//�൱��bean,role�൱��id
@Component("role")
public class Role {
	@Value("1")
	private int id;
	@Value("����Ա")
	private String role_name;
	@Value("1")
	private int user_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
