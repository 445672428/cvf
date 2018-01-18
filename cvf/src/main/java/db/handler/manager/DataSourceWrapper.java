package db.handler.manager;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class DataSourceWrapper implements DataSource{
	private Map<String, DataSource> dataSourceMap;
	private PrintWriter logWriter;
	private int loginTimeOut = 3;
	
	public DataSource getCurrentDataSource(){
		DataSource _dataSource = this.dataSourceMap.get(DataSourceStatus.getCurrentKey());
		if (_dataSource==null) {
			
		}
		return _dataSource;
	}
	public void setDataSourceMap(Map<String, DataSource> dataSourceMap) {
		this.dataSourceMap = dataSourceMap;
	}
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return this.logWriter;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		this.logWriter = out;
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		this.loginTimeOut = seconds;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return this.loginTimeOut;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return this.getCurrentDataSource().unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return this.getCurrentDataSource().isWrapperFor(iface);
	}

	@Override
	public Connection getConnection() throws SQLException {
		return this.getCurrentDataSource().getConnection();
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		throw new SQLException("only support connection");
	}

}
