package org.eop.spring.mvc.mybatis.annotation.test.groovy.restful.user

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractPutTest

class UserEdit extends AbstractPutTest {

	@Override
	String getRestUri() {
		'/user/edit'
	}

	@Override
	Map<String, Object> getUriVars() {
		[:]
	}

	@Override
	Map<String, Object> getHttpHeaders() {
		['Content-Type':'application/json;charset=UTF-8','Accept':'application/json']
	}

	@Override
	<T> T getRequestBody() {
		["id":2,"userName":"李新杰2"]
	}

}
