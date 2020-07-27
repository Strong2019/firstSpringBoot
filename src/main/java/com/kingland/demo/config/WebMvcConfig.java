package com.kingland.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 访问路径配置类
 * 可以理解成做简单访问过滤的，转发到相应的视图页面
 * @author Rooney
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 视图配置
     *
     * @param registry 登记
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 登录页面
        registry.addViewController("/login").setViewName("login");
        // 主页
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/hello").setViewName("index");
        registry.addViewController("/admin").setViewName("index");
    }
}