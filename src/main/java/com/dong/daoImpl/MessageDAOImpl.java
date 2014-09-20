package com.dong.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dong.dao.MessageDao;
import com.dong.model.Message;
import com.dong.util.Page;

@Repository("MessageDao")
public class MessageDaoImpl implements MessageDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public void add(Message message) {
		getCurrentSession().save(message);
	}

	@Override
	public void update(Message message) {
		getCurrentSession().update(message);
	}

	@Override
	public void delete(Message message) {
		getCurrentSession().delete(message);
	}
	
	@Override
	public List<Message> findAllMessagee(Page page) {
		
		String hql = "FROM Message M " +
					"ORDER BY E.publishTime DESC";
		
		Query query = getCurrentSession().createQuery(hql);
		query.setFirstResult(page.getBeginIndex());
		query.setMaxResults(page.getEveryPage());
		List<Message> results = query.list();
	
		return results;
	}
	
	@Override
	public Message findMessageById(int messageID) {	
		return (Message) getCurrentSession().get(Message.class, messageID);
	}

	@Override
	public int findAllCount() {
			
		String hql = "SELECT COUNT(M) FROM Message M";
		Query query = getCurrentSession().createQuery(hql);
		List results = query.list();
		
		return (int) results.get(0);
	}	
}
