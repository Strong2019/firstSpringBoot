package com.kingland.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * WebSecurityConfig安全配置
 *
 * @author Rooney
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 用户信息Service
     */
    private final UserDetailsService userService;

    /**
     * 通过构造方法注入
     *
     * @param userService 用户Service
     */
    public WebSecurityConfig(UserDetailsService userService) {
        this.userService = userService;
    }

    /**
     * 重写配置，过滤静态资源
     *
     * @param webSecurity web安全
     * @throws Exception 异常
     */
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        // 允许访问 /css 目录下的所有文件
        webSecurity.ignoring().antMatchers("/favicon.ico", "/resources/**", "/error")
                .antMatchers("/public/css/**")
                .antMatchers("/public/**");
    }

    /**
     * 安全策略配置
     *
     * @param httpSecurity http安全
     * @throws Exception 异常
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                // 对于网站部分资源需要指定鉴权
                .antMatchers("/regist").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated().and()
                // 定义当需要用户登录时候，转到的登录页面 .loginPage("/login")
                .formLogin().loginPage("/login").defaultSuccessUrl("/index").permitAll().and()
                // 定义登出操作
                .logout().logoutSuccessUrl("/login").permitAll().and()
                // 禁用csrf，否则可能会导致一些错误
                .csrf().disable()
        ;
        // 禁用缓存
        httpSecurity.headers().cacheControl();
    }



    /**
     * 配置安全认证
     *
     * @param auth 认证
     * @throws Exception 异常
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用数据库 用户信息服务 密码认证 使用BCrypt加密
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}