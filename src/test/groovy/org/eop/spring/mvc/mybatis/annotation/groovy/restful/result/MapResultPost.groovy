package org.eop.spring.mvc.mybatis.annotation.groovy.restful.result

import org.eop.spring.mvc.mybatis.annotation.test.java.restful.AbstractPostTest

/**
 * @author lixinjie
 * @since 2017-09-13
 */
class MapResultPost extends AbstractPostTest {

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
		'{"code":0,"desc":"success","data":{"scores":{"chinese":135,"math":140},"name":"李新杰","phones":["136","138"],"married":true,"age":32,"years":[{"2017":"1000","2016":"1000"},{"2017":"1000","2016":"1000"},{"2017":"1000","2016":"1000"}]}}'
		//复杂的xml格式的入参，无法被正确转换为javabean
		//'<result><code>0</code><desc>success</desc><data><scores><chinese>135</chinese><math>140</math></scores><name>李新杰</name><phones>136</phones><phones>138</phones><married>true</married><age>32</age><years><2017>1000</2017><2016>1000</2016></years><years><2017>1000</2017><2016>1000</2016></years><years><2017>1000</2017><2016>1000</2016></years></data></result>'
	}

}
