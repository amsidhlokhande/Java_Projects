package com.amsidh.mvc.dao;

import com.amsidh.mvc.model.User;

public interface UserDao {
   public User findByUserName(String username);
}
