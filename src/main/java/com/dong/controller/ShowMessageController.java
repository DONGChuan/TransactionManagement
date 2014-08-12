package com.dong.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bean.Criticism;
import com.dong.bean.Message;
import com.dong.bean.Reply;
import com.dong.dao.CriticismDAO;
import com.dong.dao.MessageDAO;
import com.dong.dao.ReplyDAO;
import com.dong.factory.CriticismDAOFactory;
import com.dong.factory.MessageDAOFactory;
import com.dong.factory.ReplyDAOFactory;
import com.dong.util.Page;
import com.dong.util.PageUtil;

@Controller
@RequestMapping("/getMessage")
public class ShowMessageController {
	
//	@RequestMapping(method = RequestMethod.GET) 
//	public String showMsgPage(){
//		return "showMsg";
//	}
	
	@RequestMapping(method = RequestMethod.GET) 
	public ModelAndView showMsg(@RequestParam("messageID") String messageIDstr,
								@RequestParam(value = "currentPage", defaultValue = "1") String currentPageStr) {
		
		// Get messageID from request
		int messageID = Integer.parseInt(messageIDstr);
		
		// Get message from message DAO
		MessageDAO messageDAO = MessageDAOFactory.getMessageAOInstance();
		Message message = messageDAO.findMessageById(messageID);
		
		int currentPage = Integer.parseInt(currentPageStr);
		
		ReplyDAO replayDAO = ReplyDAOFactory.getReplyDAOInstance();
		
		// Create the page 
		Page page = PageUtil.createPage(5, 
				replayDAO.findCountByMsgID(messageID), currentPage);
		
		// Get the list of replys from DB
		List<Reply> replys = replayDAO.
						findReplayByMsgID(messageID, page);
		
		CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
		Criticism criticism = criticismDAO.findCriticismByMsgID(messageID);
		
		
		ModelAndView rp = new ModelAndView();
		rp.addObject("message", message);
		rp.addObject("criticism", criticism);
		rp.addObject("replyList", replys);
		rp.addObject("page", page);
		rp.setViewName("showMsg");

		return rp;
	}
}
