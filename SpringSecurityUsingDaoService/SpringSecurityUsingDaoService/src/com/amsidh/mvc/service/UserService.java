package com.amsidh.mvc.service;

import java.util.List;

import com.amsidh.mvc.model.User;

public interface UserService {
	public void registerUser(User user);

	public List<User> getAllUsers();
}
