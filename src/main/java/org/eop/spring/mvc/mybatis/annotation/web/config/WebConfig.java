package org.eop.spring.mvc.mybatis.annotation.web.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lixinjie
 * @since 2017-10-04
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.eop.spring.mvc.mybatis.annotation.web.controller", "org.eop.spring.mvc.mybatis.annotation.web.exception.handler"})
public class WebConfig implements WebMvcConfigurer {

	//可以对已经注册的进行修改
	//org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
	//org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		WebMvcConfigurer.super.extendMessageConverters(converters);
		Optional<HttpMessageConverter<?>> jackson2 = converters.stream().filter(cvt -> cvt instanceof MappingJackson2HttpMessageConverter).findFirst();
		if (jackson2.isPresent()) {
			((MappingJackson2HttpMessageConverter)jackson2.get()).getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		}
		Optional<HttpMessageConverter<?>> jackson2xml = converters.stream().filter(cvt -> cvt instanceof MappingJackson2XmlHttpMessageConverter).findFirst();
		if (jackson2.isPresent()) {
			((MappingJackson2XmlHttpMessageConverter)jackson2xml.get()).getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		}
	}
	
	//如果参数类型是MultipartFile，必须使用该解析器
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
	
	//如果参数类型是Part，必须使用该解析器
	@Bean
	public StandardServletMultipartResolver multipartResolver0() {
		return new StandardServletMultipartResolver();
	}
}
