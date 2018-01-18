package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


public class SybaseDBUtils {
	private static Logger logger = Logger.getLogger(SybaseDBUtils.class);

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (Exception e) {
				logger.error("SybaseDBUtils", e);
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("SybaseDBUtils", e);
			}
		}
	}

	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				logger.error("SybaseDBUtils", e);
			}
		}
	}

	public static void closePStatement(PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				logger.error("SybaseDBUtils", e);
			}
		}
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(stmt);
		closeConnection(conn);
	}

	public static void close(Connection conn, Statement stmt,
			PreparedStatement pst, ResultSet rs) {
		closeResultSet(rs);
		closePStatement(pst);
		closeStatement(stmt);
		closeConnection(conn);
	}

	public static void roolback(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
