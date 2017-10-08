package org.eop.spring.mvc.mybatis.annotation.test.groovy.restful.user

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractGetTest

class UserGet extends AbstractGetTest {

	@Override
	String getRestUri() {
		'/user/get'
	}

	@Override
	Map<String, Object> getUriVars() {
		[:]
	}

	@Override
	Map<String, Object> getHttpHeaders() {
		['Content-Type':'application/json','Accept':'application/xml']
	}

	@Override
	<T> T getRequestBody() {
		null
	}

}
