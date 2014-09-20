package com.dong.factory;

import com.dong.dao.CriticismDao;
import com.dong.daoImpl.CriticismDaoImpl;

public class CriticismDAOFactory {
	public static CriticismDao getCriticismDAOInstance(){	
		return new CriticismDaoImpl();						
	}
}
