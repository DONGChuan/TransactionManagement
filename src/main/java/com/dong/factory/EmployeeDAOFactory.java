package com.dong.factory;

import com.dong.dao.EmployeeDAO;
import com.dong.daoImpl.EmployeeDAOImpl;

public class EmployeeDAOFactory {
	public static EmployeeDAO getEmployeeDAOInstance(){	
		return new EmployeeDAOImpl();						
	}
}
