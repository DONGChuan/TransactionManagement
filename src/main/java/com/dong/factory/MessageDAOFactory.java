package com.dong.factory;

import com.dong.dao.MessageDao;
import com.dong.daoImpl.MessageDaoImpl;

public class MessageDAOFactory {
	public static MessageDao getMessageAOInstance(){	//������������������DAOʵ����ʵ��
		return new MessageDaoImpl();						//����DAOʵ����ʵ��
	}
}
