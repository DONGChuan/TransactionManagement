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
@Table(name="tb_reply")
public class Reply {
	
	@Id
	@Column(name="replyID", unique = true, nullable = false, length = 11)
	@GeneratedValue
	private int replyID;	
	
	@ManyToOne  
	@JoinColumn(name = "employeeID")
	private int employee;	
	
	@ManyToOne  
	@JoinColumn(name = "messageID")
	private int message;	
	
	@Column(name="replyContent")
	private String replyContent;
	
	@Column(name="replyTime")
	private Date replyTime;	
	
	public int getReplyID() {
		return replyID;
	}
	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public int getEmployee() {
		return employee;
	}
	public void setEmployee(int employee) {
		this.employee = employee;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public int getMessage() {
		return message;
	}
	public void setMessage(int message) {
		this.message = message;
	}
	
}
