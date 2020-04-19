package com.amsidh.mvc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.amsidh.mvc.dao.UserDao;
import com.amsidh.mvc.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao, UserDetailsService,BeanNameAware {

	@Autowired
	SessionFactory sessionFactory;
	
	

	@Autowired
	UserDetailsService userDetailsService;
	
	
	@Override
	public void registerUser(User user) {
		
		System.out.println(userDetailsService+"   ---------userDetailsService");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) session.createQuery("from User").list();
		session.getTransaction().commit();
		session.close();
		return users;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("Inside loadUserByUsername method"+username);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where username:username");
		query.setString("username", username);

		com.amsidh.mvc.model.User u = (com.amsidh.mvc.model.User) query.list()
				.get(0);
		List<SimpleGrantedAuthority> authorities = new java.util.ArrayList<SimpleGrantedAuthority>();

		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
				u.getUsername(), u.getPassword(), u.getIsEnabled() == 1 ? true
						: false, true, true, true, authorities);

		return user;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println(arg0);
		
	}

}
