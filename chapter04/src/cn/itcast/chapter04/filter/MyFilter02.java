package cn.itcast.chapter04.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class MyFilter02
 */
public class MyFilter02 implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter02() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.write("MyFilter02 Before<br/>");
		chain.doFilter(request, response);
		out.write("<br />MyFilter02After<br/>");
	}
	public void init(FilterConfig fConfig) throws ServletException {
//		ServletContext text=fConfig.getServletContext();
//		String name=text.getInitParameter("name");
//		System.out.println(name);
	}

}
