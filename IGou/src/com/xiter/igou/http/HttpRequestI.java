/**
 * 
 */
package com.xiter.igou.http;

import org.apache.http.client.methods.HttpUriRequest;

/**
 * Description:请求接口
 * 
 * @author liufeihua
 * @date 2014-11-17下午3:03:40
 * @version 1.0
 * 
 */
public interface HttpRequestI {

	/**
	 * 获取Uri
	 * 
	 * @return
	 */
	public HttpUriRequest getHttpRequest();

	/**
	 * 获取请求路径
	 * 
	 * @return
	 */
	public String getRequestURL();

	/**
	 * 获取返回的response接口
	 * 
	 * @return
	 * @throws Exception
	 */
	public HttpResponseI request() throws Exception;
}
