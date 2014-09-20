package com.dong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bo.EmployeeBo;
import com.dong.bo.MessageBo;
import com.dong.model.Employee;
import com.dong.model.Message;
import com.dong.util.Page;
import com.dong.util.PageUtil;

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
	
	@Autowired
    private EmployeeBo employeeBo;
	
	@Autowired
    private MessageBo messageBo;
	
	@RequestMapping(method = RequestMethod.GET) 
	public String showLoginPage(){
		return "login";
	}
	
	@Transactional
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
		
				Employee employee = employeeBo.findByEmployeeID(Integer.valueOf(employeeID));
				
				if(employee == null) { // If this employee doesn't exist
					error = "This employee ID doesn't exist!";
					return new ModelAndView("login","error",error);
				} else {
					if(password.equals(employee.getPassword())) { // If both are correct
						
						Page pageX = PageUtil.createPage(6, messageBo.findAllCount(), 1);
						List<Message> messages = messageBo.findAllMessagee(pageX);
						
						ModelAndView mv = new ModelAndView();
						mv.addObject("employee", employee);	
						mv.addObject("messages", messages);		
						mv.setViewName("index");
						
						return mv;
					} else { // If password is error
						error = "Password is error!";
						return new ModelAndView("login","error",error);
					}
				}
			}
		}
	}

}
