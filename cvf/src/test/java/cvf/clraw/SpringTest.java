package cvf.clraw;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import redis.clients.jedis.Jedis;

public class SpringTest {
	public static void main(String[] args) {
//		 ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:config/spring.xml");  
//		 DriverManagerDataSource sqlSessionFactory = (DriverManagerDataSource) classPathXmlApplicationContext.getBean("mysqlDataSource");  
//		 System.out.println(sqlSessionFactory);
		Jedis jedis = new Jedis("192.168.121.128", 6379);
		jedis.set("BOBO", "BOBO");
		System.out.println(jedis.get("BOBO"));
	}
	
	//监听器有属性监听器 上下文监听器  session监听器 对象请求初始化和销毁监听器
		private static Lock lock = new ReentrantLock();

		public static void test1() {
			lock.lock();
			// test1();
			System.out.println(Calendar.getInstance().getTimeInMillis());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			lock.unlock();
//			synchronized (DateDemo.class) {
//				
//			}
			String string = "北京市(朝阳区)(西城区)(海淀区)";
			Pattern pattern = Pattern.compile(".*?(?=\\()");
			Matcher matcher = pattern.matcher(string);
			if (matcher.find()) {
				System.out.println(matcher.group());
			}
			
		}

		private synchronized static void test2() {
			Calendar calendar = Calendar.getInstance();
			System.out.println(calendar.get(Calendar.YEAR));
			System.out.println(calendar.get(Calendar.MONTH));
			System.out.println(calendar.get(Calendar.DATE));
			System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
			System.out.println(calendar.get(Calendar.MINUTE));
			System.out.println(calendar.get(Calendar.SECOND));
			System.out.println(calendar.get(Calendar.HOUR));

		}
}
