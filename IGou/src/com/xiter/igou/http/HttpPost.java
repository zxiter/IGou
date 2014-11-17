/**
 * 
 */
package com.xiter.igou.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.impl.client.AbstractHttpClient;

/**
 * Description:post请求
 * 
 * @author liufeihua
 * @date 2014-11-17下午3:46:32
 * @version 1.0
 * 
 */
public class HttpPost extends HttpRequestImpl {

	public HttpPost(AbstractHttpClient httpClient, String url) {
		this(httpClient, url, null);
	}

	public HttpPost(AbstractHttpClient httpClient, String url, HttpEntity entity) {
		super(httpClient);
		this.httpUriRequest = new org.apache.http.client.methods.HttpPost(url);
		if (null != entity) {
			((HttpEntityEnclosingRequestBase) httpUriRequest).setEntity(entity);
		}
	}
}
