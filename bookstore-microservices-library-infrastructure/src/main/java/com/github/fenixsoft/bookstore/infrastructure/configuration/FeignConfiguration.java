package com.github.fenixsoft.bookstore.infrastructure.configuration;

import feign.Contract;
import feign.RequestInterceptor;
import feign.jaxrs2.JAXRS2Contract;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import javax.inject.Inject;

/**
 * 启动FeignClient扫描，并配置：
 * 1. 并指定包包扫描地址
 * 2. 设置交互为JAX-RS2方式，实际Feign中的JAX-RS2指的是1.1
 * 3. 在请求时自动加入基于OAuth2的客户端模式认证的Header
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/18 22:38
 **/
@Configuration
@Profile("!test")
@EnableFeignClients(basePackages = {"com.github.fenixsoft.bookstore"})
public class FeignConfiguration {

    @Inject
    private ClientCredentialsResourceDetails resource;

    @Bean
    public Contract feignContract() {
        return new JAXRS2Contract();
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), resource);
    }

}
