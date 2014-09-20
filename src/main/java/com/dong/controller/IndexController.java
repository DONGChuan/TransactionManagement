package com.dong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bo.MessageBo;
import com.dong.model.Message;
import com.dong.util.Page;
import com.dong.util.PageUtil;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
    private MessageBo messageBo;
	
	@RequestMapping(value={"index","/"} , method = RequestMethod.GET)
	public ModelAndView showIndex()	{
		ModelAndView modelView = new ModelAndView();
		
		Page pageX = PageUtil.createPage(6, messageBo.findAllCount(), 1);
		List<Message> messages = messageBo.findAllMessagee(pageX);
		
		// Return view with messages object 
		modelView.addObject("messages", messages);		
		modelView.setViewName("index");
		
		return modelView;
	}
	
}
