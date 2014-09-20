package com.dong.dao;

import com.dong.model.Employee;

public interface EmployeeDao {
	
	void save(Employee employee);
	void update(Employee employee);
	void delete(Employee employee);
	Employee findByEmployeeID(int employeeID);
	
}
