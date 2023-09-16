package com.gmall.gcache.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({ "com.gmall.**.mapper" })
public class MybatisConfig {

}
