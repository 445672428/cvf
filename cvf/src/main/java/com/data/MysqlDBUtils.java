package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MysqlDBUtils {
	private static final String _DRIVER = "com.mysql.jdbc.Driver";
	private static final String _URL = "jdbc:mysql://localhost:3306/datas?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true";
	private static final String _USERNAME = "root";
	private static final String _PASSWORD = "199345";
	
	static{
		try {
			Class.forName(_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(_URL, _USERNAME, _PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection,PreparedStatement statement,ResultSet resultSet){
		if (resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				resultSet = null;
			}
		}
		if (statement!=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				statement = null;
			}
		}
		if (connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				connection = null;
			}
		}
	}
}
