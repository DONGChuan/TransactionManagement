package com.dong.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void add(Reply replay) {
		replyDao.add(replay);
	}

	@Override
	public List<Reply> findReplayByMsgID(int messageID, Page page) {
		return replyDao.findReplayByMsgID(messageID, page);
	}

	@Override
	public int findCountByMsgID(int messageID) {
		return replyDao.findCountByMsgID(messageID);
	}

}
