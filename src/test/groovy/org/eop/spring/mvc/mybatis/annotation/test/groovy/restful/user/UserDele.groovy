package org.eop.spring.mvc.mybatis.annotation.test.groovy.restful.user

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractDeleteTest

class UserDele extends AbstractDeleteTest {

	@Override
	String getRestUri() {
		'/user/delete/{id}'
	}

	@Override
	Map<String, Object> getUriVars() {
		[id:2]
	}

	@Override
	Map<String, Object> getHttpHeaders() {
		['Content-Type':'application/json;charset=UTF-8','Accept':'application/json']
	}

	@Override
	<T> T getRequestBody() {
		null
	}

}
