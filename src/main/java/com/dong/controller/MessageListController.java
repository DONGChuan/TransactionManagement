package com.dong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dong.bo.MessageBo;
import com.dong.model.Message;
import com.dong.util.Page;
import com.dong.util.PageUtil;

@Controller
@RequestMapping("/getMessageList")
public class MessageListController {
	
	@Autowired
    private MessageBo messageBo;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showMsgList(@RequestParam(value = "currentPage", defaultValue = "1") String currentPageStr) {
		
		int currentPage = Integer.parseInt(currentPageStr);

		Page page = PageUtil.createPage(5, messageBo.findAllCount(), currentPage);
		List<Message> messages = messageBo.findAllMessagee(page);
		
		ModelAndView rp = new ModelAndView();
		rp.addObject("messageList", messages);
		rp.addObject("page", page);
		rp.setViewName("msgList");
		
		return rp;
	}
}
