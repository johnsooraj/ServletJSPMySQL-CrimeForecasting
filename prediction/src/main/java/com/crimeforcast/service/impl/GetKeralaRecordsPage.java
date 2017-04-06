package com.crimeforcast.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.crimeforcast.entitys.Localdataset;
import com.crimeforcast.service.CrimeForcastService;

public class GetKeralaRecordsPage implements CrimeForcastService {
	@SuppressWarnings("unchecked")
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		SessionFactory factory = (SessionFactory) request.getServletContext().getAttribute("sessionfactory");
		Session session = (Session) factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Localdataset> keralaRecord = session.createCriteria(Localdataset.class)
				.add(Restrictions.eq("state", "kerala")).list();
		request.getSession().setAttribute("keralaRecord", keralaRecord);
		transaction.commit();
		return "pages/keralarecords.jsp";
	}
}
