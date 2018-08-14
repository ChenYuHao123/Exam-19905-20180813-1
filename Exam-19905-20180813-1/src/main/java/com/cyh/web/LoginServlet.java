package com.cyh.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyh.dao.CustomerDao;
import com.cyh.dao.impl.CustomerImpl;
import com.cyh.modle.Customer;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(123);
		HttpSession session = request.getSession();
		String first_name = request.getParameter("first_name");
		CustomerDao dao = new CustomerImpl();
		Customer customer = new Customer();
		customer = dao.login(first_name);
		if(customer != null){
			//登陆成功
			//判断是否选择自动登陆
			String auto = request.getParameter("autoLogin");
			if("true".equals(auto)){
				//自动登陆
				Cookie cookie_username = new Cookie("cookie_username",customer.getFirst_name());
				cookie_username.setMaxAge(10*60);
				response.addCookie(cookie_username);
			}
			session.setAttribute("customer", customer);
			
			List<String> list_l = dao.getLanguageList();
			session.setAttribute("list_l", list_l);
			System.out.println(list_l);
			response.sendRedirect(request.getContextPath()+"/film?method=list");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
