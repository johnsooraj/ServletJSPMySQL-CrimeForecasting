package com.crimeforcast.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crimeforcast.service.CrimeForcastService;
import com.crimeforcast.service.impl.AdminLogin;
import com.crimeforcast.service.impl.AdminRegister;
import com.crimeforcast.service.impl.AjaxGetDistrictName;
import com.crimeforcast.service.impl.GetAdminRegisterPage;
import com.crimeforcast.service.impl.GetCaseRegisterationPage;
import com.crimeforcast.service.impl.GetCrimepredictionPage;
import com.crimeforcast.service.impl.GetKeralaRecordsPage;
import com.crimeforcast.service.impl.HomePageRedirection;
import com.crimeforcast.service.impl.ViewMap;
import com.crimeforcast.service.impl.two.CrimePredictionAjaxResponses;
import com.crimeforcast.service.impl.two.LocalCaseRegister;

@WebServlet(value = "/forcast")
public class CrimeForcastController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String, Object> tasks = new HashMap<>();

	public CrimeForcastController() {
		super();
		tasks.put("adminlogin", new AdminLogin());
		tasks.put("adminhome", new HomePageRedirection());
		tasks.put("viewmap", new ViewMap());
		tasks.put("getdistrictname", new AjaxGetDistrictName());
		tasks.put("cimeprediction", new GetCrimepredictionPage());
		tasks.put("adminregister", new GetAdminRegisterPage());
		tasks.put("caseregister", new GetCaseRegisterationPage());
		tasks.put("keralarecords", new GetKeralaRecordsPage());
		tasks.put("logout", new AdminLogin());
		tasks.put("registerAdminstrator", new AdminRegister());
		tasks.put("localCaseRegister", new LocalCaseRegister());
		tasks.put("predictionHidden", new CrimePredictionAjaxResponses());

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CrimeForcastService action = (CrimeForcastService) tasks.get(request.getParameter("hidden"));
		response.getWriter().println((action.service(request, response)));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CrimeForcastService action = (CrimeForcastService) tasks.get(request.getParameter("hidden"));
		request.getRequestDispatcher(action.service(request, response)).forward(request, response);
	}

}
