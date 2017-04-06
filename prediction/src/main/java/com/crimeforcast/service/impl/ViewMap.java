package com.crimeforcast.service.impl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crimeforcast.entitys.Crimeforcastdataset;
import com.crimeforcast.service.CrimeForcastService;

public class ViewMap implements CrimeForcastService {

	@SuppressWarnings("unchecked")
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		try {
			Set<String> setcaseFile1 = new TreeSet<>();
			List<Crimeforcastdataset> listcaseFile1 = (List<Crimeforcastdataset>) request.getServletContext()
					.getAttribute("cimeDataSet");
			for (Crimeforcastdataset dataset : listcaseFile1) {
				setcaseFile1.add(dataset.getState_ut());
			}
			request.getSession().setAttribute("setcaseFile1", setcaseFile1);
			return "pages/viewmap.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "pages/home.jsp";
		}
	}

}
