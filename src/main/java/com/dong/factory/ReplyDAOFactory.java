package com.dong.factory;

import com.dong.dao.ReplyDao;
import com.dong.daoImpl.ReplyDaoImpl;

public class ReplyDAOFactory {
	public static ReplyDao getReplyDAOInstance(){	
		return new ReplyDaoImpl();						
	}
}
