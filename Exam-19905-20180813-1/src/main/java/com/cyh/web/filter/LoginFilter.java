package com.cyh.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyh.modle.Customer;

public class LoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;  
        HttpServletResponse response = (HttpServletResponse)res;  
		//从session中获取sessionKey对应的值；若不存在  则跳转到登陆页面  
        Customer user = (Customer)(request.getSession().getAttribute("customer"));  
        if(user==null){
            request.getRequestDispatcher("/login.jsp").forward(request, response);  
            return;  
        }  
        //若存在 则放行；  
        chain.doFilter(request, response);  
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
