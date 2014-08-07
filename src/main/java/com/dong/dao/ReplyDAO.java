package com.dong.dao;

import java.util.List;

import com.dong.bean.Reply;
import com.dong.util.Page;

public interface ReplyDAO {
	
	public void addReplay(Reply replay);			
	public List<Reply> findReplayByMsgID(int messageID,Page page);
	public int findCountByMsgID(int messageID);
	
}
