package com.dong.factory;

import com.dong.dao.MessageDao;
import com.dong.daoImpl.MessageDaoImpl;

public class MessageDAOFactory {
	public static MessageDao getMessageAOInstance(){	//工厂方法，用来返回DAO实现类实例
		return new MessageDaoImpl();						//返回DAO实现类实例
	}
}
