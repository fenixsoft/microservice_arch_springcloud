package com.github.fenixsoft.bookstore.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * SprintCloud Security 认证、授权服务
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/18 11:17
 **/
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.github.fenixsoft.bookstore"})
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
