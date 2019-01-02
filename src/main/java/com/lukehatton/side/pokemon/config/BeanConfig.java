package com.lukehatton.side.pokemon.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;

/**
 * ClassName: BeanConfig
 * Description:Bean配置
 * Author: Zhao Li
 * Date: 2018/12/21 16:05
 * History:
 */
@SpringBootConfiguration
public class BeanConfig {

    //将responseBody字符集都设置为utf-8
    @Bean("charsetMessageConverter")
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
}
