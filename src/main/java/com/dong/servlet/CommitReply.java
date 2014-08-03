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
import com.dong.bean.Reply;
import com.dong.dao.ReplyDAO;
import com.dong.factory.ReplyDAOFactory;

public class CommitReply extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		String replyContent = request.
					getParameter("replyContent");
		int messageID = Integer.parseInt(
				request.getParameter("messageID"));
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
	
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("error", "Ҫ���лظ��������Ƚ������ʶ��");
			
		}else {
			if(replyContent == null || "".equals(replyContent)) { 
				request.setAttribute("error", "��������ظ�����");
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
		dispatcher = servletContext.getRequestDispatcher(
					"/GetMessage?messageID=" + messageID);
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
