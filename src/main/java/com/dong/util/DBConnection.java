package com.dong.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String DB_DRIVER 
		= "com.mysql.jdbc.Driver" ;			
    private static final String DB_URL 
    	= "jdbc:mysql://localhost:3306/db_tranmanagement";
    private static final String DB_USER = "root" ;						
    private static final String DB_PASSWORD = "root";	
    
	/**
	 * This method connects to DB and return the connection
	 *
	 * @return       Connection
	 */
	public static Connection getConnection(){
		Connection conn = null;													
		try {
			Class.forName(DB_DRIVER);											
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);	
		} catch (ClassNotFoundException | SQLException e) {									
			e.printStackTrace();										
		} 
		return conn;
	}
	
	/**
	 * This method closes the given connection
	 *
	 * @param  conn  connection of DB
	 * @return       void
	 */
	public static void close(Connection conn) {
		if(conn != null) {				
			try {
				conn.close();			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This method closes the Prepared Statement
	 *
	 * @param  pstmt  PreparedStatement
	 * @return        void
	 */
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {				
			try {
				pstmt.close();			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * This method closes the ResultSet object's database and JDBC resources immediately
	 *
	 * @param  rs  resultSet
	 * @return     void
	 */
	public static void close(ResultSet rs) {
		if(rs != null) {				
			try {
				rs.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
