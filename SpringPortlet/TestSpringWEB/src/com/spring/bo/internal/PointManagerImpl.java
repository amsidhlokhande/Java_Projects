package com.spring.bo.internal;

import java.util.List;

import com.spring.bean.User;
import com.spring.bo.PointManager;


/**
 * @author vmurali
 *
 */
public class PointManagerImpl implements PointManager{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void increasePoints(int points) {
        if (users != null) {
            for (User user : users) {
                int newPoints = user.getPoints()+points;
                user.setPoints(newPoints);
            }
        }
      
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
