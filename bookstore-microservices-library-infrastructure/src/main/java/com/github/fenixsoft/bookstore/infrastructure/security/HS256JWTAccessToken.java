package com.github.fenixsoft.bookstore.infrastructure.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import javax.inject.Named;

/**
 * 基于HMAC-SHA256的JWT令牌实现
 * <p>
 * 并不推荐在微服务环境中使用这种必须中心化验证的令牌，所以这里的@Named是被注释的。
 * 保留该实现主要是为了与单体版本中的HS265实现保持一致，便于与RSA256/ECDSA256等实现进行对比。
 *
 * @author icyfenix@gmail.com
 * @date 2020/7/17 17:34
 **/
// @Named
public class HS256JWTAccessToken extends JWTAccessToken {

    // 签名私钥
    // 此处内容是我随便写的UUID，按照JWT约定默认是256Bit的，其实任何格式都可以，只是要注意保密，不要公开出去
    private static final String JWT_TOKEN_SIGNING_PRIVATE_KEY = "601304E0-8AD4-40B0-BD51-0B432DC47461";

    public HS256JWTAccessToken(UserDetailsService userDetailsService) {
        super(userDetailsService);
        // 设置签名私钥
        setSigningKey(JWT_TOKEN_SIGNING_PRIVATE_KEY);
    }

}
