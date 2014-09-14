package com.dong.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 	
@Entity
@Table(name="tb_employee")
public class Employee {
	
	@Id
	@Column(name="employeeID", unique = true, nullable = false, length = 11)
	@GeneratedValue
	private int employeeID;	
	
	@Column(name="employeeName", length = 20)
	private String employeeName;
	
	@Column(name="employeeSex")
	private boolean employeeSex;
	
	@Column(name="employeeBirth")
	private Date employeeBirth;	
	
	@Column(name="employeePhone", length = 20)
	private String employeePhone;	
	
	@Column(name="employeePlace", length = 50)
	private String employeePlace;	
	
	@Column(name="joinTime")
	private Date joinTime;	
	
	@Column(name="password", length = 20)
	private String password;
	
	@Column(name="isLead")
	private boolean Lead;	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Criticism> criticisms;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Message> messages;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Reply> replys;
	
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
	public boolean getLead() {
		return Lead;
	}
	public void setLead(boolean Lead) {
		this.Lead = Lead;
	}
	public List<Criticism> getCriticisms() {
		return criticisms;
	}
	public void setCriticisms(List<Criticism> criticisms) {
		this.criticisms = criticisms;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Reply> getReplys() {
		return replys;
	}
	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}
}
