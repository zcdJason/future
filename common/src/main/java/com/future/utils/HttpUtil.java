package com.future.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <p>Http工具类
 * <p>Http工具类，为系统提供通用Http访问操作方法：
 * <p>1、发送GET请求；
 * <p>2、发送POST请求。
 * 
 */
public class HttpUtil {
	
	/**
	 * <p>发送GET请求
	 * @param  url GET请求地址
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 * 
	 */
	public static String doGet(String url) throws IOException {
		return HttpUtil.doGet(url , "utf-8");
	}

	/**
	 * <p>发送GET请求
	 * @param  url GET请求地址
	 * @param charset 字符编码
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 * 
	 */
	public static String doGet(String url, String charset) throws IOException {
		return HttpUtil.doGet(url , null , charset);
	}

	/**
	 * <p>发送GET请求
	 * @param  url       GET请求地址
	 * @param  headerMap GET请求头参数容器
	 * @param charset 字符编码
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doGet(String url , Map<String, Object> headerMap, String charset) throws IOException {
		return HttpUtil.doGet(url , headerMap, charset, null , 0);
	}

	/**
	 * <p>发送GET请求
	 * @param  url       GET请求地址
	 * @param charset 字符编码
	 * @param  proxyUrl  代理服务器地址
	 * @param  proxyPort 代理服务器端口号
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doGet(String url, String charset , String proxyUrl , int proxyPort) throws IOException {
		return HttpUtil.doGet(url , null , charset, proxyUrl , proxyPort);
	}

	/**
	 * <p>发送GET请求
	 * @param  url       GET请求地址
	 * @param  headerMap GET请求头参数容器
	 * @param charset 字符编码
	 * @param  proxyUrl  代理服务器地址
	 * @param  proxyPort 代理服务器端口号
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doGet(String url , Map<String, Object> headerMap, String charset , String proxyUrl , int proxyPort) throws IOException {
		String     content    = null;
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:44.0) Gecko/20100101 Firefox/44.0");
		GetMethod  getMethod  = new GetMethod(url);
		if (headerMap != null) {
			//头部请求信息
			if (headerMap != null) {
				Iterator<Entry<String, Object>> iterator = headerMap.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<String, Object> entry = iterator.next();
					getMethod.addRequestHeader(entry.getKey().toString() , entry.getValue().toString());
				}
			}
		}
		if (StringUtils.isNotBlank(proxyUrl)) {
			httpClient.getHostConfiguration().setProxy(proxyUrl , proxyPort);
		}
		//设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT , 10000);
		InputStream inputStream = null;
		if (httpClient.executeMethod(getMethod) == HttpStatus.SC_OK) {
			//读取内容
			inputStream = getMethod.getResponseBodyAsStream();
			content     = IOUtils.toString(inputStream, charset);
		} else {
			throw new IOException("return http code " + getMethod.getStatusLine().getStatusCode());
		}
		inputStream.close();
		getMethod.releaseConnection();
		return content;
	}

	/**
	 * <p>发送POST请求
	 * @param  url          POST请求地址
	 * @param  parameterMap POST请求参数容器
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doPost(String url , Map<String, Object> parameterMap) throws IOException {
		return HttpUtil.doPost(url , null , parameterMap , "utf-8" , null , 0);
	}

	/**
	 * <p>发送POST请求
	 * 
	 * @param  url          POST请求地址
	 * @param  parameterMap POST请求参数容器
	 * @param  paramCharset 参数字符集名称
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doPost(String url , Map<String, Object> parameterMap , String paramCharset) throws IOException {
		return HttpUtil.doPost(url , null , parameterMap , paramCharset , null , 0);
	}

	/**
	 * <p>发送POST请求
	 * 
	 * @param  url          POST请求地址
	 * @param  headerMap    POST请求头参数容器
	 * @param  parameterMap POST请求参数容器
	 * @param  paramCharset 参数字符集名称
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doPost(String url , Map<String, Object> headerMap , Map<String, Object> parameterMap , String paramCharset) throws IOException {
		return HttpUtil.doPost(url , headerMap , parameterMap , paramCharset , null , 0);
	}

	/**
	 * <p>发送POST请求
	 * @param  url          POST请求地址
	 * @param  parameterMap POST请求参数容器
	 * @param  paramCharset 参数字符集名称
	 * @param  proxyUrl     代理服务器地址
	 * @param  proxyPort    代理服务器端口号
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doPost(String url , Map<String, Object> parameterMap , String paramCharset , String proxyUrl , int proxyPort) throws IOException {
		return HttpUtil.doPost(url , null , parameterMap , paramCharset , proxyUrl , proxyPort);
	}

	/**
	 * <p>发送POST请求
	 * 
	 * @param  url          POST请求地址
	 * @param  headerMap    POST请求头参数容器
	 * @param  parameterMap POST请求参数容器
	 * @param  paramCharset 参数字符集名称
	 * @param  proxyUrl     代理服务器地址
	 * @param  proxyPort    代理服务器端口号
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doPost(String url , Map<String, Object> headerMap , Map<String, Object> parameterMap , String paramCharset , String proxyUrl , int proxyPort) throws IOException {
		String     content    = null;
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:44.0) Gecko/20100101 Firefox/44.0");
		PostMethod postMethod = new PostMethod(url);
		if (StringUtils.isNotBlank(paramCharset)) {
			postMethod.getParams().setContentCharset(paramCharset);
			postMethod.getParams().setHttpElementCharset(paramCharset);
		}
		if (headerMap != null) {
			//头部请求信息
			if (headerMap != null) {
				Iterator<Entry<String, Object>> iterator = headerMap.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<String, Object> entry = iterator.next();
					postMethod.addRequestHeader(entry.getKey().toString() , entry.getValue().toString());
				}
			}
		}
		Iterator<String> iterator = parameterMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			postMethod.addParameter(key , (String) parameterMap.get(key));
		}
		if (StringUtils.isNotBlank(proxyUrl)) {
			httpClient.getHostConfiguration().setProxy(proxyUrl , proxyPort);
		}
		//设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
		postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT , 10000);
		InputStream inputStream = null;
		if (httpClient.executeMethod(postMethod) == HttpStatus.SC_OK) {
			//读取内容
			inputStream = postMethod.getResponseBodyAsStream();
			content     = IOUtils.toString(inputStream, paramCharset);
		} else {
			throw new IOException("return http code " + postMethod.getStatusLine().getStatusCode());
		}
		inputStream.close();
		postMethod.releaseConnection();
		return content;
	}
	
	/**
	 * <p>发送POST请求
	 * @param  url          POST请求地址
	 * @param  parameter	POST json请求参数容器
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doPostJson(String url, String parameter) throws IOException {
		return doPostJson(url, null, parameter, "utf-8", null, 0);
	}
	
	
	/**
	 * <p>发送POST请求
	 * 
	 * @param  url          POST请求地址
	 * @param  parameter	POST json请求参数容器
	 * @param  paramCharset 参数字符集名称
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doPostJson(String url, String parameter, String paramCharset) throws IOException {
		return doPostJson(url, null, parameter, paramCharset, null, 0);
	}
	
	/**
	 * <p>发送POST请求
	 * 
	 * @param  url          POST请求地址
	 * @param  parameter	POST json请求参数容器
	 * @param  paramCharset 参数字符集名称
	 * @param  proxyUrl     代理服务器地址
	 * @param  proxyPort    代理服务器端口号
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doPostJson(String url, String parameter, String paramCharset , String proxyUrl , int proxyPort) throws IOException {
		return doPostJson(url, null, parameter, paramCharset, proxyUrl, proxyPort);
	}
	
	
	/**
	 * <p>发送POST请求
	 * 
	 * @param  url          POST请求地址
	 * @param  headerMap    POST请求头参数容器
	 * @param  parameter	POST json请求参数容器
	 * @param  paramCharset 参数字符集名称
	 * @param  proxyUrl     代理服务器地址
	 * @param  proxyPort    代理服务器端口号
	 * @return 与当前请求对应的响应内容字节数组
	 * @throws IOException 
	 */
	public static String doPostJson(String url , Map<String, Object> headerMap ,String parameter, String paramCharset , String proxyUrl , int proxyPort) throws IOException {
		String     content    = null;
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:44.0) Gecko/20100101 Firefox/44.0");
		PostMethod postMethod = new PostMethod(url);
		postMethod.getParams().setContentCharset(paramCharset);
		postMethod.getParams().setHttpElementCharset(paramCharset);
		if (headerMap != null) {
			//头部请求信息
			if (headerMap != null) {
				Iterator<Entry<String, Object>> iterator = headerMap.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<String, Object> entry = iterator.next();
					postMethod.addRequestHeader(entry.getKey().toString() , entry.getValue().toString());
				}
			}
		}
		//设置
		try {
			RequestEntity entity = new StringRequestEntity(parameter, "application/json", paramCharset);
			postMethod.setRequestEntity(entity);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (StringUtils.isNotBlank(proxyUrl)) {
			httpClient.getHostConfiguration().setProxy(proxyUrl , proxyPort);
		}
		//设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
		postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT , 10000);
		InputStream inputStream = null;
		if (httpClient.executeMethod(postMethod) == HttpStatus.SC_OK) {
			//读取内容
			inputStream = postMethod.getResponseBodyAsStream();
			content     = IOUtils.toString(inputStream, paramCharset);
		} else {
			throw new IOException("return http code " + postMethod.getStatusLine().getStatusCode());
		}
		inputStream.close();
		postMethod.releaseConnection();
		return content;
	}
	
}
