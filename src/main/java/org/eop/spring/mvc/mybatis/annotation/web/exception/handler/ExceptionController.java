package org.eop.spring.mvc.mybatis.annotation.web.exception.handler;

import org.eop.spring.mvc.mybatis.annotation.web.result.RestResult;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 采用此种方式来统一处理异常，根据异常类型进入相应的方法
 * 将异常转换为适合的内容，发送会客户端，将原来异常的响应
 * 状态码放到内容里发送，重新修改响应状态码为200,OK
 * @author lixinjie
 * @since 2017-09-11
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@RestController
public class ExceptionController {

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public RestResult<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
		//return "{\"code\":405,\"desc\":\"Method Not Allowed\"}";
		return new RestResult<Object>(405, "Method Not Allowed");
	}
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public RestResult<Object> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
		//return "{\"code\":415,\"desc\":\"Unsupported Media Type\"}";
		return new RestResult<Object>(415, "Unsupported Media Type");
	}
	
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public RestResult<Object> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
		//return "{\"code\":406,\"desc\":\"Not Acceptable\"}";
		return new RestResult<Object>(406, "Not Acceptable");
	}
	
	@ExceptionHandler(MissingPathVariableException.class)
	public RestResult<Object> handleMissingPathVariableException(MissingPathVariableException ex) {
		//return "{\"code\":500,\"desc\":\"Internal Server Error\"}";
		return new RestResult<Object>(500, "Internal Server Error");
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public RestResult<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
		//return "{\"code\":400,\"desc\":\"Bad Request\"}";
		return new RestResult<Object>(400, "Bad Request");
	}
	
	@ExceptionHandler(ServletRequestBindingException.class)
	public RestResult<Object> handleServletRequestBindingException(ServletRequestBindingException ex) {
		//return "{\"code\":400,\"desc\":\"Bad Request\"}";
		return new RestResult<Object>(400, "Bad Request");
	}
	
	@ExceptionHandler(ConversionNotSupportedException.class)
	public RestResult<Object> handleConversionNotSupportedException(ConversionNotSupportedException ex) {
		//return "{\"code\":500,\"desc\":\"Internal Server Error\"}";
		return new RestResult<Object>(500, "Internal Server Error");
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public RestResult<Object> handleTypeMismatchException(TypeMismatchException ex) {
		//return "{\"code\":400,\"desc\":\"Bad Request\"}";
		return new RestResult<Object>(400, "Bad Request");
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public RestResult<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		//return "{\"code\":400,\"desc\":\"Bad Request\"}";
		return new RestResult<Object>(400, "Bad Request");
	}
	
	@ExceptionHandler(HttpMessageNotWritableException.class)
	public RestResult<Object> handleHttpMessageNotWritableException(HttpMessageNotWritableException ex) {
		//return "{\"code\":500,\"desc\":\"Internal Server Error\"}";
		return new RestResult<Object>(500, "Internal Server Error");
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public RestResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		//return "{\"code\":400,\"desc\":\"Bad Request\"}";
		return new RestResult<Object>(400, "Bad Request");
	}
	
	@ExceptionHandler(MissingServletRequestPartException.class)
	public RestResult<Object> handleMissingServletRequestPartException(MissingServletRequestPartException ex) {
		//return "{\"code\":400,\"desc\":\"Bad Request\"}";
		return new RestResult<Object>(400, "Bad Request");
	}
	
	@ExceptionHandler(BindException.class)
	public RestResult<Object> handleBindException(BindException ex) {
		//return "{\"code\":400,\"desc\":\"Bad Request\"}";
		return new RestResult<Object>(400, "Bad Request");
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public RestResult<Object> handleNoHandlerFoundException(NoHandlerFoundException ex) {
		//return "{\"code\":404,\"desc\":\"Not Found\"}";
		return new RestResult<Object>(404, "Not Found");
	}
	
	@ExceptionHandler(AsyncRequestTimeoutException.class)
	public RestResult<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex) {
		//return "{\"code\":503,\"desc\":\"Service Unavailable\"}";
		return new RestResult<Object>(503, "Service Unavailable");
	}
	
	@ExceptionHandler(Exception.class)
	public RestResult<Object> handleException(Exception ex) {
		//return "{\"code\":500,\"desc\":\"Internal Server Error\"}";
		return new RestResult<Object>(500, "Internal Server Error");
	}
	
	@ExceptionHandler(Throwable.class)
	public RestResult<Object> handleThrowable(Throwable ex) {
		//return "{\"code\":500,\"desc\":\"Internal Server Error\"}";
		return new RestResult<Object>(500, "Internal Server Error");
	}
}
