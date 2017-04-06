package com.crimeforcast.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;

import com.crimeforcast.hiberutility.HibernateUtil;

@WebListener
public class ListnerClass implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent request) {
		System.out.println("INITIALIZING DATABASE CONNECTION");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		if (factory != null) {
			System.out.println("SESSION FACTORY INITIALIZED AND READY TO SERVE");
			request.getServletContext().setAttribute("sessionfactory", factory);
		} else {
			System.out.println("SESSION FACTORY INITIALIZATION FAILED");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent request) {

	}

}
