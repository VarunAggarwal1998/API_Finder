package org.apifinder.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import javax.servlet.api;

import org.apifinder.api.getApiData;
import org.apifinder.entity.apiData;
import org.apifinder.model.apiModel;


@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/project")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch (page) {
		case "listapi":
			listApi(request, response);
			break;
		case "addapi":
			addApiFormLoader(request, response);
			break;
			
		case "updateapi":
			updateApiFormLoader(request, response);
			break;	
			
		case "deleteapi":
			deleteApi(Integer.parseInt(request.getParameter("apiId")));
			listApi(request, response);
			break;	
		
		case "resetapidata":
			resetApiPage(request,response);
			//listApi(request, response);
			break;	
			
		default:
			errorPage(request, response);
			
			
	        }
		
		

	}
	
	private void deleteApi(int apiId) { 
		new apiModel().deleteApi(dataSource, apiId);
		return;
		
	}
	private void updateApiFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Update API");
		try {
			request.getRequestDispatcher("updateApi.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void resetApiPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Reset API");
		try {
			request.getRequestDispatcher("ResetApiData.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String button = request.getParameter("reset");
		
//		 if ("reset1".equals(button)) {
//			 getApiData resetdata = new getApiData();
//			 resetdata.resetData(dataSource);
//			 listApi(request, response);
//			 
//		 }
		
		String operation = request.getParameter("form");
		operation=operation.toLowerCase();
		switch (operation) {
		
		case "addapioperation":
		apiData newApi= new apiData(request.getParameter("api"),request.getParameter("description"), request.getParameter("auth"),request.getParameter("https"), request.getParameter("cors"),request.getParameter("link"),request.getParameter("category"));	
			addApiOperation(newApi); 
			listApi(request, response);
			break;
		
		case "updateapioperation":
			
			apiData updatedApi = new apiData(Integer.parseInt(request.getParameter("apiId")),request.getParameter("api"),request.getParameter("description"), request.getParameter("auth"),request.getParameter("https"), request.getParameter("cors"),request.getParameter("link"),request.getParameter("category"));
			updateApiOperation(dataSource, updatedApi);
			listApi(request, response);
			break;
			
		case "resetapioperation":
			
			 getApiData resetdata = new getApiData();
			 new apiModel().truncateTable(dataSource);
			 resetdata.resetData(dataSource);
			 listApi(request, response);
			 break;
		
				

			
		
		
			
			
		default: 
			errorPage(request, response);
			break;
			
		}
	}
	
	
	private void updateApiOperation(DataSource dataSource, apiData updatedApi) {
		new apiModel().updateApi(dataSource, updatedApi);
		return;
		
	}
	private void addApiOperation(apiData newApi) {
		
		
		new apiModel().addApi(dataSource, newApi);
		return;
		
		
	}
	public void listApi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<apiData> listApi = new ArrayList<>();
		listApi = new apiModel().listApi(dataSource);
		request.setAttribute("listApi", listApi);
		request.setAttribute("title", "List of Api");
		request.getRequestDispatcher("listApi.jsp").forward(request, response);
		
	}
	public void addApiFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setAttribute("title", "Add Api");
		request.getRequestDispatcher("addApi.jsp").forward(request, response);
		
	}
	public void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setAttribute("title", "Error page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
		
	}
}
