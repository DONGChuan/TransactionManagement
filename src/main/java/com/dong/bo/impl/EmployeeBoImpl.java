package com.dong.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dong.bo.EmployeeBo;
import com.dong.dao.EmployeeDao;
import com.dong.model.Employee;

@Service("EmployeeBo")
public class EmployeeBoImpl implements EmployeeBo{
	
	@Autowired
	EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		employeeDao.update(employee);	
	}

	@Override
	@Transactional
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}

	@Override
	@Transactional
	public Employee findByEmployeeID(int employeeID) {
		return employeeDao.findByEmployeeID(employeeID);
	}

}
