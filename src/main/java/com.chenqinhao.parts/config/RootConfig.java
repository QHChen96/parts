package com.chenqinhao.parts.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 2017/1/5.
 */
@Configuration
//不扫描EnableWebMvc注解的类配置的bean
@ComponentScan(basePackages = {"com.chenqinhao.parts"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
}
