package others.demo.imagevalidate;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCDemo {

    private static String driverClass;

    private static String url;

    private static String user;

    private static String password;
    static {
        try {
            ClassLoader loader = JDBCDemo.class.getClassLoader();
            InputStream inputStream = loader.getResourceAsStream("dbcfg.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            inputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Class.forName(driverClass);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static Connection getConnect() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException("运行错误");
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
