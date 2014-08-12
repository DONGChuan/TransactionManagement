package com.dong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bean.Employee;
import com.dong.dao.EmployeeDAO;
import com.dong.factory.EmployeeDAOFactory;

/*
 * Servlet 
 * It works for the request from statusRecognise.jsp
 * 
 * ID empty               --> login.jsp
 * Password empty         --> login.jsp
 * Password error         --> login.jsp
 * Employee doesn't exist --> login.jsp
 * Both is correct        --> index.jsp
 */
@Controller
@RequestMapping("/login")
@SessionAttributes("employee")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET) 
	public String showLoginPage(){
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView logginEmployee(@RequestParam("employeeID") String employeeID,
					          @RequestParam("password") String password) {
		
		String error = null;	
		
		if(employeeID == null || "".equals(employeeID)) { // If ID is empty		
			error = "Employee ID can't be empty!";
			return new ModelAndView("login","error",error);
			
		}else {
			if(password == null || "".equals(password)) { // If password is empty	
				error = "Password can't be empty!";
				return new ModelAndView("login","error",error);
			}else {
				
				// Loading the DB
				EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
				Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeID));
				
				if(employee == null) { // If this employee doesn't exist
					error = "This employee ID doesn't exist!";
					return new ModelAndView("login","error",error);
				} else {
					if(password.equals(employee.getPassword())) { // If both are correct
						return new ModelAndView("index","employee", employee);
					} else { // If password is error
						error = "Password is error!";
						return new ModelAndView("login","error",error);
					}
				}
			}
		}
	}

}
