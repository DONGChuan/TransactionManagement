package com.dong.factory;

import com.dong.dao.MessageDAO;
import com.dong.daoImpl.MessageDAOImpl;

public class MessageDAOFactory {
	public static MessageDAO getMessageAOInstance(){	//������������������DAOʵ����ʵ��
		return new MessageDAOImpl();						//����DAOʵ����ʵ��
	}
}
