//package com.desktech.gestiondestock.config;
//
//import com.desktech.gestiondestock.interceptor.CustomInterceptor;
//import com.desktech.gestiondestock.interceptor.Interceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class InterceptorConfig implements WebMvcConfigurer {
//
//    CustomInterceptor interceptor;
//
//    @Autowired
//    public InterceptorConfig(CustomInterceptor interceptor) {
//        this.interceptor = interceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(interceptor);
//    }
//}
