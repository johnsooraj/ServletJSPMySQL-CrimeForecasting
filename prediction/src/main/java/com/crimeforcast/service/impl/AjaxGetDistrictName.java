package com.crimeforcast.service.impl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.crimeforcast.entitys.Crimeforcastdataset;
import com.crimeforcast.service.CrimeForcastService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AjaxGetDistrictName implements CrimeForcastService {

	@SuppressWarnings("unchecked")
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		Set<String> districtName = new TreeSet<>();

		SessionFactory factory = (SessionFactory) request.getServletContext().getAttribute("sessionfactory");
		Session session = factory.openSession();
		List<Crimeforcastdataset> crimeforcastdatasets = session.createCriteria(Crimeforcastdataset.class).list();

		System.out.println(crimeforcastdatasets);
		for (Crimeforcastdataset crimeforcastdataset : crimeforcastdatasets) {
			if (request.getParameter("statename").equals(crimeforcastdataset.getState_ut())) {
				districtName.add(crimeforcastdataset.getDistrict());
			}
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonData = objectMapper.writeValueAsString(districtName);
			System.out.println(jsonData);
			return jsonData;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";

	}

}
