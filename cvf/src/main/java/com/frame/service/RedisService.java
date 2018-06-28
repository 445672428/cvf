package com.frame.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.entities.Function;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Service
public class RedisService {

    @Autowired(required = false)//如果Spring容器中有，就注入，没有就忽略
    private ShardedJedisPool shardedJedisPool;

    private <T> T execute(Function<T, ShardedJedis> fun) {
        ShardedJedis shardedJedis = null;
        try {
            // 从连接池中获取到jedis分片对象
            shardedJedis = shardedJedisPool.getResource();
            return fun.callback(shardedJedis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != shardedJedis) {
                // 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
                shardedJedis.close();
            }
        }
        return null;
    }

    /**
     * 执行SET操作
     * 
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value) {
        return this.execute(new Function<String, ShardedJedis>() {
            public String callback(ShardedJedis e) {
                return e.set(key, value);
            }
        });
    }

    /**
     * 执行GET操作
     * 
     * @param key
     * @return
     */
    public String get(final String key) {
        return this.execute(new Function<String, ShardedJedis>() {
            public String callback(ShardedJedis e) {
                return e.get(key);
            }
        });
    }

    /**
     * 删除key
     * 
     * @param key
     * @return
     */
    public Long del(final String key) {
        return this.execute(new Function<Long, ShardedJedis>() {
            public Long callback(ShardedJedis e) {
                return e.del(key);
            }
        });
    }

    /**
     * 设置生存时间，单位为：秒
     * 
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(final String key, final Integer seconds) {
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.expire(key, seconds);
            }
        });
    }

    /**
     * 设置String类型的值，并且指定生存时间，单位为：秒
     * 
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public String set(final String key, final String value, final Integer seconds) {
        return this.execute(new Function<String, ShardedJedis>() {
            public String callback(ShardedJedis e) {
                String result = e.set(key, value);
                // 设置生存时间
                e.expire(key, seconds);
                return result;
            }
        });
    }
    
    
    // 由于在Spring ApplicationContext.xml 配置文件中导入了 redis的配置文件，也就间接的将 <bean id="clusterRedisTemplate"                                                                  class="org.springframework.data.redis.core.RedisTemplate">  这个Bean托管给了Spring bean容器来管理所以 只要我使用注解就可以把这个模板类对象引用过来。

    //@Autowired
    private RedisTemplate<String,String> clusterRedisTemplate;
  
    //添加数据
     public void put(Object key, Object value) {
         if(null == value) {
             return;
         }
  
         if(value instanceof String) {
             if(StringUtils.isEmpty(value.toString())) {
                 return;
             }
         }
  
         // TODO Auto-generated method stub
         final String keyf = key + "";
         final Object valuef = value;
         final long liveTime = 86400;
  
         clusterRedisTemplate.execute(new RedisCallback<Long>() {
             public Long doInRedis(RedisConnection connection)
                     throws DataAccessException {
                 byte[] keyb = keyf.getBytes();
                 byte[] valueb = toByteArray(valuef);
                 connection.set(keyb, valueb);
                 if (liveTime > 0) {
                     connection.expire(keyb, liveTime);
                 }
                 return 1L;
             }
         });
     }
  

      // 获取数据

     public Object get(Object key) {
         final String keyf = (String) key;
         Object object;
         object = clusterRedisTemplate.execute(new RedisCallback<Object>() {
             public Object doInRedis(RedisConnection connection)
                     throws DataAccessException {
  
                 byte[] key = keyf.getBytes();
                 byte[] value = connection.get(key);
                 if (value == null) {
                     return null;
                 }
                 return toObject(value);
  
             }
         });
  
         return object;
     }
  
     /**
      * 描述 : <byte[]转Object>. <br>
      * <p>
      * <使用方法说明>
      * </p>
      *
      * @param bytes
      * @return
      */
     private Object toObject(byte[] bytes) {
         Object obj = null;
         try {
             ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bis);
             obj = ois.readObject();
             ois.close();
             bis.close();
         } catch (IOException ex) {
             ex.printStackTrace();
         } catch (ClassNotFoundException ex) {
             ex.printStackTrace();
         }
         return obj;
     }
  
     private byte[] toByteArray(Object obj) {
         byte[] bytes = null;
         ByteArrayOutputStream bos = new ByteArrayOutputStream();
         try {
             ObjectOutputStream oos = new ObjectOutputStream(bos);
             oos.writeObject(obj);
             oos.flush();
             bytes = bos.toByteArray();
             oos.close();
             bos.close();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
         return bytes;
     }
}
