package com.dong.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dong.dao.ReplyDao;
import com.dong.model.Reply;
import com.dong.util.DBConnection;
import com.dong.util.Page;

@Repository("ReplyDao")
public class ReplyDaoImpl implements ReplyDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Reply replay) {
		getCurrentSession().save(replay);
	}
	
	@Override
	public int findCountByMsgID(int messageID) {
		
		String hql = "SELECT COUNT(R) FROM Reply R" +
					"WHERE R.messageID = :messageID";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("messageID", messageID);
		
		List results = query.list();
		
		return (int) results.get(0);
	}
	
	@Override
	public List<Reply> findReplayByMsgID(int messageID, Page page) {
		
		String hql = "FROM Reply R WHERE R.messageID = :messageID";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("messageID", messageID);
		query.setFirstResult(page.getBeginIndex());
		query.setMaxResults(page.getEveryPage());
		
		List<Reply> results = query.list();
		
		return results;
	}
}
