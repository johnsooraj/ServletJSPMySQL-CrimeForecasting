package com.crimeforcast.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.crimeforcast.entitys.LoginCredentials;
import com.crimeforcast.service.CrimeForcastService;

public class AdminRegister implements CrimeForcastService {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		try {
	
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			SessionFactory factory = (SessionFactory) request.getServletContext().getAttribute("sessionfactory");
			Session session = (Session) factory.getCurrentSession();
			Transaction transaction = session.beginTransaction();

			LoginCredentials credentials = new LoginCredentials();
			credentials.setUsername(username);
			credentials.setPassword(password);
			session.save(credentials);
			transaction.commit();
			return "pages/adminregistration.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "pages/adminregistration.jsp";
		}
	}

}