package com.dong.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bean.Message;
import com.dong.util.Page;

@Aspect
public class MsgListAspect {
	
	@AfterReturning (
			pointcut = "execution(* com.dong.controller.MessageListController.showMsgList(..))",
			returning= "result")
	public void logShowLoginPage(JoinPoint joinPoint, ModelAndView result) throws Throwable {
		
		System.out.println("BEGIN : " + joinPoint.getSignature().getName());
		System.out.println("Arguments : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("Results - ViewNames ------- : " + result.getViewName());
		System.out.println("Results - Message --- Count : " + ((List<Message> )result.getModel().get("messageList")).size());
		System.out.println("Results - Page - TotalCount : " + ((Page)result.getModel().get("page")).getTotalCount());
		System.out.println("Results - Page - CurrentPage: " + ((Page)result.getModel().get("page")).getCurrentPage());

	}
}
