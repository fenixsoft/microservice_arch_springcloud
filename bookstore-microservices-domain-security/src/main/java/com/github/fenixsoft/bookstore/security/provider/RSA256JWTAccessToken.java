package com.github.fenixsoft.bookstore.security.provider;

import com.github.fenixsoft.bookstore.infrastructure.security.JWTAccessToken;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.util.JsonParser;
import org.springframework.security.oauth2.common.util.JsonParserFactory;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;
import org.springframework.util.ReflectionUtils;

import javax.inject.Named;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

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

    private final JsonParser objectMapper = JsonParserFactory.create();

    RSA256JWTAccessToken(UserDetailsService userDetailsService) {
        super(userDetailsService);
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("rsa.jks"), "123456".toCharArray());
        setKeyPair(keyStoreKeyFactory.getKeyPair("fenix-bookstore-rsa"));
    }

    /**
     * 增强令牌Header
     * 使用JWKS验证令牌时，Header中需要有kid（Key ID），设置Header的方法在Spring的默认实现中没有开放出来，这里添加个默认处理
     */
    @Override
    protected String encode(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Field signerField = ReflectionUtils.findField(this.getClass(), "signer");
        signerField.setAccessible(true);
        Signer signer = (Signer) ReflectionUtils.getField(signerField, this);

        String content;
        try {
            content = this.objectMapper.formatMap(getAccessTokenConverter().convertAccessToken(accessToken, authentication));
        } catch (Exception ex) {
            throw new IllegalStateException("Cannot convert access token to JSON", ex);
        }

        Map<String, String> headers = Collections.singletonMap("kid", "bookstore-jwt-kid");
        return JwtHelper.encode(content, signer, headers).getEncoded();
    }
}
