package com.dong.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dong.dao.CriticismDao;
import com.dong.model.Criticism;

@Repository("CriticismDao")
public class CriticismDaoImpl implements CriticismDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Criticism criticism) {
		getCurrentSession().save(criticism);
	}

	@Override
	public void update(Criticism criticism) {
		getCurrentSession().update(criticism);
	}

	@Override
	public void delete(Criticism criticism) {
		getCurrentSession().delete(criticism);		
	}

	@Override
	public Criticism findByMessageID(int messageID) {
		return (Criticism) getCurrentSession().get(Criticism.class, messageID);
	}
	
}
