package com.dong.dao;

import java.util.List;

import com.dong.bean.Message;
import com.dong.util.Page;

public interface MessageDAO {
	public void addMessage(Message message);	
	public void updateMessage(Message message);	
	public void deleteMessage(int messageID);		
	public List<Message> findAllMessagee(Page page);		
	public Message findMessageById(int messageID);	
	public int findAllCount();	
}
