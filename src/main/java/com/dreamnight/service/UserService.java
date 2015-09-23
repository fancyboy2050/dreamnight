package com.dreamnight.service;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamnight.dao.UserDao;
import com.dreamnight.model.User;
import com.dreamnight.util.SecurityUtil;

@Component
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User createUser(User user){
		String salt = RandomStringUtils.randomAlphanumeric(5);
		String password = SecurityUtil.md5(SecurityUtil.md5(user.getPassword())+salt);
		user.setPassword(password);
		user.setSalt(salt);
		userDao.create(user);
		return user;
	}
	
	public User getUserById(Long id){
		User user = userDao.get(id);
		return user;
	}

}
