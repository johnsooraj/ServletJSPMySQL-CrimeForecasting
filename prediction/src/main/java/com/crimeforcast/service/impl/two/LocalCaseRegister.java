package com.crimeforcast.service.impl.two;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.crimeforcast.entitys.Localdataset;
import com.crimeforcast.service.CrimeForcastService;

public class LocalCaseRegister implements CrimeForcastService {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		try {
			SessionFactory factory = (SessionFactory) request.getServletContext().getAttribute("sessionfactory");
			Session session = (Session) factory.getCurrentSession();
			Transaction transaction = session.beginTransaction();

			Localdataset localdataset = new Localdataset();

			localdataset.setState(request.getParameter("state"));
			localdataset.setDistrict(request.getParameter("district"));
			localdataset.setPlace(request.getParameter("place"));
			localdataset.setNearestPoliceStation(request.getParameter("nearestPoliceStation"));
			localdataset.setCrimeDate(request.getParameter("crimeDate"));
			localdataset.setCrime_time(request.getParameter("crime_time"));
			localdataset.setLongitude(request.getParameter("longitude"));
			localdataset.setLatitude(request.getParameter("latitude"));
			localdataset.setTypeOf_Crime(request.getParameter("typeOf_Crime"));
			localdataset.setVictimGender(request.getParameter("victimGender"));
			localdataset.setVictimAge(request.getParameter("victimAge"));
			localdataset.setAnyVitness(request.getParameter("anyVitness").equals("yes") ? true : false);
			localdataset.setVitnessAge(Integer.parseInt(request.getParameter("vitnessAge")));
			localdataset.setAnySuspect(request.getParameter("anySuspect").equals("yes") ? true : false);
			localdataset.setSuspectAge(Integer.parseInt(request.getParameter("suspectAge")));
			localdataset.setSuspectGender(request.getParameter("suspectGender"));
			localdataset.setLocationType(request.getParameter("locationType"));

			session.save(localdataset);
			transaction.commit();
			return "pages/caseregisteration.jsp";

		} catch (Exception e) {
			e.printStackTrace();
			return "pages/caseregisteration.jsp";
		}
	}

}
