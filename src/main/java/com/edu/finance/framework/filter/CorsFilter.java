package com.edu.finance.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try{
			HttpServletRequest req=(HttpServletRequest)request;
			String origin=req.getHeader("Origin");
			String host=req.getHeader("host");
			if(null==origin || origin.equals(host)){
				return;
			}
			HttpServletResponse resp=(HttpServletResponse)response;
			resp.addHeader("Access-Control-Allow-Origin", origin);
			resp.addHeader("Access-Control-Allow-Headers", "Content-type,accept,Origin,User-Agent,Set-Cookie,Keep-alive,cache-control,If-Modified-Since,If-None-Match");
			resp.addHeader("Access-Control-Allow-Credentials", "true");
			resp.addHeader("P3P", "CP=\"IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT\"");
		}finally{
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
