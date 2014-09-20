package com.dong.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dong.bo.MessageBo;
import com.dong.dao.MessageDao;
import com.dong.model.Message;
import com.dong.util.Page;

@Service("MessageBo")
public class MessageBoImpl implements MessageBo{
	
	@Autowired
	MessageDao messageDao;
	
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public void add(Message message) {
		messageDao.add(message);
	}

	@Override
	public void update(Message message) {
		messageDao.update(message);
	}

	@Override
	public void delete(Message message) {
		messageDao.delete(message);
	}

	@Override
	public List<Message> findAllMessagee(Page page) {
		return messageDao.findAllMessagee(page);
	}

	@Override
	public Message findMessageById(int messageID) {
		return messageDao.findMessageById(messageID);
	}

	@Override
	public int findAllCount() {
		return messageDao.findAllCount();
	}

}
