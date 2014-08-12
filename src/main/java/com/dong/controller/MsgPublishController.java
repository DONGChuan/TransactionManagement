package com.dong.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bean.Employee;
import com.dong.bean.Message;
import com.dong.dao.MessageDAO;
import com.dong.factory.MessageDAOFactory;

@Controller
@RequestMapping("/publishNewMsg")
@SessionAttributes("employee")
public class MsgPublishController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showMsgPublishPage() {
		return "publishNewMsg";
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public ModelAndView showMsgPublish(@RequestParam("title") String title,
								@RequestParam("content") String content,
								@RequestParam("employee") Employee employee) {
		
		ModelAndView rp = new ModelAndView();
		rp.setViewName("publishNewMsg");
		
		if(employee == null) {
			rp.addObject("error", "Must Log In Firstly");

		}else {
			if(title == null || "".equals(title)) { 
				rp.addObject("error", "Must Have A Title");

			}else {
				Message message = new Message();
				message.setEmployeeID(employee.getEmployeeID());
				message.setMessageTitle(title);
				message.setMessageContent(content);
				message.setPublishTime(new Date());
				MessageDAO messageDAO = 
					MessageDAOFactory.getMessageAOInstance();
				messageDAO.addMessage(message);	
			}
		}
		return rp;
	}
}