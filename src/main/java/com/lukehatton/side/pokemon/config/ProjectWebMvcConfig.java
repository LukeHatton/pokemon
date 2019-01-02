package com.lukehatton.side.pokemon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: ProjectWebMvcConfig
 * Description: MVC配置
 * Author: Zhao Li
 * Date: 2018/12/24 14:30
 * History:
 */
@SpringBootConfiguration
public class ProjectWebMvcConfig implements WebMvcConfigurer {

    private final RequestBodyArgumentResolver argumentResolver;

    @Resource(name = "charsetMessageConverter")
    private HttpMessageConverter<String> httpMessageConverter;

    @Autowired
    public ProjectWebMvcConfig(RequestBodyArgumentResolver argumentResolver) {
        this.argumentResolver = argumentResolver;
    }

    /**
     * 自定义参数解析器
     *
     * @param argumentResolvers argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(argumentResolver);
    }

    /**
     * 自定义消息转换器
     *
     * @param converters converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(httpMessageConverter);
    }
}
