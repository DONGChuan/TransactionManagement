package com.dong.dao;

import java.util.List;

import com.dong.model.Message;
import com.dong.util.Page;

public interface MessageDao {
	
	void add(Message message);	
	void update(Message message);	
	void delete(Message message);		
	List<Message> findAllMessagee(Page page);		
	Message findMessageById(int messageID);	
	int findAllCount();	
}
