package com.cognizant.zuulgateway.filter;

import com.netflix.zuul.ZuulFilter;

public class SimpleFilter extends ZuulFilter{

	public String run(){
		return null;
	}
	
	public boolean shouldFilter() { 
		return true;
	}
	
	
	public int filterOrder() { 
			return 1;
		}
		
	public String filterType() { 
			return "pre";
		}
}
