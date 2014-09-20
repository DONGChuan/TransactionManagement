package com.dong.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.servlet.ModelAndView;

import com.dong.model.Employee;

@Aspect
public class LoggingAspect {
	
	@Before("execution(* com.dong.controller.LoginController.showLoginPage(..))")
	public void logShowLoginPage(JoinPoint joinPoint) throws Throwable {
		System.out.println("BEGIN : " + joinPoint.getSignature().getName());
		System.out.println("Arguments : " + Arrays.toString(joinPoint.getArgs()));
	}
	
	@AfterReturning (
			pointcut = "execution(* com.dong.controller.LoginController.logginEmployee(..))",
			returning= "result")
	public void logLogginEmployee(JoinPoint joinPoint, ModelAndView result) throws Throwable {
 
		System.out.println("BEGIN : " + joinPoint.getSignature().getName());
		System.out.println("Arguments : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("Results - ViewNames ------- : " + result.getViewName());
		
		if(result.getModel().containsKey("error")) {
			System.out.println("Results - ViewNames ------- : " + result.getModel().get("error"));
		} else {
			Employee tmp = (Employee) result.getModel().get("employee");
			System.out.println("Results - Emp - EmployeeID ---: " + tmp.getEmployeeID());
			System.out.println("Results - Emp - EmployeeName -: " + tmp.getEmployeeName());
			System.out.println("Results - Emp - EmployeeName -: " + tmp.getEmployeePhone());
			System.out.println("Results - Emp - EmployeePlace : " + tmp.getEmployeePlace());
			System.out.println("Results - Emp - JoinTime -----: " + tmp.getJoinTime());
			System.out.println("Results - Emp - EmployeeBirth : " + tmp.getEmployeeBirth());
		}
	}
	
}
