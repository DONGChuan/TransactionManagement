package com.dong.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dong.bo.ReplyBo;
import com.dong.dao.ReplyDao;
import com.dong.model.Reply;
import com.dong.util.Page;

@Service("ReplyBo")
public class ReplyBoImpl implements ReplyBo {
	
	@Autowired
	ReplyDao replyDao;
	
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	@Transactional
	public void add(Reply replay) {
		replyDao.add(replay);
	}

	@Override
	@Transactional
	public List<Reply> findReplayByMsgID(int messageID, Page page) {
		return replyDao.findReplayByMsgID(messageID, page);
	}

	@Override
	@Transactional
	public int findCountByMsgID(int messageID) {
		return replyDao.findCountByMsgID(messageID);
	}

}
