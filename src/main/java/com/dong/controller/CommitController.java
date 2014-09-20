package com.dong.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bo.CriticismBo;
import com.dong.bo.ReplyBo;
import com.dong.model.Criticism;
import com.dong.model.Employee;
import com.dong.model.Message;
import com.dong.model.Reply;

@Controller
@RequestMapping("/commit")
@SessionAttributes("employee")
public class CommitController {
	
	@Autowired
	@Qualifier(value="ReplyBo")
    private ReplyBo replyBo;
	
	@Autowired
    private CriticismBo criticismBo;
	
	@RequestMapping(value = "criticism", method = RequestMethod.POST)
	public ModelAndView commitCriticism(@RequestParam("criticismContent") String criticismContent,
			@RequestParam("message") Message message,
			@ModelAttribute("employee") Employee employee) {
		
		ModelAndView rp = new ModelAndView();
		//int messageID = Integer.parseInt(messageIDStr);

		if(employee == null) {
			rp.addObject("error", "Must Log In Firstly");
		}else {
			if(criticismContent == null || "".equals(criticismContent)) { 
				rp.addObject("error", "Content Can Not Be Empty");
			}else {
				Criticism criticism = new Criticism();
				criticism.setCriticismContent(criticismContent);
				criticism.setEmployee(employee);
				criticism.setCriticismTime(new Date());
				criticism.setMessage(message);
				
				criticismBo.add(criticism);
			}
		}
		rp.setViewName("getMessage");
		
		return rp;
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public ModelAndView commitReply(@RequestParam("replyContent") String replyContent,
			@RequestParam("messageID") Message message,
			@ModelAttribute("employee") Employee employee) {
		
		ModelAndView rp = new ModelAndView();
	
		if(employee == null) {
			rp.addObject("error", "Must Log In Firstly");
		}else {
			if(replyContent == null || "".equals(replyContent)) { 
				rp.addObject("error", "Content Can Not Be Empty");
			}else {
				Reply replay = new Reply();
				replay.setReplyContent(replyContent);
				replay.setMessage(message);		
				replay.setEmployee(employee);
				replay.setReplyTime(new Date());	

				replyBo.add(replay);		
			}
		}		
		return rp;
	}
}
