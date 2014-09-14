package com.dong.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 	
@Entity
@Table(name="tb_criticism")
public class Criticism {
	
	@Id
	@Column(name="criticismID", unique = true, nullable = false, length = 11)
	@GeneratedValue
	private int criticismID;	
	
	@ManyToOne  
	@JoinColumn(name = "employeeID")  
	private Employee employee;	
	
	@ManyToOne  
	@JoinColumn(name = "messageID")  
	private Message message;	
	
	@Column(name="criticismContent")
	private String criticismContent;
	
	@Column(name="criticismTime")
	private Date criticismTime;		
	
	/*
	 * Getters and Setters
	 */
	public int getCriticismID() {
		return criticismID;
	}
	public void setCriticismID(int criticismID) {
		this.criticismID = criticismID;
	}
	public String getCriticismContent() {
		return criticismContent;
	}
	public void setCriticismContent(String criticismContent) {
		this.criticismContent = criticismContent;
	}
	public Date getCriticismTime() {
		return criticismTime;
	}
	public void setCriticismTime(Date criticismTime) {
		this.criticismTime = criticismTime;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	} 
	
}
