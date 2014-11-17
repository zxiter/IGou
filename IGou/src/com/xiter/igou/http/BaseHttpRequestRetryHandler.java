/**
 * 
 */
package com.xiter.igou.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

/**
 * Description:重连
 * 
 * @author liufeihua
 * @date 2014-11-17下午4:22:37
 * @version 1.0
 * 
 */
public class BaseHttpRequestRetryHandler implements HttpRequestRetryHandler {

	private int max_retry_count;

	public BaseHttpRequestRetryHandler(int max_retry_count) {
		super();
		this.max_retry_count = max_retry_count;
	}

	private static HashSet<Class<? extends IOException>> exceptionWhiteList = new HashSet<Class<? extends IOException>>();
	private static HashSet<Class<? extends IOException>> exceptionBlackList = new HashSet<Class<? extends IOException>>();

	static {
		exceptionWhiteList.add(NoHttpResponseException.class);

		exceptionWhiteList.add(UnknownHostException.class);
		exceptionWhiteList.add(SocketException.class);

		exceptionBlackList.add(SSLException.class);
		exceptionBlackList.add(InterruptedIOException.class);
		exceptionBlackList.add(SocketTimeoutException.class);

	}

	@Override
	public boolean retryRequest(IOException exception, int executionCount,
			HttpContext context) {
		if (executionCount > max_retry_count)
			return false;

		if (exceptionBlackList.contains(exception.getClass()))
			return false;

		if (exceptionWhiteList.contains(exception.getClass()))
			return true;

		HttpRequest request = (HttpRequest) context
				.getAttribute(ExecutionContext.HTTP_REQUEST);
		boolean idempotent = (request instanceof HttpEntityEnclosingRequest);
		if (!idempotent) {
			// 如果请求被认为是幂等的，那么就重试
			return true;
		}

		Boolean b = (Boolean) context
				.getAttribute(ExecutionContext.HTTP_REQ_SENT);
		boolean sent = (b != null && b.booleanValue());

		if (!sent) {
			return true;
		}

		return false;
	}

}
