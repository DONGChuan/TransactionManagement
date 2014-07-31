package com.dong.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.dong.bean.Criticism;
import com.dong.dao.CriticismDAO;
import com.dong.util.DBConnection;

public class CriticismDAOImpl implements CriticismDAO{
	
	public void addCriticism(Criticism criticism) {
		
		Connection conn = DBConnection.getConnection();	
		String addSQL = "insert into tb_criticism(criticismContent,employeeID,criticismTime,messageID) values(?,?,?,?)";
		PreparedStatement pstmt = null;	
		
		// Fill the fields of MySQL statement
		try {
			pstmt = conn.prepareStatement(addSQL);		
			pstmt.setString(1, criticism.getCriticismContent());	
			pstmt.setInt(2, criticism.getEmployeeID());
			pstmt.setTimestamp(3,new Timestamp(criticism.getCriticismTime().getTime()));
			pstmt.setInt(4, criticism.getMessageID());
			pstmt.executeUpdate();	// Run the statement							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(conn);				
		}
	}
	
	public Criticism findCriticismByMsgID(int messageID) {
		
		Connection conn = DBConnection.getConnection();	
		String findSQL = "select * from tb_criticism where messageID = ?";
		PreparedStatement pstmt = null;					
		ResultSet rs = null;
		Criticism criticism= new Criticism();
		
		try {
			pstmt = conn.prepareStatement(findSQL);		
			pstmt.setInt(1, messageID);
			rs = pstmt.executeQuery();				
			if(rs.next()) {
				criticism.setCriticismID(rs.getInt(1));
				criticism.setCriticismContent(rs.getString(2));
				criticism.setEmployeeID(rs.getInt(3));
				criticism.setCriticismTime(rs.getTimestamp(4));
				criticism.setMessageID(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);	
			DBConnection.close(pstmt);						
			DBConnection.close(conn);						
		}
		return criticism;
	}
}
