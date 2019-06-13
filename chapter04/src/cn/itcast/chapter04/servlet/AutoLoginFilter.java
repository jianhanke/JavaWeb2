package cn.itcast.chapter04.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.parser.Cookie;

import cn.itcast.chapter04.entity.User;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
public class AutoLoginFilter implements Filter {
	
    public AutoLoginFilter() {
       
    }
	public void destroy() {	
		
	}
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Cookie过滤器");
		HttpServletRequest request=(HttpServletRequest)req;
		javax.servlet.http.Cookie[] cookies=request.getCookies();
		String autologin=null;
		for (int i=0;cookies!=null&&i<cookies.length;i++) {
			if("autologin".equals(cookies[i].getName())) {
				autologin=cookies[i].getValue();
				break;
			}
		}
			if(autologin!=null) {
				String[] parts=autologin.split("-");
				String username=parts[0];
				String password=parts[1];
				if("itcast".contentEquals(username)&&("1").equals(password)) {
					User user=new User();
					user.setUsername(username);
					user.setPassword(password);
					request.getSession().setAttribute("user", user);
				}
			}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("过滤器初始化");
	}

}
