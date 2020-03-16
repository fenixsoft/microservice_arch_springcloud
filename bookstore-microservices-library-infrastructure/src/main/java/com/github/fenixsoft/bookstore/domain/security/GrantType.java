package com.github.fenixsoft.bookstore.domain.security;

/**
 * OAuth2 授权类型
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/19 19:36
 **/
public interface GrantType {

    // 四种标准类型
    String PASSWORD = "password";
    String CLIENT_CREDENTIALS = "client_credentials";
    String IMPLICIT = "implicit";
    String AUTHORIZATIONCODE = "authorizationcode";
    // 用于刷新令牌
    String REFRESH_TOKEN = "refresh_token";

}
