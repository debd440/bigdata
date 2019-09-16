package com.codebasket.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppFilter implements Filter {

	final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {

		System.out.println("Remote Host:" + request.getRemoteHost());
		System.out.println("Request Details: " + request);
		System.out.println("Remote Address:" + request.getRemoteAddr());
		request.getParameterMap().forEach((k, v) -> {
			System.out.println("Key: " + k);
			System.out.println("Value: " + v[0]);
		});
		logger.info("Loogging Host Name: {}", request.getRemoteHost());
		logger.info("Logging Respons:"+response.getOutputStream().toString());
		filterchain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
	}
}
