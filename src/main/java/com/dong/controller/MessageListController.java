package com.dong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("/getMessageList")
public class MessageListController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showMsgList(@RequestParam(value = "currentPage", defaultValue = "1") String currentPageStr/*HttpServletRequest rq*/) {
		
		int currentPage = Integer.parseInt(currentPageStr);

		// Get message from DB
		MessageDAO messageDAO = MessageDAOFactory.getMessageAOInstance();
		Page page = PageUtil.createPage(5, messageDAO.findAllCount(), currentPage);
		List<Message> messages = messageDAO.findAllMessagee(page);
		
		ModelAndView rp = new ModelAndView();
		rp.addObject("messageList", messages);
		rp.addObject("page", page);
		rp.setViewName("msgList");
		
		return rp;
	}
}
