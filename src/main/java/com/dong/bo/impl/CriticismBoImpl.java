package com.dong.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dong.bo.CriticismBo;
import com.dong.dao.CriticismDao;
import com.dong.model.Criticism;

@Service("CriticismBo")
public class CriticismBoImpl implements CriticismBo{
	
	@Autowired
	CriticismDao criticismDao;
	
	public void setCriticismDao(CriticismDao criticismDao) {
		this.criticismDao = criticismDao;
	}
	
	@Override
	@Transactional
	public void add(Criticism criticism) {
		criticismDao.add(criticism);
	}

	@Override
	@Transactional
	public void update(Criticism criticism) {
		criticismDao.update(criticism);
	}

	@Override
	@Transactional
	public void delete(Criticism criticism) {
		criticismDao.delete(criticism);
	}

	@Override
	@Transactional
	public Criticism findByMessageID(int messageID) {
		return criticismDao.findByMessageID(messageID);
	}

}
