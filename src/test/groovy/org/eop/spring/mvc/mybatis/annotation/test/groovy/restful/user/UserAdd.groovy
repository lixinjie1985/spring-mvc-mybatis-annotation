package org.eop.spring.mvc.mybatis.annotation.test.groovy.restful.user

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractPostTest

class UserAdd extends AbstractPostTest {

	@Override
	String getRestUri() {
		'/user/add'
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
		'{"userName":"李新杰","password":"000000","email":"lixinjie@126.com"}'
	}

}
