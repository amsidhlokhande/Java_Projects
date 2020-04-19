package com.amsidh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amsidh.dtos.EmployeeDto;
import com.amsidh.service.EmployeeService;
import com.amsidh.util.DomDaoCreatorUtil;

@Controller
public class EmployeeController {
	
   @Autowired
	private EmployeeService employeeService;
   
	@RequestMapping(value="/home")
	public String mainPage(ModelMap model,@ModelAttribute("employee")EmployeeDto employee)
	{
		employee=new EmployeeDto();
		List<EmployeeDto> employeeList=DomDaoCreatorUtil.getEmployeeDtos(employeeService.getAllEmployee()); 
		
		model.addAttribute("employee",employee);
		model.addAttribute("employeeList",employeeList);
		return "homePage";
	}
	
}
