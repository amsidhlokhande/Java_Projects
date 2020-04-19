package com.wlp.spring.controller;

import org.springframework.validation.BindException;
import org.springframework.web.portlet.mvc.SimpleFormController;

import com.wlp.spring.bean.PointIncrease;
import com.wlp.spring.bo.PointManager;




import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.servlet.ServletException;




/**
 * @author vmurali
 *
 */
public class IncreasePointsFormController extends SimpleFormController {



    private PointManager pointManager;

    protected void onSubmitAction(ActionRequest request, ActionResponse response,
            Object command, BindException errors) throws Exception {
        int increase = ((PointIncrease) command).getPoint();
        pointManager.increasePoints(increase);
        response.setRenderParameter("action", "users");
    }

    protected Object formBackingObject(PortletRequest request) throws ServletException {
        PointIncrease pointIncrease = new PointIncrease();
        pointIncrease.setPoint(30);
        return pointIncrease;
    }

    public void setPointManager(PointManager pointManager) {
        this.pointManager = pointManager;
    }

    public PointManager getPointManager() {
        return pointManager;
    }



}
