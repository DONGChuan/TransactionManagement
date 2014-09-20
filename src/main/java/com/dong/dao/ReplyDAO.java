package com.dong.dao;

import java.util.List;

import com.dong.model.Reply;
import com.dong.util.Page;

public interface ReplyDao {
	
	public void add(Reply replay);			
	public List<Reply> findReplayByMsgID(int messageID,Page page);
	public int findCountByMsgID(int messageID);
	
}
