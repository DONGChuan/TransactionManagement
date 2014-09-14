package com.dong.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dong.bean.Message;
import com.dong.dao.MessageDAO;
import com.dong.util.DBConnection;
import com.dong.util.Page;

public class MessageDAOImpl implements MessageDAO{

	public void addMessage(Message message) {
		
		Connection conn = DBConnection.getConnection();	
		String addSQL = "insert into tb_message(messageTitle,messageContent,employeeID,publishTime) values(?,?,?,?)";
		PreparedStatement pstmt = null;	
		
		try {
			pstmt = conn.prepareStatement(addSQL);		
			pstmt.setString(1, message.getMessageTitle());	
			pstmt.setString(2, message.getMessageContent());
			pstmt.setInt(3, message.getEmployee());			
			pstmt.setTimestamp(4, new Timestamp(message.getPublishTime().getTime()));
			pstmt.executeUpdate();								
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);					
			DBConnection.close(conn);							
		}
	}

	public void deleteMessage(int messageID) {
		
		Connection conn = DBConnection.getConnection();
		String deleteSQL = "delete from tb_message where messageID = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, messageID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);					
			DBConnection.close(conn);	
		}
	}

	public List<Message> findAllMessagee(Page page) {
		Connection conn = DBConnection.getConnection();	
		String findSQL = "select * from tb_message " +
					"order by  publishTime desc limit ?,?";
		PreparedStatement pstmt = null;					
		ResultSet rs = null;
		List<Message> messages = new ArrayList<Message>();
		try {
			pstmt = conn.prepareStatement(findSQL);		
			pstmt.setInt(1, page.getBeginIndex());		
			pstmt.setInt(2, page.getEveryPage());		
			rs = pstmt.executeQuery();				
			while(rs.next()) {
				Message message = new Message();
				message.setMessageID(rs.getInt(1));	
				message.setMessageTitle(rs.getString(2));
				message.setMessageContent(
						rs.getString(3));			
				message.setEmployee(rs.getInt(4));
				message.setPublishTime(rs.getTimestamp(5));
				messages.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);							
			DBConnection.close(pstmt);							
			DBConnection.close(conn);				
		}
		return messages;
	}

	public Message findMessageById(int messageID) {
		Connection conn = DBConnection.getConnection();
		String querySQL  = "select * from tb_message where messageID = ?";
		PreparedStatement pstmt = null;					
		ResultSet rs = null;
		Message message = null;
		try {
			pstmt = conn.prepareStatement(querySQL);		
			pstmt.setInt(1, messageID);
			rs = pstmt.executeQuery();					
			if(rs.next()) {
				message = new Message();
				message.setMessageID(rs.getInt(1));	
				message.setMessageTitle(rs.getString(2));
				message.setMessageContent(
						rs.getString(3));			
				message.setEmployee(rs.getInt(4));
				message.setPublishTime(rs.getTimestamp(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);								
			DBConnection.close(pstmt);							
			DBConnection.close(conn);							
		}
		return message;
	}

	public void updateMessage(Message message) {
		
	}

	public int findAllCount() {
		Connection conn = DBConnection.getConnection();	
		String findSQL = "select count(*) from tb_message";
		PreparedStatement pstmt = null;					
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(findSQL);		
			rs = pstmt.executeQuery();					
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);						
			DBConnection.close(pstmt);					
			DBConnection.close(conn);					
		}
		return count;
	}
}
