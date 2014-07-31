package com.dong.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dong.bean.Employee;
import com.dong.dao.EmployeeDAO;
import com.dong.factory.EmployeeDAOFactory;

/*
 * Servlet 
 * It works for the request from statusRecognise.jsp
 * 
 * ID empty               --> statusRecognise.jsp
 * Password empty         --> statusRecognise.jsp
 * Password error         --> statusRecognise.jsp
 * Employee doesn't exist --> statusRecognise.jsp
 * Both is correct        --> index.jsp
 */
public class StatusRecognise extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext servletContext = getServletContext();	
		RequestDispatcher dispatcher = null;	
		
		// Get ID and Password 
		String employeeID = request.getParameter("employeeID");	
		String password = request.getParameter("password");		
		
		if(employeeID == null || "".equals(employeeID)) {		
			// If ID is empty
			request.setAttribute("error", "Employee ID can't be empty!");
			dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
			
		}else {
			if(password == null || "".equals(password)) {
				// If password is empty		
				request.setAttribute("error", "Password can't be empty!");
				dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
			}else {
				
				// Loading the DB
				EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
				Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeID));
				
				if(employee == null) { 
					// If this employee doesn't exist
					request.setAttribute("error", "This employee ID doesn't exist!");
					dispatcher = servletContext.
						getRequestDispatcher("/statusRecognise.jsp");
				} else {
					if(password.equals(employee.getPassword())) { 
						// If both are correct
						request.getSession().setAttribute("employee", employee);
						response.sendRedirect("index.jsp");
						return;
					} else { 
						// If password is error
						request.setAttribute("error", "Password is error!");
						dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
					}
				}
			}
		}
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
