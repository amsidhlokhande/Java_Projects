package com.wlp.spring.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletException;


import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import com.wlp.spring.bo.PointManager;


/**
 * @author vmurali
 *
 */
public class UserController extends AbstractController {



    private PointManager pointManager;
	public void handleActionRequest(ActionRequest request, ActionResponse response) throws Exception {

	}
    public ModelAndView handleRenderRequest(RenderRequest request, RenderResponse response)
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
