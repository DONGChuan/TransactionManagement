package com.dong.controller;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bean.Criticism;
import com.dong.bean.Employee;
import com.dong.bean.Reply;
import com.dong.dao.CriticismDAO;
import com.dong.dao.ReplyDAO;
import com.dong.factory.CriticismDAOFactory;
import com.dong.factory.ReplyDAOFactory;

@Controller
@RequestMapping("/commit")
@SessionAttributes("employee")
public class CommitController {
	

	
	@RequestMapping(value = "criticism", method = RequestMethod.POST)
	public ModelAndView commitCriticism(@RequestParam("criticismContent") String criticismContent,
			@RequestParam("messageID") String messageIDStr,
			@ModelAttribute("employee") Employee employee) {
		
		ModelAndView rp = new ModelAndView();
		int messageID = Integer.parseInt(messageIDStr);

		if(employee == null) {
			rp.addObject("error", "Must Log In Firstly");
		}else {
			if(criticismContent == null || "".equals(criticismContent)) { 
				rp.addObject("error", "Content Can Not Be Empty");
			}else {
				Criticism criticism = new Criticism();
				criticism.setCriticismContent(criticismContent);
				criticism.setEmployeeID(employee.getEmployeeID());
				criticism.setCriticismTime(new Date());
				criticism.setMessageID(messageID);
				CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
				criticismDAO.addCriticism(criticism);
			}
		}
		rp.setViewName("getMessage");
		
		return rp;
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public ModelAndView commitReply(@RequestParam("replyContent") String replyContent,
			@RequestParam("messageID") String messageIDStr,
			@ModelAttribute("employee") Employee employee) {
		
		ModelAndView rp = new ModelAndView();
		int messageID = Integer.parseInt(messageIDStr);
	
		if(employee == null) {
			rp.addObject("error", "Must Log In Firstly");
		}else {
			if(replyContent == null || "".equals(replyContent)) { 
				rp.addObject("error", "Content Can Not Be Empty");
			}else {
				Reply replay = new Reply();
				replay.setReplyContent(replyContent);
				replay.setMessageID(messageID);		
				replay.setEmployeeID(employee.getEmployeeID());
				replay.setReplyTime(new Date());	
				ReplyDAO replayDAO = ReplyDAOFactory.getReplyDAOInstance();
				replayDAO.addReplay(replay);		
			}
		}		
		return rp;
	}
}
