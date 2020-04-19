package com.amsidh.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amsidh.mvc.dao.UserDao;
import com.amsidh.mvc.model.User;
import com.amsidh.mvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void registerUser(User user) {

		userDao.registerUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();

	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
