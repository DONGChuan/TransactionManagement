package com.dong.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dong.bean.Criticism;
import com.dong.bean.Employee;
import com.dong.dao.CriticismDAO;
import com.dong.factory.CriticismDAOFactory;

public class CommitCriticism extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gbk");
		String criticismContent = request.getParameter("criticismContent");
		int messageID = Integer.parseInt(request.getParameter("messageID"));
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;

		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("error", "要进行批复必须首先进行身份识别");
		}else {
			if(criticismContent == null || "".equals(criticismContent)) { 
				request.setAttribute("error", "必须输入批复内容");
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
		dispatcher = servletContext.
				getRequestDispatcher("/GetMessage?messageID=" + messageID);
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
