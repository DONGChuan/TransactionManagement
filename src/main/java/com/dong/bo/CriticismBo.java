package com.dong.bo;

import com.dong.model.Criticism;

public interface CriticismBo {
	
	void add(Criticism criticism);		 
	void update(Criticism criticism);
	void delete(Criticism criticism);
	Criticism findByMessageID(int messageID); 
	
}
