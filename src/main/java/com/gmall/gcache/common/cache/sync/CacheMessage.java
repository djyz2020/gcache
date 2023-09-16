package com.gmall.gcache.common.cache.sync;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  缓存更新消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheMessage implements Serializable {
    private static final long serialVersionUID = 5987219310442078193L;

    /** 缓存名称 */
    private String cacheName;
    /** 缓存key */
    private Object key;

}