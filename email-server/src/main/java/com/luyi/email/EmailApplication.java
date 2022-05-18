package com.luyi.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: luyi
 * @Description: 邮件服务
 * @Date: Created in 2022-05-18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }

}
