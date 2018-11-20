package com.sit.swprocess.DogeCommerce.Config;

import com.sit.swprocess.DogeCommerce.Config.Interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class AppConfiguration implements WebMvcConfigurer {

    @Autowired
    AuthInterceptor authInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        String[] protectedPaths = {
                "/orders",
                "/orders/**/",
                "/orders/user/**",
                "/addresses",
                "/payments/order/**"
        };
        InterceptorRegistration authRegistry = registry.addInterceptor(authInterceptor);
        for (String path: protectedPaths) {
            authRegistry.addPathPatterns(path);
        }
    }
}
