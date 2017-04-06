package com.crimeforcast.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.crimeforcast.entitys.Crimeforcastdataset;
import com.crimeforcast.entitys.LoginCredentials;
import com.crimeforcast.service.CrimeForcastService;

public class AdminLogin implements CrimeForcastService {

	@SuppressWarnings("unchecked")
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		SessionFactory factory = (SessionFactory) request.getServletContext().getAttribute("sessionfactory");
		Session session = factory.openSession();
		Query query = session
				.createQuery("FROM LoginCredentials log WHERE log.username=:username AND log.password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<LoginCredentials> login = query.list();

		if (!login.isEmpty()) {
			if (login.get(0).getUsername().equals(username) && login.get(0).getPassword().equals(password)) {
				Query query2 = session.createQuery("FROM Crimeforcastdataset");
				List<Crimeforcastdataset> listCrimeDataset = query2.list();

				request.getSession().setAttribute("totalCases", listCrimeDataset.size());
				request.getServletContext().setAttribute("cimeDataSet", listCrimeDataset);

				return "pages/home.jsp";
			} else {
				return "index.jsp";
			}
		} else {
			return "index.jsp";
		}

	}

}
