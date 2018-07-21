package com.base.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.base.intface.ConnectionHolder;
import com.sql.DB;

public class ConnectionHolderDefault implements ConnectionHolder {
	private static final int LIMIT = 500;

	@Override
	public List<Map<String, Object>> query(DB db, String sql) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(db.getDriver());
			connection = DriverManager.getConnection(db.getUrl(),db.getUsername(), db.getPassword());
			logger.info(sql);
			statement = connection.prepareStatement(sql,ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			statement.setFetchSize(LIMIT);
			resultSet = statement.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int count = metaData.getColumnCount();
			String[] name = new String[count];
			for (int i = 0; i < count; i++) {
				name[i] = metaData.getColumnName(i + 1);
			}
			while (resultSet.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				for (int i = 0; i < count; i++) {
					Object obj = resultSet.getObject(i);
					String columnName = name[i];
					m.put(columnName, obj);
				}
				list.add(m);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			close(connection,statement,resultSet);
		}
		return list;
	}

	@Override
	public int update(DB db, String sql) {
		Connection connection = null;
		Statement statement = null;
		int cnt = 0;
		try {
			Class.forName(db.getDriver());
			connection = DriverManager.getConnection(db.getUrl(),db.getUsername(), db.getPassword());
			statement = connection.createStatement();
			logger.info(sql);
			cnt = statement.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			close(connection,statement,null);
		}
		return cnt;
	}

	@Override
	public boolean delete(DB db, String sql) {
		Connection connection = null;
		Statement statement = null;
		boolean cnt = false;
		try {
			Class.forName(db.getDriver());
			connection = DriverManager.getConnection(db.getUrl(),db.getUsername(), db.getPassword());
			statement = connection.createStatement();
			logger.info(sql);
			cnt = statement.execute(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			close(connection,statement,null);
		}
		return cnt;
	}

	@Override
	public void save(DB db, String sql) {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName(db.getDriver());
			connection = DriverManager.getConnection(db.getUrl(),db.getUsername(), db.getPassword());
			statement = connection.createStatement();
			logger.info(sql);
			statement.execute(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			close(connection,statement,null);
		}
	}
	
	@Override
	public boolean execute(DB db, String sql) {
		Connection connection = null;
		Statement statement = null;
		boolean cnt = false;
		try {
			Class.forName(db.getDriver());
			connection = DriverManager.getConnection(db.getUrl(),db.getUsername(), db.getPassword());
			statement = connection.createStatement();
			logger.info(sql);
			cnt = statement.execute(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			close(connection,statement,null);
		}
		return cnt;
	}
	
	@Override
	public int queryForInt(DB db, String sql) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int cnt = 0;
		try {
			Class.forName(db.getDriver());
			connection = DriverManager.getConnection(db.getUrl(),db.getUsername(), db.getPassword());
			statement = connection.createStatement();
			logger.info(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				cnt = resultSet.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			close(connection,statement,resultSet);
		}
		return cnt;
	}
	private void close(Connection connection, Statement statement,ResultSet resultSet) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
		}
	}
}
