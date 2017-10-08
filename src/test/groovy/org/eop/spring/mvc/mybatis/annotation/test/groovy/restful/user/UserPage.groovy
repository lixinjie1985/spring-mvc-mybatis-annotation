package org.eop.spring.mvc.mybatis.annotation.test.groovy.restful.user

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractGetTest

class UserPage extends AbstractGetTest {

	@Override
	String getRestUri() {
		'/user/page/{pageNum}/{pageSize}'
	}

	@Override
	Map<String, Object> getUriVars() {
		[pageNum:1, pageSize:2]
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
