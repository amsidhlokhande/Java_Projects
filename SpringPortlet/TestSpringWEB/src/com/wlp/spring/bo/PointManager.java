package com.wlp.spring.bo;
import java.io.Serializable;
import java.util.List;

import com.wlp.spring.bean.User;

/**
 * @author vmurali
 *
 */
public interface PointManager extends Serializable{

    public void increasePoints(int points);
    
    public List<User> getUsers();


}
