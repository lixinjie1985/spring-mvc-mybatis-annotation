package org.eop.spring.mvc.mybatis.annotation.web.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author lixinjie
 * @since 2017-08-26
 */
@JsonRootName("result")
public class RestResult<T> {

	private int code;
	private String desc;
	@JsonInclude(Include.NON_NULL)
	private T data;
	
	public RestResult() {
		
	}
	
	public RestResult(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public RestResult(int code, String desc, T data) {
		this.code = code;
		this.desc = desc;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
