package org.eop.spring.mvc.mybatis.annotation.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lixinjie
 * @since 2017-09-12
 */
public class AccessLoggingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		String method = httpRequest.getMethod();
		String contentType = httpRequest.getContentType();
		System.out.println(method + " " + httpRequest.getRequestURL() + " " + contentType);
		if (!isFileUpload(method, contentType)) {
			RepeatableHttpServletRequest repeatableRequest = new RepeatableHttpServletRequest(httpRequest);
			System.out.println(repeatableRequest.getBody());
			httpRequest = repeatableRequest;
		}
		RepeatableHttpServletResponse repeatableResponse = new RepeatableHttpServletResponse((HttpServletResponse)response);
		chain.doFilter(httpRequest, repeatableResponse);
		String contentDisposition = repeatableResponse.getHeader("Content-Disposition");
		contentType = repeatableResponse.getContentType();
		System.out.println(contentDisposition + " " + contentType);
		if (!isFileDownload(contentDisposition, contentType)) {
			System.out.println(repeatableResponse.getBody());
		}
	}

	@Override
	public void destroy() {
		
	}

	private boolean isFileUpload(String method, String contentType) {
		if (!"post".equalsIgnoreCase(method)) {
			return false;
		}
		return (contentType != null && contentType.toLowerCase().startsWith("multipart/"));
	}
	
	private boolean isFileDownload(String contentDisposition, String contentType) {
		return (contentDisposition != null && contentDisposition.toLowerCase().contains("attachment"));
	}
}
