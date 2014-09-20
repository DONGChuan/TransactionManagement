package com.dong.bo;

import java.util.List;

import com.dong.model.Message;
import com.dong.util.Page;

public interface MessageBo {
	
	void add(Message message);	
	void update(Message message);	
	void delete(Message message);		
	List<Message> findAllMessagee(Page page);		
	Message findMessageById(int messageID);	
	int findAllCount();	
	
}
