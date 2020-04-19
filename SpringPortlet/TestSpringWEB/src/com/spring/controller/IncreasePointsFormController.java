package com.spring.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.bean.PointIncrease;
import com.spring.bo.PointManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;



/**
 * @author vmurali
 *
 */
public class IncreasePointsFormController extends SimpleFormController {


    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private PointManager pointManager;

    protected ModelAndView  onSubmit(Object command) throws Exception {
        int increase = ((PointIncrease) command).getPoint();
        pointManager.increasePoints(increase);
        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
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
