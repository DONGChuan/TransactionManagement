package com.dong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

public class GetMessage extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Get messageID from request
		int messageID = Integer.parseInt(request.getParameter("messageID"));
		
		// Get message from message DAO
		MessageDAO messageDAO = MessageDAOFactory.getMessageAOInstance();
		Message message = messageDAO.findMessageById(messageID);
		
		request.setAttribute("message", message); 
		
		int currentPage = 0;
		
		String currentPageStr = request.getParameter("currentPage");
		
		if(currentPageStr == null || "".equals(currentPageStr)){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		
		ReplyDAO replayDAO = ReplyDAOFactory.getReplyDAOInstance();
		
		// Create the page 
		Page page = PageUtil.createPage(5, 
				replayDAO.findCountByMsgID(messageID), currentPage);
		
		// Get the list of replys from DB
		List<Reply> replys = replayDAO.
						findReplayByMsgID(messageID, page);
		
		request.setAttribute("replyList", replys);
		request.setAttribute("page", page);		
		
		CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
		Criticism criticism = criticismDAO.findCriticismByMsgID(messageID);
		
		request.setAttribute("criticism", criticism);
		
		// To showMsg.jsp
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.
					getRequestDispatcher("/showMsg.jsp");	
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
