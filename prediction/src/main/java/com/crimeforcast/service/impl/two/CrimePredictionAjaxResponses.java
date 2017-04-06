package com.crimeforcast.service.impl.two;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.crimeforcast.entitys.Localdataset;
import com.crimeforcast.service.CrimeForcastService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CrimePredictionAjaxResponses implements CrimeForcastService {

	public CrimePredictionAjaxResponses() {
		System.out.println("CrimePredictionAjaxResponses()");
	}

	private String stateName;

	@SuppressWarnings("unchecked")
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		SessionFactory factory = (SessionFactory) request.getServletContext().getAttribute("sessionfactory");
		Session session = factory.openSession();

		if (request.getParameter("methodName").equals("getDistrict")) {
			try {
				stateName = request.getParameter("stateName");
				Set<String> districtName = new TreeSet<>();

				List<Localdataset> Localdatasets = session.createCriteria(Localdataset.class)
						.add(Restrictions.eq("state", stateName)).list();
				System.out.println(Localdatasets);
				if (!Localdatasets.isEmpty()) {
					for (Localdataset Localdataset : Localdatasets) {
						districtName.add(Localdataset.getDistrict());
					}
				} else {
					return "no result found";
				}
				ObjectMapper objectMapper = new ObjectMapper();
				String jsonData = objectMapper.writeValueAsString(districtName);
				System.out.println(jsonData);
				return jsonData;
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				return "no result found";
			}
		} else if (request.getParameter("methodName").equals("getPlaces")) {
			try {
				String districtNameList = request.getParameter("districtName");
				Set<String> placeName = new TreeSet<>();

				List<Localdataset> Localdatasets = session.createCriteria(Localdataset.class)
						.add(Restrictions.eq("district", districtNameList)).list();
				System.out.println(Localdatasets);
				if (!Localdatasets.isEmpty()) {
					for (Localdataset Localdataset : Localdatasets) {
						placeName.add(Localdataset.getPlace());
					}
				} else {
					return "no result found";
				}
				ObjectMapper objectMapper = new ObjectMapper();
				String jsonData = objectMapper.writeValueAsString(placeName);
				System.out.println(jsonData);
				return jsonData;
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				return "no result found";
			}
		} else if (request.getParameter("methodName").equals("predictionResult")) {
			try {
				System.out.println(request.getParameter("placeName"));
				List<Localdataset> localDataSets = session.createCriteria(Localdataset.class)
						.add(Restrictions.eq("place", request.getParameter("placeName"))).list();
				System.out.println("ajax response --- "+localDataSets);
				return new DataminingClassification().PredictionResult(stateName,localDataSets, session);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				request.getSession().setAttribute("errorMessage", e);
				return "";
			}
		}
		return "errorpage.jsp";
	}

}
