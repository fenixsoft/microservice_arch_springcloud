package com.github.fenixsoft.bookstore.domain.security;

/**
 * 访问范围常量类
 * <p>
 * 目前有“来自浏览器的访问”和“来自微服务的访问”两个常量
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/19 18:24
 **/
public interface Scope {

    String BROWSER = "BROWSER";

    String SERVICE = "SERVICE";

}
