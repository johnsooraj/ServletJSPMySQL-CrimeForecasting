package com.crimeforcast.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crimeforcast.service.CrimeForcastService;

public class HomePageRedirection implements CrimeForcastService {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		return "pages/home.jsp";
	}

}
