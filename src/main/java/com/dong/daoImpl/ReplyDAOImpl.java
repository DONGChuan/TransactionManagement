package com.dong.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dong.bean.Reply;
import com.dong.dao.ReplyDAO;
import com.dong.util.DBConnection;
import com.dong.util.Page;

public class ReplyDAOImpl implements ReplyDAO {
	
	public void addReplay(Reply replay) {
		
		Connection conn = DBConnection.getConnection();		
		String addSQL = "insert into tb_reply(replyContent," +
				"employeeID,replyTime,messageID) values(?,?,?,?)";
		PreparedStatement pstmt = null;	
		
		try {
			pstmt = conn.prepareStatement(addSQL);			
			pstmt.setString(1, replay.getReplyContent());	
			pstmt.setInt(2, replay.getEmployeeID());		
			pstmt.setTimestamp(3,new Timestamp(
					replay.getReplyTime().getTime()));		
			pstmt.setInt(4, replay.getMessageID());			
			pstmt.executeUpdate();								
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(conn);							
		}
	}

	/*
	 *  Return number of replies in one message with messageID
	 */
	public int findCountByMsgID(int messageID) {
		
		Connection conn = DBConnection.getConnection();	
		String findSQL = "select count(*) from tb_reply where messageID = ?";
		PreparedStatement pstmt = null;					
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(findSQL);		
			pstmt.setInt(1, messageID);
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

	public List<Reply> findReplayByMsgID(int messageID, Page page) {
		
		Connection conn = DBConnection.getConnection();	
		String findSQL = "select * from tb_reply" +
								" where messageID = ? limit ?,?";
		
		PreparedStatement pstmt = null;					
		ResultSet rs = null;
		List<Reply> replays = new ArrayList<Reply>();
		
		try {
			
			pstmt = conn.prepareStatement(findSQL);		
			pstmt.setInt(1, messageID);
			pstmt.setInt(2, page.getBeginIndex());
			pstmt.setInt(3, page.getEveryPage());
			rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				Reply reply = new Reply();
				reply.setReplyID(rs.getInt(1));		
				reply.setReplyContent(rs.getString(2));
				reply.setEmployeeID(rs.getInt(3));
				reply.setReplyTime(rs.getTimestamp(4));
				reply.setMessageID(rs.getInt(5));
				replays.add(reply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);								
			DBConnection.close(pstmt);							
			DBConnection.close(conn);							
		}
		return replays;
	}
}
