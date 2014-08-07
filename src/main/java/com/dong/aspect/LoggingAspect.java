package com.dong.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
	public void logLogginEmployee(JoinPoint joinPoint, Object result) throws Throwable {
 
		System.out.println("BEGIN : " + joinPoint.getSignature().getName());
		System.out.println("Arguments : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("Method returned value is : " + result);

	}
	
}
