package org.eop.spring.mvc.mybatis.annotation.groovy.restful.result

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractGetTest

/**
 * @author lixinjie
 * @since 2017-09-13
 */
class MapResultGet extends AbstractGetTest {

	@Override
	public String getRestUri() {
		return '/result/map'
	}

	@Override
	public Map<String, Object> getUriVars() {
		return [:]
	}

	@Override
	public Map<String, Object> getHttpHeaders() {
		return ['Content-Type':'application/json;charset=UTF-8','Accept':'application/xml;charset=UTF-8']
	}

	@Override
	public <T> T getRequestBody() {
		return null
	}

}
