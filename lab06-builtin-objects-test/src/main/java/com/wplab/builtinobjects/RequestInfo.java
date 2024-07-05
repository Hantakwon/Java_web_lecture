package com.wplab.builtinobjects;

import java.util.Enumeration;

public class RequestInfo {
	StringBuffer url;
	String method;
	String queryString;
	Enumeration<String> names;
	Enumeration<String> headers;
	String host;
	int port;
	
	public RequestInfo() {
		// TODO Auto-generated constructor stub
	}

	public RequestInfo(StringBuffer url, String method, String queryString, Enumeration<String> names,
			Enumeration<String> headers, String host, int port) {
		super();
		this.url = url;
		this.method = method;
		this.queryString = queryString;
		this.names = names;
		this.headers = headers;
		this.host = host;
		this.port = port;
	}

	public StringBuffer getUrl() {
		return url;
	}

	public void setUrl(StringBuffer url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public Enumeration<String> getNames() {
		return names;
	}

	public void setNames(Enumeration<String> names) {
		this.names = names;
	}
	
	public Enumeration<String> getHeaders() {
		return headers;
	}

	public void setHeaders(Enumeration<String> headers) {
		this.headers = headers;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
