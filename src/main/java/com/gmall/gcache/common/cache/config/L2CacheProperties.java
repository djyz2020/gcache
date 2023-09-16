package com.gmall.gcache.common.cache.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *  一二级缓存属性配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "l2cache")
public class L2CacheProperties {
    /**
     * 缓存配置
     */
    private L2CacheConfig config;

    @Bean
    public L2CacheConfig l2CacheConfig() {
        return config;
    }
}
