package org.eop.spring.mvc.mybatis.annotation.test.groovy.restful.user

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractPutTest

class UserPut extends AbstractPutTest {

	@Override
	String getRestUri() {
		'/user/put'
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
		["id":1010,"userName":"李新杰","password":"000000","registerTime":"2017-09-11 18:06:58"]
	}

}
