package org.eop.spring.mvc.mybatis.annotation.web.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author lixinjie
 * @since 2017-10-04
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.eop.spring.mvc.mybatis.annotation.web.controller", "org.eop.spring.mvc.mybatis.annotation.web.exception.handler"})
public class WebConfig extends WebMvcConfigurerAdapter {

	//可以对已经注册的进行修改或添加额外的
	//不会影响默认converter的注册
	//org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
	//org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		Optional<HttpMessageConverter<?>> jackson2 = converters.stream().filter(cvt -> cvt instanceof MappingJackson2HttpMessageConverter).findFirst();
		if (jackson2.isPresent()) {
			((MappingJackson2HttpMessageConverter)jackson2.get()).getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		}
		Optional<HttpMessageConverter<?>> jackson2xml = converters.stream().filter(cvt -> cvt instanceof MappingJackson2XmlHttpMessageConverter).findFirst();
		if (jackson2.isPresent()) {
			((MappingJackson2XmlHttpMessageConverter)jackson2xml.get()).getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		}
	}
	
	//如果通过该方法添加了converter的话，那么默认的converter将不会被注册
	//如果想添加额外的converter或修改已添加的converter，请使用上面的那个方法
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		
	}
	
	//该bean其实不用手动配置，如果类路径中有和验证相关的jar包时
	//springmvc会自动进行配置，来启用验证功能
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource messageSource) {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		//如果不指定，则采用默认搜索机制
		validator.setProviderClass(HibernateValidator.class);
		//如果不指定，则采用spring容器中的messageSource bean
		validator.setValidationMessageSource(messageSource);
		return validator;
	}
	
	//提供国际化消息
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		Properties fileEncodings = new Properties();
		fileEncodings.setProperty("classpath:messages", "UTF-8");
		messageSource.setFileEncodings(fileEncodings);
		return messageSource;
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
