package org.eop.spring.mvc.mybatis.annotation.initializer;

import javax.servlet.Filter;

import org.eop.spring.mvc.mybatis.annotation.config.RootConfig;
import org.eop.spring.mvc.mybatis.annotation.filter.AccessLoggingFilter;
import org.eop.spring.mvc.mybatis.annotation.web.config.WebConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author lixinjie
 * @since 2017-10-04
 */
//tomcat会自动检测到该类，所以无需进行其他配置
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		DispatcherServlet dispatcherServlet = (DispatcherServlet)super.createDispatcherServlet(servletAppContext);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		return dispatcherServlet;
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		AccessLoggingFilter accessLoggingFilter = new AccessLoggingFilter();
		return new Filter[] {characterEncodingFilter, accessLoggingFilter};
	}

}
