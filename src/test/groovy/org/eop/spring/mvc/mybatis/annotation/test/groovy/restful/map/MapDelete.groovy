package org.eop.spring.mvc.mybatis.annotation.test.groovy.restful.map

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractDeleteTest

class MapDelete extends AbstractDeleteTest {

	@Override
	String getRestUri() {
		'/map/delete'
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
		'{"method":"delete"}'
	}

}
