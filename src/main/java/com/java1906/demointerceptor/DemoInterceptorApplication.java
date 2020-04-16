package com.java1906.demointerceptor;

import com.java1906.demointerceptor.interceptor.AuthenticationAndLoggingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoInterceptorApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(DemoInterceptorApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationAndLoggingInterceptor());
    }

}
