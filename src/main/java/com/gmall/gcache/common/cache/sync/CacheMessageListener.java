package com.gmall.gcache.common.cache.sync;


import com.gmall.gcache.common.cache.spring.RedisCaffeineCacheManager;
import com.gmall.gcache.common.cache.util.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 *  缓存消息监听器
 */
@Component
public class CacheMessageListener implements MessageListener {

    private final Logger logger = LoggerFactory.getLogger(CacheMessageListener.class);

    private RedisCache redisService;

    private RedisCaffeineCacheManager redisCaffeineCacheManager;

    public CacheMessageListener(RedisCache redisService,
                                RedisCaffeineCacheManager redisCaffeineCacheManager) {
        super();
        this.redisService = redisService;
        this.redisCaffeineCacheManager = redisCaffeineCacheManager;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        CacheMessage cacheMessage = (CacheMessage) redisService.getRedisTemplate().getValueSerializer().deserialize(message.getBody());
        logger.info("receive a redis topic message, clear local cache, the cacheName is {}, the key is {}", cacheMessage.getCacheName(), cacheMessage.getKey());
        redisCaffeineCacheManager.clearLocal(cacheMessage.getCacheName(), cacheMessage.getKey());
    }
}
