package pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionBean {
	private static String mysqlDriver;
	private static String mysqlUrl;
	private static String mysqlUser;
	private static String mysqlPassword;

	private static String sybaseDriver;
	private static String sybaseUrl;
	private static String sybaseUser;
	private static String sybasePassword;

	private static ConnectionBean instance;

	private ConnectionBean() {
	}

	public static synchronized ConnectionBean getInstance() {
		if (instance == null) {
			loadPropertys();
			instance = new ConnectionBean();
		}
		return instance;
	}

	private static void loadPropertys() {
		URL realPath = Thread.currentThread().getContextClassLoader().getResource("");
		String path = ConnectionBean.class.getClass().getResource("/").getPath();
		Properties properties = new Properties();
		//InputStream mysqlinputStream = null;
		//InputStream sybaseinputStream = null;
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("D:/works/frame/src/main/resources/config/jdbc-sybase.properties"));
			//sybaseinputStream = new FileInputStream(new File(path+ "jdbc-sybase.properties"));
			properties.load(inputStream);
			sybaseDriver = properties.getProperty("sybase.driverClassName");
			sybaseUrl = properties.getProperty("sybase.url");
			sybaseUser = properties.getProperty("sybase.username");
			sybasePassword = properties.getProperty("sybase.password");
			
			inputStream = new FileInputStream(new File("D:/works/frame/src/main/resources/config/jdbc-mysql.properties"));
			properties.load(inputStream);
			mysqlDriver = properties.getProperty("jdbc.mysql.driverClassName");
			mysqlUrl = properties.getProperty("jdbc.mysql.url");
			mysqlUser = properties.getProperty("jdbc.mysql.username");
			mysqlPassword = properties.getProperty("jdbc.mysql.password");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public Connection getMysqlConnection(){
		Connection connection = null;
		try {
			Class.forName(mysqlDriver);
			connection = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public Connection getSybaseConnection(){
		Connection connection = null;
		try {
			Class.forName(sybaseDriver);
			connection = DriverManager.getConnection(sybaseUrl, sybaseUser, sybasePassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				if (!connection.isClosed())
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public  void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closePStatement(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(Connection connection, Statement statement, ResultSet resultSet) {
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(connection);
	}

	public void close(Connection connection, Statement statement,PreparedStatement preparedStatement, ResultSet resultSet) {
		closeResultSet(resultSet);
		closePStatement(preparedStatement);
		closeStatement(statement);
		closeConnection(connection);
	}

	public void roolback(Connection connection) {
		try {
			connection.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
