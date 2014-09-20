package com.dong.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void add(Message message) {
		messageDao.add(message);
	}

	@Override
	@Transactional
	public void update(Message message) {
		messageDao.update(message);
	}

	@Override
	@Transactional
	public void delete(Message message) {
		messageDao.delete(message);
	}

	@Override
	@Transactional
	public List<Message> findAllMessagee(Page page) {
		return messageDao.findAllMessagee(page);
	}

	@Override
	@Transactional
	public Message findMessageById(int messageID) {
		return messageDao.findMessageById(messageID);
	}

	@Override
	@Transactional
	public int findAllCount() {
		return messageDao.findAllCount();
	}

}
