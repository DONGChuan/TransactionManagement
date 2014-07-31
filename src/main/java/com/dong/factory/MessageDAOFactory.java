package com.dong.factory;

import com.dong.dao.MessageDAO;
import com.dong.daoImpl.MessageDAOImpl;

public class MessageDAOFactory {
	public static MessageDAO getMessageAOInstance(){	//工厂方法，用来返回DAO实现类实例
		return new MessageDAOImpl();						//返回DAO实现类实例
	}
}
