package com.amsidh.app;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amsidh.doms.EmployeeDom;
import com.amsidh.service.EmployeeService;

public class EmpApplication {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/spring-service-context.xml");

		EmpApplication empApplication = new EmpApplication();
		EmployeeDom employee = new EmployeeDom();
		employee.setEmpName("Amsidh");
		employee.setAddress("Pune");
		employee.setEmailId("amsidh.lokhande@accenture.com");
		employee.setCompanyName("ACN");
		employee.setJoiningDate(new Date());
		employee.setMobileNumber(new Long(8108551845L));
		empApplication.employeeService=(EmployeeService)context.getBean("employeeService");
		empApplication.employeeService.createEmployee(employee);
		List<EmployeeDom> listOfEmpDoms=empApplication.employeeService.getAllEmployee();
		for(EmployeeDom emp:listOfEmpDoms)
		{
			System.out.println(emp.getEmpId()+"   "+emp.getEmpName());
		}

	}
}
