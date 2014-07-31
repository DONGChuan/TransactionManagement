package com.dong.factory;

import com.dong.dao.ReplyDAO;
import com.dong.daoImpl.ReplyDAOImpl;

public class ReplyDAOFactory {
	public static ReplyDAO getReplyDAOInstance(){	
		return new ReplyDAOImpl();						
	}
}
