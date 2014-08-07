package com.dong.dao;

import com.dong.bean.Criticism;

public interface CriticismDAO {
	
	public void addCriticism(Criticism criticism);		  // ADD
	public Criticism findCriticismByMsgID(int messageID); // FIND BY ID
	
}
