/**
 * 
 */
package com.xiter.igou.http;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import com.xiter.igou.util.Config;

/**
 * Description:TODO
 * 
 * @author liufeihua
 * @date 2014-11-17下午4:37:15
 * @version 1.0
 * 
 */
public class BaseHttpClient {

	private static AbstractHttpClient httpClient;

	public static final int DEAFAULT_RETTES_COUNT = 5;

	protected static int retriesCount = DEAFAULT_RETTES_COUNT;

	/**
	 * 最大连接数
	 */
	public final static int MAX_TOTAL_CONNECTIONS = 100;

	/**
	 * 获取连接的最大等待时间
	 */
	public final static int WAIT_TIMEOUT = 30000;
	/**
	 * 每个路由最大连接数
	 */
	public final static int MAX_ROUTE_CONNECTIONS = 100;
	/**
	 * 连接超时时间
	 */
	public final static int CONNECT_TIMEOUT = 10000;
	/**
	 * 读取超时时间
	 */
	public final static int READ_TIMEOUT = 10000;

	public static void initHttpClient() {
		HttpParams httpParams = new BasicHttpParams();

		// 设置最大连接数
		ConnManagerParams.setMaxTotalConnections(httpParams,
				MAX_TOTAL_CONNECTIONS);

		// 设置获取连接的最大等待时间
		ConnManagerParams.setTimeout(httpParams, WAIT_TIMEOUT);

		// 设置每个路由最大连接数
		ConnPerRouteBean connPerRoute = new ConnPerRouteBean(
				MAX_ROUTE_CONNECTIONS);
		ConnManagerParams.setMaxConnectionsPerRoute(httpParams, connPerRoute);

		// 设置连接超时时间
		HttpConnectionParams.setConnectionTimeout(httpParams, CONNECT_TIMEOUT);
		// 设置读取超时时间
		HttpConnectionParams.setSoTimeout(httpParams, READ_TIMEOUT);

		HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(httpParams, HTTP.UTF_8);

		SchemeRegistry registry = new SchemeRegistry();
		registry.register(new Scheme("http", PlainSocketFactory
				.getSocketFactory(), 80));
		registry.register(new Scheme("https", SSLSocketFactory
				.getSocketFactory(), 443));

		ClientConnectionManager conman = new ThreadSafeClientConnManager(
				httpParams, registry);

		httpClient = new DefaultHttpClient(conman, httpParams);

		httpClient.setHttpRequestRetryHandler(new BaseHttpRequestRetryHandler(
				retriesCount));
	}

	/**
	 * Post请求，返回InputStream 流
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static InputStream postAsStream(String url,
			Map<String, Object> params) throws Exception {

		UrlEncodedFormEntity entity = null;
		if (null != params) {
			entity = new UrlEncodedFormEntity(parseParams(params), "utf-8");
		}

		return request(Config.STRURL + url, entity).getResponseBody();
	}

	/**
	 * Post 请求并返回 String 字符串
	 * 
	 * @param url
	 *            URL 地址
	 * @return String 结果
	 * @throws Exception
	 */
	// public String post(String url) throws Exception {
	// return post(url, null);
	// }

	// public <T> T post(String url, HashMap<String, Object> params, Class<T>
	// clz)
	// throws Exception {
	//
	// String json = post(url, params);
	// return JSONUtil.fromJson(json, clz);
	//
	// }

	public static String post(String url, Map<String, Object> params)
			throws Exception {

		UrlEncodedFormEntity entity = null;
		if (null != params) {
			entity = new UrlEncodedFormEntity(parseParams(params), "utf-8");
		}

		return request(Config.STRURL + url, entity).getResponseBodyAsString();

	}

	/**
	 * Post 请求并返回byte[]
	 * 
	 * @param url
	 *            URL 地址
	 * @return String 结果
	 * @throws Exception
	 */
	public static byte[] postAsBtye(String url, Map<String, Object> params)
			throws Exception {

		UrlEncodedFormEntity entity = null;
		if (null != params) {
			entity = new UrlEncodedFormEntity(parseParams(params), "utf-8");
		}

		return request(Config.STRURL + url, entity).getResponseBodyAsByte();

	}

	public static HttpResponseI request(String url, HttpEntity entity)
			throws Exception {

		HttpRequestI request = new HttpPost(httpClient, url, entity);

		return request.request();

	}

	/**
	 * HashMap 参数解析
	 * 
	 * @param params
	 * @return
	 */
	private static List<BasicNameValuePair> parseParams(
			Map<String, Object> params) {

		if (params == null || 0 == params.size())
			return null;

		List<BasicNameValuePair> paramsList = new ArrayList<BasicNameValuePair>(
				params.size());

		for (Entry<String, Object> entry : params.entrySet()) {

			paramsList.add(new BasicNameValuePair(entry.getKey(), entry
					.getValue() + ""));

		}
		return paramsList;

	}

}
