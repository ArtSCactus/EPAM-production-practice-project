package com.epam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author ArtSCactus
 * @version 1.0
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private static final String COOKIE_NAME="News-manager-language";
    private static final String URI_PARAM_NAME="lang";
    @Bean
    public LocaleResolver localeResolver(){
        CookieLocaleResolver cookie = new CookieLocaleResolver();
        cookie.setCookieName(COOKIE_NAME);
        return cookie;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName(URI_PARAM_NAME);
        return interceptor;
    }
}
