package com.chingchou.sso.config;

import net.unicon.cas.client.configuration.CasClientConfigurerAdapter;
import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhoujing
 * @Date: 2021/3/3 12:14
 * @Description:
 * @Version: 1.0
 */
@EnableCasClient
@Configuration
public class CasUrlConfig extends CasClientConfigurerAdapter {

    @Override
    public void configureAuthenticationFilter(FilterRegistrationBean authenticationFilter) {
        super.configureAuthenticationFilter(authenticationFilter);
        //配置地址，这里还可以配置很多，例如cas重定向策略等。
        authenticationFilter.getInitParameters().put("ignorePattern", "/logoutSuccess");
    }
}
