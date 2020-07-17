package com.github.fenixsoft.bookstore.security.provider;

import com.github.fenixsoft.bookstore.infrastructure.security.JWTAccessToken;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import javax.inject.Named;

/**
 * 使用RSA SHA256私钥加密的JWT令牌
 * <p>
 * 在Infrastructure工程中提供了{@link com.github.fenixsoft.bookstore.infrastructure.security.RSA256PublicJWTAccessToken}作为公钥验证用途。
 * 为了便于对比，
 *
 * @author icyfenix@gmail.com
 * @date 2020/7/17 15:02
 **/
@Named
@Primary
public class RSA256JWTAccessToken extends JWTAccessToken {

    RSA256JWTAccessToken(UserDetailsService userDetailsService) {
        super(userDetailsService);
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("rsa.jks"), "123456".toCharArray());
        setKeyPair(keyStoreKeyFactory.getKeyPair("fenix-bookstore-rsa"));
    }
}
