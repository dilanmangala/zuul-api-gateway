package com.microservice.zuulgatewayservice.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ErrorFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(ErrorFilter.class);
	
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		log.info("ErrorFilter: {} request to {}", request.getMethod(), request.getRequestURL());
		return null;
	}

	@Override
	public String filterType() {
		
		return "error";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
