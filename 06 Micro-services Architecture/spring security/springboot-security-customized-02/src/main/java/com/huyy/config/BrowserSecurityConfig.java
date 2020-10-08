package com.huyy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {        
        http.formLogin() // 表单登录
        .loginPage("/authentication/require")                //指定了跳转到登录页面的请求URL。
        .loginProcessingUrl("/login")                        //对应登录页面form表单的action="/login"。
        .and()
        .authorizeRequests() // 授权配置
        .antMatchers("/authentication/require","/login.html").permitAll()  //表示跳转到登录页面的请求不被拦截，否则会进入无限循环。
        .anyRequest()  // 所有请求
        .authenticated() // 都需要认证
        .and().csrf().disable();//新增。关闭CSRF攻击防御关，不然登录出错会进入未知页面。
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
