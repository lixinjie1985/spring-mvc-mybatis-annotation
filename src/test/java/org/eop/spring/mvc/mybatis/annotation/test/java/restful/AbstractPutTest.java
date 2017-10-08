package org.eop.spring.mvc.mybatis.annotation.test.java.restful;

import org.springframework.http.HttpMethod;

/**
 * @author lixinjie
 * @since 2017-08-26
 */
public abstract class AbstractPutTest extends AbstractRestfulTest {

	@Override
	public String getBaseUri() {
		return "http://localhost:8080/spring-mvc-mybatis-annotation";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.PUT;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<String> getResponseType() {
		return String.class;
	}

}
