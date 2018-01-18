package others.demo.imagevalidate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.junit.Test;

public class CallbackDemo {
    @Test
    public void test1() {
        Connection connection = null;
        CallableStatement statement = null;
        try {
            connection.prepareCall("{call demosql(?,?)}");
            statement.setString(1, "index1"); //参数
            statement.registerOutParameter(2, Types.VARCHAR);//返回值
            statement.execute();
            String result = statement.getString(2);
            System.out.println(result);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
        }
    }
}
