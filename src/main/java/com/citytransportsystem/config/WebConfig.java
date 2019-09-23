package com.citytransportsystem.config;

import com.citytransportsystem.Interseptor.RoleInterceptor;
import com.citytransportsystem.Interseptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableScheduling
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public RoleInterceptor roleInterceptor() {
        return new RoleInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login",
                        "/logout", "/css/**", "/js/**", "/checkloginexist");
        registry.addInterceptor(roleInterceptor()).addPathPatterns("/registration", "/home/add");
    }
}
