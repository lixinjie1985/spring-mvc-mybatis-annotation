package org.eop.spring.mvc.mybatis.annotation.web.exception;

import org.springframework.validation.BindingResult;

public class BindingFailureException extends RuntimeException {

	private static final long serialVersionUID = 5841756071008403941L;

	private BindingResult bindingResult;
	
	public BindingFailureException(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
	
	public String getCode() {
		return null;
	}
	
	public String getDesc() {
		return bindingResult.getFieldError().getDefaultMessage();
	}
}
