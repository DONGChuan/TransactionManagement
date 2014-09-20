package com.dong.bo;

import com.dong.model.Employee;

public interface EmployeeBo {
	
	void save(Employee employee);
	void update(Employee employee);
	void delete(Employee employee);
	Employee findByEmployeeID(int employeeID);
	
}
