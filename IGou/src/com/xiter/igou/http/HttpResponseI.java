/**
 * 
 */
package com.xiter.igou.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.ParseException;

/**
 * Description:请求返回response的操作
 * 
 * @author liufeihua
 * @date 2014-11-17下午2:45:26
 * @version 1.0
 * 
 */
public interface HttpResponseI {

	/**
	 * 返回状态
	 * 
	 * @return
	 */
	public int statusCode();

	/**
	 * 获取输入流
	 * 
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public InputStream getResponseBody() throws IllegalStateException,
			IOException;

	/**
	 * 获取输入字节数组
	 * 
	 * @return
	 * @throws IOException
	 */
	public byte[] getResponseBodyAsByte() throws IOException;

	/**
	 * 获取输入字符串
	 * 
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public String getResponseBodyAsString() throws ParseException, IOException;
}
