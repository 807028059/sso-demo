package com.chingchou.config;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.HashMap;

/**
 * @Author: zhoujing
 * @Date: 2021/3/3 10:39
 * @Description:
 * @Version: 1.0
 */
@Configuration
public class CASAutoConfig {

    @Value("${cas.server-login-url}")
    private String serverLoginUrl;

    @Value("${cas.client-host-url}")
    private String clientHostUrl;

    @Bean
    public FilterRegistrationBean filterAuthenticationRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // AuthenticationFilter  该过滤器负责用户的认证工作
        registration.setFilter(new AuthenticationFilter());
        // 设定匹配的路径
        registration.addUrlPatterns("/*");
        Map<String,String> initParameters = new HashMap<String, String>();
        initParameters.put("casServerLoginUrl", serverLoginUrl);
        initParameters.put("serverName", clientHostUrl);
        registration.setInitParameters(initParameters);
        // 设定加载的顺序
        registration.setOrder(1);
        return registration;
    }

}
