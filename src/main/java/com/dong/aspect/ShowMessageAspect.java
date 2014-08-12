package com.dong.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bean.Criticism;
import com.dong.bean.Message;

@Aspect
public class ShowMessageAspect {
	
	@AfterReturning (
			pointcut = "execution(* com.dong.controller.ShowMessageController.showMsg(..))",
			returning= "result")
	public void logShowLoginPage(JoinPoint joinPoint, ModelAndView result) throws Throwable {
		
		System.out.println("BEGIN : " + joinPoint.getSignature().getName());
		System.out.println("Arguments : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("Results - ViewNames ------- : " + result.getViewName());
;
		System.out.println("Results - Message - Title - : " + ((Message)result.getModel().get("message")).getMessageTitle());
		System.out.println("Results - Message - Content : " + ((Message)result.getModel().get("message")).getMessageContent());
		
		System.out.println("Results - Criticism - Content : " + ((Criticism)result.getModel().get("criticism")).getCriticismContent());

//		rp.addObject("message", message);
//		rp.addObject("criticism", criticism);
//		rp.addObject("replyList", replys);
//		rp.addObject("page", page);
//		rp.setViewName("showMsg");

	}
	
}
