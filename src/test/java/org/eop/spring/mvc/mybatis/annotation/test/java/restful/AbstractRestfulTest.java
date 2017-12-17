package org.eop.spring.mvc.mybatis.annotation.test.java.restful;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

import org.eop.spring.mvc.mybatis.annotation.test.java.AbstractJavaTest;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author lixinjie
 * @since 2017-08-26
 */
public abstract class AbstractRestfulTest extends AbstractJavaTest {

	public abstract String getBaseUri();
	
	public abstract String getRestUri();
	
	public abstract Map<String, Object> getUriVars();
	
	public abstract Map<String, Object> getHttpHeaders();
	
	public abstract HttpMethod getHttpMethod();
	
	public abstract <T> T getRequestBody();
	
	public abstract <T> Class<T> getResponseType();
	
	@Test
	public void execute() {
		RestTemplate restTplt = new RestTemplate(new HttpComponentsClientHttpRequestFactory()) {
			@Override
			protected void handleResponse(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
				
			}
		};
		HttpHeaders headers = new HttpHeaders();
		getHttpHeaders().forEach((name, value) -> {
			headers.add(name, value.toString());
		});
		HttpEntity<?> requestEntity = new HttpEntity<Object>(getRequestBody(), headers);
		ResponseEntity<?> responseEntity = restTplt.exchange(getBaseUri() + getRestUri(), getHttpMethod(), requestEntity, getResponseType(), getUriVars());
		System.out.print(responseEntity.getStatusCode().value() + " " + responseEntity.getStatusCode().getReasonPhrase() + " ");
		System.out.println(responseEntity.getHeaders().getFirst("Content-Disposition") + " " + responseEntity.getHeaders().getFirst("Content-Type"));
		System.out.println(responseEntity.getBody());
	}
}
