package com.dong.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dong.bean.Employee;
import com.dong.bean.Message;
import com.dong.dao.MessageDAO;
import com.dong.factory.MessageDAOFactory;

public class MsgPublish extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
	
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("error", "要发布消息必须首先进行身份识别");
			dispatcher = servletContext.
					getRequestDispatcher("/publishNewMsg.jsp");
		}else {
			if(title == null || "".equals(title)) { 
				request.setAttribute("error", "必须输入消息标题");
				dispatcher = servletContext.
						getRequestDispatcher("/publishNewMsg.jsp");
			}else {
				Message message = new Message();
				message.setEmployeeID(employee.getEmployeeID());
				message.setMessageTitle(title);
				message.setMessageContent(content);
				message.setPublishTime(new Date());
				MessageDAO messageDAO = 
					MessageDAOFactory.getMessageAOInstance();
				messageDAO.addMessage(message);		
				dispatcher = servletContext.
				getRequestDispatcher("/GetMessageList");
			}
		}
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
