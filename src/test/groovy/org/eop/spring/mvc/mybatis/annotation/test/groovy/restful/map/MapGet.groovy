package org.eop.spring.mvc.mybatis.annotation.test.groovy.restful.map

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractGetTest

class MapGet extends AbstractGetTest {

	@Override
	String getRestUri() {
		'/map/get'
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
