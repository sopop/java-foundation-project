package com.example.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: SpringBoot
 * @description: 配置授权拦截器
 * @author: demo
 * @create: 2022-4-19 20:24
 **/

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {
    //配置默认访问页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //首页的路径
        registry.addViewController("/").setViewName("/home/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}
