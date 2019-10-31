package com.github.webapp.backend.common.config;

import com.github.webapp.backend.common.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 使用springboo2.x 注意事项
 * 鉴于SpringBoot2.X 中 WebMvcConfigurerAdapter 已经过时
 * 可以继承 WebMvcConfigurationSupport 或实现WebMvcConfigurer
 * 在继承 WebMvcConfigurationSupport 时，除非在继承类中重写了一系列有关WebMVC的配置，
 * 否则可能就会遇到静态资源访问不到，返回数据不成功这些一系列问题了。
 *
 * @author wangweijiang
 * @since 2019-10-09 09:20
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public ResponseResultInterceptor responseResultInterceptor() {
        return new ResponseResultInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(responseResultInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public HttpMessageConverter<String> responseBodyStringConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        return converter;
    }

    /**
     * 修改StringHttpMessageConverter默认配置
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(responseBodyStringConverter());
    }
}
