package com.amsidh.service;

import java.util.List;

import com.amsidh.doms.EmployeeDom;

public interface EmployeeService {
	public void createEmployee(EmployeeDom employee);

	public void removeEmployee(EmployeeDom employee);

	public EmployeeDom updateEmployee(EmployeeDom employee);

	public EmployeeDom searchEmployee(EmployeeDom employee);

	public List<EmployeeDom> getAllEmployee();
}
