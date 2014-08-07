package com.dong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bean.Message;
import com.dong.dao.MessageDAO;
import com.dong.factory.MessageDAOFactory;
import com.dong.util.Page;
import com.dong.util.PageUtil;

@Controller
public class MessageListController {
	
	@RequestMapping(value = "/GetMessageList", method = RequestMethod.GET)
	public ModelAndView showMsgList(@RequestParam("currentPage") String currentPageStr) {
		
		int currentPage = 0;
		
		if(currentPageStr == null || "".equals(currentPageStr)){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		
		// Get message from DB
		MessageDAO messageDAO = MessageDAOFactory.getMessageAOInstance();
		Page page = PageUtil.createPage(5, messageDAO.findAllCount(), currentPage);
		List<Message> messages = messageDAO.findAllMessagee(page);
		
		Map<String,Object> rpAttribute= new HashMap<String,Object>();
		rpAttribute.put("messageList", messages);
		rpAttribute.put("page", page);

		return new ModelAndView("msgList","messageList",rpAttribute);
	}
}
