package com.dreamnight.remote.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamnight.dao.UserDao;
import com.dreamnight.model.User;
import com.dreamnight.remote.IUserRemote;

@Component(value = "userRemoteImpl")
public class UserRemoteImpl implements IUserRemote{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(Long id) {
		User user = userDao.get(id);
		return user;
	}

}
