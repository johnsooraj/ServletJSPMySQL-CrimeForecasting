package com.crimeforcast.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.crimeforcast.entitys.Localdataset;
import com.crimeforcast.service.CrimeForcastService;

public class GetCrimepredictionPage implements CrimeForcastService {
	@SuppressWarnings("unchecked")
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		SessionFactory factory = (SessionFactory) request.getServletContext().getAttribute("sessionfactory");
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		List<Localdataset> list = session.createCriteria(Localdataset.class)
				.setProjection(Projections.distinct(Projections.property("state"))).list();

		request.getSession().setAttribute("localDistrict", list);
		transaction.commit();

		return "pages/crimeprediction.jsp";
	}
}
