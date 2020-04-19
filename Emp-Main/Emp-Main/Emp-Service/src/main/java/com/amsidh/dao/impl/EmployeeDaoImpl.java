package com.amsidh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amsidh.dao.EmployeeDao;
import com.amsidh.doms.EmployeeDom;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	public void createEmployee(EmployeeDom employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	
	public void removeEmployee(EmployeeDom employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(employee);
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

	
	public EmployeeDom updateEmployee(EmployeeDom employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(employee);
		session.flush();
		session.getTransaction().commit();
		session.close();

		return employee;
	}

	
	public EmployeeDom searchEmployee(EmployeeDom employee) {
		EmployeeDom employeeDom = null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		employeeDom = (EmployeeDom) session.get(EmployeeDom.class,
				employee.getEmailId());
		session.flush();
		session.getTransaction().commit();
		session.close();

		return employeeDom;

	}

	
	public List<EmployeeDom> getAllEmployee() {

		List<EmployeeDom> listOfemployeeDom = new ArrayList<EmployeeDom>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		listOfemployeeDom = (List<EmployeeDom>) session.createQuery(
				"from EmployeeDom").list();
		session.flush();
		session.getTransaction().commit();
		session.close();
		return listOfemployeeDom;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	
}
