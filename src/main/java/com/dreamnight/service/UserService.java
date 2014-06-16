package com.dreamnight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamnight.dao.UserDao;
import com.dreamnight.model.User;

@Component
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User createUser(User user){
		userDao.create(user);
		return user;
	}

}
