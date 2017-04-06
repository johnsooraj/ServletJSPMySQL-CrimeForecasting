package com.crimeforcast.hiberutility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.out.println("Initial SessionFactory creation failed." + ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory.equals(null)) {
			System.out.println("SESSIONFACTORY OBJECT- FAILED");
		} else {
			System.out.println("SESSIONFACTORY OBJECT- SUCCESS");
		}
		return sessionFactory;
	}

}
