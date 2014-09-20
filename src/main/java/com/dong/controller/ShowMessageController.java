package com.dong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bo.CriticismBo;
import com.dong.bo.MessageBo;
import com.dong.bo.ReplyBo;
import com.dong.model.Criticism;
import com.dong.model.Message;
import com.dong.model.Reply;
import com.dong.util.Page;
import com.dong.util.PageUtil;

@Controller
@RequestMapping("/getMessage")
public class ShowMessageController {
	
	@Autowired
    private MessageBo messageBo;
	
	@Autowired
    private ReplyBo replyBo;
	
	@Autowired
    private CriticismBo criticismBo;
	
	@RequestMapping(method = RequestMethod.GET) 
	public ModelAndView showMsg(@RequestParam("messageID") String messageIDstr,
								@RequestParam(value = "currentPage", defaultValue = "1") String currentPageStr) {
		
		// Get messageID from request
		int messageID = Integer.parseInt(messageIDstr);
		
		Message message = messageBo.findMessageById(messageID);
		
		int currentPage = Integer.parseInt(currentPageStr);
		
		// Create the page 
		Page page = PageUtil.createPage(5, 
				replyBo.findCountByMsgID(messageID), currentPage);
		
		// Get the list of replys from DB
		List<Reply> replys = replyBo.
						findReplayByMsgID(messageID, page);
		
		Criticism criticism = criticismBo.findByMessageID(messageID);
		
		ModelAndView rp = new ModelAndView();
		rp.addObject("message", message);
		rp.addObject("criticism", criticism);
		rp.addObject("replyList", replys);
		rp.addObject("page", page);
		rp.setViewName("showMsg");

		return rp;
	}
}
