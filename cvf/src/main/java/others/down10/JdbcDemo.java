package others.down10;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcDemo {
    private String url="jdbc:oracle:thin:@localhost:1521:ibn";
    private String user="test";
    private String pwd="abs";
    private Connection conn;
    private Statement stat;
    private PreparedStatement ps;
    private ResultSet rs;
    private CallableStatement cs;
    /**
     * 关闭连接 关闭语句对象 关闭结果集
     * 注意Statement和PreparedStatement的区别
     * @param args
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public static void main(String[]args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
        JdbcDemo cont=JdbcDemo.class.newInstance();
        cont.getConnection();
        cont.callStatement();
//        Courseinfo course=new Courseinfo();
//        course.setId(5);
//        course.setUsername("小明");
//        course.setPassword("456");
//        cont.insert(course);
    }
    /**
     * 加载驱动，建立连接
     * @return
     */
    public Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn=DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     *查询数据库的表 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void conn() throws SQLException, ClassNotFoundException{
        try {
            stat=conn.createStatement();
            ResultSet rs=stat.executeQuery("select userid,username,password from userinfo");
            while(rs.next()){
                StringBuffer sb=new StringBuffer();
                String a=rs.getString(1);
                String b=rs.getString(2);
                String c=rs.getString(3);
                sb.append(a).append(b).append(c);
                System.out.println(sb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn.close();
            stat.close();
        }
    }
    /**
     * 执行插入操作 注意插入操作 insert into tablename values(id,'name','password') 注意这个单引号不能忘掉
     * @param course
     */
    public void insert(String course){
        try {
            //将自动提交事务设关闭
            conn.setAutoCommit(false);
            stat=conn.createStatement();
            String sql="insert into userinfo(userid,username,password)" +
            "values("+"1"+",'"
            +"name"+"','"+"course"+"')";
            int a=stat.executeUpdate(sql);
            if(a==1){
                System.out.println("statement插入正常");
                //事务提交
                conn.commit();
            }else{
                //事务回滚
                conn.rollback();
            }
            //将事务自动提交恢复
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{

            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * statement每次执行sql语句，相关数据库都要执行sql语句的编译
     * preparedstatement是预编译得,   preparedstatement支持批处理
     * statement执行update必须有参数
     * preparedStatement在创建时已经预编译了，没有参数
     * @param course
     */
    public void prepareInsert(Course course){

        try {
            String sql="insert into userinfo(userid,username,password)values(?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setInt(1, course.getId());
            ps.setString(2, course.getUsername());
            ps.setString(3, course.getPassword());
            int a=ps.executeUpdate();
            if(a==1){
                System.out.println("preparedStatementd插入正常");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    
    }
    /**
     * 获取数据库基本信息
     */
    public void getDbData(String tablename){
        String sql="select*from "+tablename;
        try {
            //获取数据库元数据
            DatabaseMetaData dmd=conn.getMetaData();
            //获取数据库的各种信息   数据库名字
            System.out.println(dmd.getDatabaseProductName());
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            //结果集元数据
            ResultSetMetaData rmd=rs.getMetaData();
            //获取结果集列数
            int columnCount=rmd.getColumnCount();
            for(int i=0;i<columnCount;i++){
                //获取列名
                System.out.println(rmd.getColumnName(i));
            }
            while(rs.next()){
                for(int i=0;i<columnCount;i++){
                    //由列名获取结果集
                    String value=rs.getString(rmd.getColumnName(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 批处理
     */
    public void batchExecute(){
        String sql="insert into courseinfo(userid) values(?)";
        try {
            conn.setAutoCommit(false);
            ps=conn.prepareStatement(sql);
            for(int i=5;i<100;i++){
                ps.setInt(1, i);
                //将sql语句加入批处理
                ps.addBatch();
                //每10条处理一次
                if(i%10==0){
                    stat.executeBatch();
                    stat.clearBatch();
                }
                stat.executeBatch();//处理最后五条
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    /**
     * 操作结果集
     *基于缓存的分页策略
     *起始数据 (page-1)*pageSize+1
     * @param pageSize 每页有多少条数据
     * @param page 第几页
     */
    public void bufferPageDemo(int pageSize,int page){
        String sql="select*from courseinfo";
        try {
            //结果集滚动不敏感的(可跳步的)
            /**
             * ResultSet有个结果集指针，初始是指向第一个结果的
             * 
             * 1.ResultSet.TYPE_FORWARD_ONLY 指针只能安装列顺序向前移动，也就是说在取得name列之后，将不能再返回获取id列的值；
             * 2.ResultSet.TYPE_SCROLL_INSENSITIVE指针可以前后移动，INSENSITIVE表示不及时更新，就是如果数据库里的数据修改过，并不在ResultSet中反映出来；
             * 3.ResultSet.TYPE_SCROLL_SENSITIVE指针可以前后移动，SENSITIVE表示及时跟踪数据库的更新，以便更改ResultSet中的数据。
             * 
             * 
             * 1.ResultSet.CONCUR_READ_ONLY表示当前ResultSet对象只读， 不能用结果集更新数据库中的表
             * 2.ResultSet.CONCUR_UPDATABLE表示当前ResultSet能用结果集更新数据库中的表
             * 
             * ResultSet提供各种控制指针的方法
             */
            //conn.createStatement(resultSetType, resultSetConcurrency)
            stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs=stat.executeQuery(sql);
            rs.last();//移动到最后一行
            int rownum=rs.getRow();//记录当前的行号，记录的条数
            rs.absolute(1);//将指针移到第一行
            rs.relative(2);//相对当前位置移动2行
            /*更新第三条记录*/
            rs.updateInt(1, 100);
            rs.updateString(2, "更新地方");
            rs.updateRow();//更新数据源的数据
            /*插入数据*/
            rs.moveToInsertRow();//指针移到插入行
            rs.updateInt(1, 100);
            rs.updateString(2, "插入地方");
            rs.insertRow();
            rs.moveToCurrentRow();//指针移到插入前的位置
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 存储过程的调用
     * 
     * 
     */
    public void callStatement(){
        StringBuffer sb=new StringBuffer(20);//线程安全
        /*
         * sys_refcursor游标类型
          create or replace procedure testc(infos out sys_refcursor,num out number,names  out varchar2)
            is
            begin
            open infos for 'select*from userinfo';
            select count(*) into num from userinfo;
            select username into names from userinfo where userid=1;
            end testc;
         */
        sb.append("{call testc(?,?,?)}");
        try {
            cs=conn.prepareCall(sb.toString());
            //返回游标类型
            //cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            cs.registerOutParameter(1, 1);
            //返回num类型
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            //返回字符类型
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            rs=(ResultSet)cs.getObject(1);
            //获取结果集的列数
            int count=rs.getMetaData().getColumnCount();//获得结果集记录的字段数
            System.out.println("count="+count);
            while(rs.next()){
                for(int i=1;i<=count;i++){
                    System.out.println(rs.getString(i));
                }
            }
            System.out.println("------返回number类型-------");
            int counts=cs.getInt(2);
            System.out.println(counts);
            System.out.println("-----返回varchar-------");
            String name=cs.getString(3);
            System.out.println(name);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /*调用存储过程，返回游标，整数，字符串*/
        
        /*调用存储过程，返回整数*/
        /**/
        /**/
    }
	public class Course {
		private int id;
		private String username;
		private String password;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}
}