package com.dong.dao;

import java.util.List;
import com.dong.bean.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee employee);	      // ADD	
	public void updateEmployee(Employee employee);	  // UPDATE
	public void deleteEmployee(int employeeID);		  // DELETE
	public List<Employee> findAllEmployee();		  // FIND ALL
	public Employee findEmployeeById(int employeeID); // FIND BY ID
	
}
