package org.eop.spring.mvc.mybatis.annotation.groovy.restful.result

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractPostTest

/**
 * @author lixinjie
 * @since 2017-09-13
 */
class ListResultPost extends AbstractPostTest {

	@Override
	public String getRestUri() {
		return '/result/list'
	}

	@Override
	public Map<String, Object> getUriVars() {
		return [:]
	}

	@Override
	public Map<String, Object> getHttpHeaders() {
		return ['Content-Type':'application/xml;charset=UTF-8','Accept':'application/xml;charset=UTF-8']
	}

	@Override
	public <T> T getRequestBody() {
		'{"code":0,"desc":"success","data":[{"2017":"1000","2016":"1000"},{"2017":"1000","2016":"1000"},{"2017":"1000","2016":"1000"}]}'
		//复杂的xml格式入参，无法正确转换为javabean
		//'<result><code>0</code><desc>success</desc><data><2017>1000</2017><2016>1000</2016></data><data><2017>1000</2017><2016>1000</2016></data><data><2017>1000</2017><2016>1000</2016></data></result>'
	}

}
