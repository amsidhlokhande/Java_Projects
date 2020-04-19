package com.amsidh.mvc.dao;

import java.util.List;

import com.amsidh.mvc.model.User;

public interface UserDao {

	public void registerUser(User user);

	public List<User> getAllUsers();

}
