package com.dong.bean;

import java.util.Date;

import org.springframework.context.annotation.Scope;

@Scope("session")
public class Employee {
	private int employeeID;			
	private String employeeName;	
	private boolean employeeSex;	
	private Date employeeBirth;		
	private String employeePhone;	
	private String employeePlace;	
	private Date joinTime;			
	private String password;		
	private boolean isLead;		
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public boolean isEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(boolean employeeSex) {
		this.employeeSex = employeeSex;
	}
	public Date getEmployeeBirth() {
		return employeeBirth;
	}
	public void setEmployeeBirth(Date employeeBirth) {
		this.employeeBirth = employeeBirth;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeePlace() {
		return employeePlace;
	}
	public void setEmployeePlace(String employeePlace) {
		this.employeePlace = employeePlace;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLead() {
		return isLead;
	}
	public void setLead(boolean isLead) {
		this.isLead = isLead;
	}
}
