package org.xy.medicare.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.xy.medicare.common.security.intercept.AuthInterceptor;

/**
 * @description:
 * @author: XY-GYL
 * @time: 2022/5/5 10:48
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private AuthInterceptor authInter;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authInter).addPathPatterns("/api/**");
    }
}
