package com.java1906.climan;

import com.java1906.climan.interceptor.AuthenticationAndLoggingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ClinicManagementApp implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ClinicManagementApp.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationAndLoggingInterceptor());
    }

}
