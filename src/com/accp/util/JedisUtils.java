package com.accp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtils {
	
    private static final Logger logger = LoggerFactory.getLogger(JedisPool.class);

    private static JedisPool jedisPool;

    private static Jedis jedis;

    /**
     * 获取资源
     *
     * @return
     */
    public static Jedis getInstance() throws Exception {

        if (jedis == null) {
            synchronized (JedisUtils.class) {
                if (jedis == null) {
                    try {
                        jedis = jedisPool.getResource();
                        jedis.connect();
                        logger.debug("getResource:{}", jedis);
                    } catch (Exception e) {
                        logger.error("getResource:{}", e);
                        if (jedis != null)
                            jedis.close();
                        throw e;
                    }
                }
            }
        }
        return jedis;
    }

    /**
     * 用指定的key set数据用到redis缓存
     *
     * @param key
     * @param value
     */
    public static void putObject(String key, String value) {
        jedis.set(key, value);
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

}
