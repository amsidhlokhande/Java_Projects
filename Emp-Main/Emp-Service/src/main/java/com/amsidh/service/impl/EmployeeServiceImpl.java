package com.amsidh.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amsidh.dao.EmployeeDao;
import com.amsidh.doms.EmployeeDom;
import com.amsidh.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	
	public void createEmployee(EmployeeDom employee) {
		employeeDao.createEmployee(employee);

	}

	
	public void removeEmployee(EmployeeDom employee) {
		employeeDao.removeEmployee(employee);

	}

	
	public EmployeeDom updateEmployee(EmployeeDom employee) {

		return employeeDao.updateEmployee(employee);
	}

	
	public EmployeeDom searchEmployee(EmployeeDom employee) {

		return employeeDao.searchEmployee(employee);
	}

	
	public List<EmployeeDom> getAllEmployee() {

		return employeeDao.getAllEmployee();
	}

}
