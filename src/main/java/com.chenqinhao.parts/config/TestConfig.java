package com.chenqinhao.parts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/1/9.
 */
@Configuration
public class TestConfig {
    @Bean
    public String a(){
        return "aaa";
    }
}
