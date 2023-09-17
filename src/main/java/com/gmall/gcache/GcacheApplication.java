package com.gmall.gcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
@EnableMethodCache(basePackages = "com.gmall.gcache")
@EnableCreateCacheAnnotation
public class GcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcacheApplication.class, args);
	}

}
