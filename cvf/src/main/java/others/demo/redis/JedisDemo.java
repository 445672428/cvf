package others.demo.redis;

import redis.clients.jedis.Jedis;

public class JedisDemo {

    public static void main(String[] args) {
        // 构造jedis对象
        Jedis jedis = new Jedis("47.106.87.178", 6379);
        // 向redis中添加数据
        jedis.set("mytest", "123");
        // 从redis中读取数据
        String value = jedis.get("mytest");

        // 关闭连接
        jedis.close();

    }

}
