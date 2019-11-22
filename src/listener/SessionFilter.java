package listener;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;

public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		HttpSession session = servletRequest.getSession();
		UserBean userBean = (UserBean) session.getAttribute("user");
		System.out.println("test in filter");
		
		String address = servletRequest.getLocalName();
		address = servletRequest.getRequestURI();
		
		//System.out.println(servletRequest.getRequestURI());;
		
		System.out.println("address:" + address);
		System.out.println(address.indexOf("/login.html"));
		
		if (address.indexOf("/login") > -1) {
			System.out.println("jump to login");
			arg2.doFilter(request, response);
			return;
		}
		if (address.indexOf("/logout") > -1) {
			System.out.println("jump to logout");
			arg2.doFilter(request, response);
			return;
		}
				
		if (userBean == null) {
			
			System.out.println("user is null");
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/login.html");
//			servletRequest.getRequestDispatcher("/login.html").forward(request, response);
			
		} else {
			//System.out.println("usernema:" + userBean.getName());
			System.out.println("user is not null");
			arg2.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
