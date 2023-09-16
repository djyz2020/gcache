package com.gmall.gcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcacheApplication.class, args);
	}

}
