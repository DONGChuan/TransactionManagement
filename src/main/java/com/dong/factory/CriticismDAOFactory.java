package com.dong.factory;

import com.dong.dao.CriticismDAO;
import com.dong.daoImpl.CriticismDAOImpl;

public class CriticismDAOFactory {
	public static CriticismDAO getCriticismDAOInstance(){	
		return new CriticismDAOImpl();						
	}
}
