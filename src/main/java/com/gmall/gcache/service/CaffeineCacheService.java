package com.gmall.gcache.service;

import com.gmall.gcache.common.cache.spring.RedisCaffeineCacheManager;
import com.gmall.gcache.entity.UserVO;
import com.gmall.gcache.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *  测试
 */
@Service
public class CaffeineCacheService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CaffeineCacheService.class);

    @Resource
    private UserMapper userMapper;

    /**
     * 获取或加载缓存项
     */
    @Cacheable(value = "userCache", key = "'cache_user_id_' + #userId")
    public UserVO queryUser(String userId) {
        UserVO userVO = userMapper.findUserById(userId);
        sleep3();
        LOGGER.info("加载数据:{}", userVO);
        return userVO;
    }

    private void sleep3() {
        // 模拟加载数据的耗时
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取或加载缓存项
     * 注：因底层是基于caffeine来实现一级缓存，所以利用的caffeine本身的同步机制来实现
     * sync=true 则表示并发场景下同步加载缓存项，
     * sync=true，是通过get(Object key, Callable<T> valueLoader)来获取或加载缓存项，
     *    此时valueLoader（加载缓存项的具体逻辑）会被缓存起来，所以CaffeineCache在定时刷新过期缓存时，缓存项过期则会重新加载。
     * sync=false，是通过get(Object key)来获取缓存项，由于没有valueLoader（加载缓存项的具体逻辑），
     *    所以CaffeineCache在定时刷新过期缓存时，缓存项过期则会被淘汰。
     */
    @Cacheable(value = "userCache", key = "#userId", sync = true)
    public List<UserVO> queryUserSyncList(String userId) {
        UserVO userVO = userMapper.findUserById(userId);
        List<UserVO> list = new ArrayList();
        list.add(userVO);
        LOGGER.info("加载数据:{}", list);
        return list;
    }

    /**
     * 更新缓存
     */
    @CachePut(value = "userCache", key = "#userId")
    public UserVO updateUser(String userId, UserVO userVO) {
        return userVO;
    }

    /**
     * 淘汰缓存
     */
    @CacheEvict(value = "userCache", key = "#userId")
    public String evictUserSync(String userId) {
        return userId;
    }

}