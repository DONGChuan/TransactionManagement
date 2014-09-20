package com.dong.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dong.dao.EmployeeDao;
import com.dong.model.Employee;

@Repository("EmployeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public void save(Employee employee) {
		getCurrentSession().save(employee);
	}

	@Override
	public void update(Employee employee) {
		getCurrentSession().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		getCurrentSession().delete(employee);
	}

	@Override
	public Employee findByEmployeeID(String employeeID) {
		return (Employee) getCurrentSession().get(Employee.class, employeeID);
	}
}
