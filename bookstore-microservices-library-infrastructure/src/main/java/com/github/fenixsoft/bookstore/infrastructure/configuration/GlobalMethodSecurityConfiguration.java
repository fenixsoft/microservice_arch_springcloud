package com.github.fenixsoft.bookstore.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 全局方法安全配置，在单元测试中不启用
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/21 14:34
 **/

@Profile("!test")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class GlobalMethodSecurityConfiguration {
}
