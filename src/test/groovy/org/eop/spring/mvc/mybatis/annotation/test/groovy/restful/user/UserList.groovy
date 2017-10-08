package org.eop.spring.mvc.mybatis.annotation.test.groovy.restful.user

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractGetTest

class UserList extends AbstractGetTest {

	@Override
	String getRestUri() {
		'/user/list'
	}

	@Override
	Map<String, Object> getUriVars() {
		[:]
	}

	@Override
	Map<String, Object> getHttpHeaders() {
		['Content-Type':'application/json','Accept':'application/json']
	}

	@Override
	<T> T getRequestBody() {
		null
	}

}
