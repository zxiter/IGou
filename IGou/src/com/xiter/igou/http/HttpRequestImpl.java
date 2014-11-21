/**
 * 
 */
package com.xiter.igou.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;

/**
 * Description:HttpRequestI实现
 * 
 * @author liufeihua
 * @date 2014-11-17下午3:03:58
 * @version 1.0
 * 
 */
public class HttpRequestImpl implements HttpRequestI,
		ResponseHandler<HttpResponseI> {

	protected HttpUriRequest httpUriRequest;
	private AbstractHttpClient httpClient;

	public HttpRequestImpl(AbstractHttpClient httpClient) {
		super();
		this.httpClient = httpClient;
	}

	@Override
	public HttpUriRequest getHttpRequest() {

		return httpUriRequest;
	}

	@Override
	public String getRequestURL() {

		return httpUriRequest.getURI().toString();
	}

	@Override
	public HttpResponseI request() throws Exception {

		return httpClient.execute(httpUriRequest, this);
	}

	/**
	 * 响应返回的response
	 */
	@Override
	public HttpResponseI handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		HttpResponseI hResponseI = new HttpResponseImpl(response);
		return hResponseI;
	}

}
