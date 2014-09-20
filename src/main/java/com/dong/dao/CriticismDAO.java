package com.dong.dao;

import com.dong.model.Criticism;

public interface CriticismDao {
	
	void add(Criticism criticism);		 
	void update(Criticism criticism);
	void delete(Criticism criticism);
	Criticism findByMessageID(int messageID); 

}
