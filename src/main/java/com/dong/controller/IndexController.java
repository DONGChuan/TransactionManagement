package com.dong.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dong.dao.MessageDAO;
import com.dong.factory.MessageDAOFactory;
import com.dong.util.Page;
import com.dong.util.PageUtil;
import com.dong.bean.Message;

@Controller
@RequestMapping("/")
public class IndexController {

	/*@RequestMapping(method = RequestMethod.GET) 
	public String showLoginPage(){
		return "index";
	}*/
	
	@RequestMapping(value={"index","/"} , method = RequestMethod.GET)
	public ModelAndView showIndex()	{
		ModelAndView modelView = new ModelAndView();
		
		// Get messages from DB
		MessageDAO messageDAO = MessageDAOFactory.getMessageAOInstance();
		Page pageX = PageUtil.createPage(6, messageDAO.findAllCount(), 1);
		List<Message> messages = messageDAO.findAllMessagee(pageX);
		
		// Return view with messages object 
		modelView.addObject("messages", messages);		
		modelView.setViewName("index");
		
		return modelView;
	}
	
}
