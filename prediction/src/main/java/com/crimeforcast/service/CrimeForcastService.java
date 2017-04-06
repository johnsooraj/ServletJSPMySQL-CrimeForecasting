package com.crimeforcast.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CrimeForcastService {
	public String service(HttpServletRequest request, HttpServletResponse response);
}
