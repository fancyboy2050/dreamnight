package com.dreamnight.model;

import java.util.Date;

public class Consciousness extends BaseObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6016187162719934006L;
	private Long id;
	private Long userId;
	private String content;
	private Date createtTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatetTime() {
		return createtTime;
	}
	public void setCreatetTime(Date createtTime) {
		this.createtTime = createtTime;
	}

}
