package com.dreamnight.model;

import java.util.Date;
import java.util.Map;

public class User extends BaseObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2840472175652614869L;
	private Long id;
	private String email;
	private String password;
	private String salt;
	private String nickname;
	private boolean sex;
	private Map<String, Integer> points;
	private Date createTime;
	private Date updateTime;

	public Map<String, Integer> getPoints() {
		return points;
	}

	public void setPoints(Map<String, Integer> points) {
		this.points = points;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
