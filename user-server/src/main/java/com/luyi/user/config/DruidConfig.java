package com.luyi.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: luyi
 * @Description: druid数据库链接池
 * @Date: Created in 2022-05-18
 */
@Configuration
public class DruidConfig {
    /*
        将自定义的Druid数据源添加到容器中，不再让springboot自动创建
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
}


