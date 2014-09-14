package com.dong.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="tb_message")
public class Message {
	
	@Id
	@Column(name="messageID", unique = true, nullable = false, length = 11)
	@GeneratedValue
	private int messageID;	
	
	@ManyToOne  
	@JoinColumn(name = "employeeID")  
	private int employee;
	
	@Column(name="messageTitle")
	private String messageTitle;
	
	@Column(name="messageContent")
	private String messageContent;	
	
	@Column(name="publishTime")
	private Date publishTime;	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "message")
    private List<Criticism> criticisms;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "message")
    private List<Reply> Replys;
	
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public int getEmployee() {
		return employee;
	}
	public void setEmployee(int employee) {
		this.employee = employee;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public List<Criticism> getCriticisms() {
		return criticisms;
	}
	public void setCriticisms(List<Criticism> criticisms) {
		this.criticisms = criticisms;
	}
	public List<Reply> getReplys() {
		return Replys;
	}
	public void setReplys(List<Reply> replys) {
		Replys = replys;
	}
	
}
