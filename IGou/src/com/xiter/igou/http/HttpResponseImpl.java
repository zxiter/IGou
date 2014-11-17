/**
 * 
 */
package com.xiter.igou.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

/**
 * Description:TODO
 * 
 * @author liufeihua
 * @date 2014-11-17下午2:45:49
 * @version 1.0
 * 
 */
public class HttpResponseImpl implements HttpResponseI {

	private HttpResponse response;
	private HttpEntity entity;

	public HttpResponseImpl(HttpResponse response) throws IOException {
		this.response = response;
		HttpEntity tempEntity = response.getEntity();
		if (null != tempEntity) {
			entity = new BufferedHttpEntity(tempEntity);
		}
	}

	@Override
	public int statusCode() {

		return response.getStatusLine().getStatusCode();
	}

	@Override
	public InputStream getResponseBody() throws IllegalStateException,
			IOException {

		return entity.getContent();
	}

	@Override
	public byte[] getResponseBodyAsByte() throws IOException {

		return EntityUtils.toByteArray(entity);
	}

	@Override
	public String getResponseBodyAsString() throws ParseException, IOException {

		return EntityUtils.toString(entity);
	}

}
