package com.spring.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.spring.bo.PointManager;


/**
 * @author vmurali
 *
 */
public class UserController implements Controller {


	protected final Log logger = LogFactory.getLog(getClass());
    private PointManager pointManager;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String now = (new java.util.Date()).toString();
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("users", this.pointManager.getUsers());
        return new ModelAndView("users", "model", myModel);
    }


    public void setPointManager(PointManager pointManager) {
        this.pointManager = pointManager;
    }


}
