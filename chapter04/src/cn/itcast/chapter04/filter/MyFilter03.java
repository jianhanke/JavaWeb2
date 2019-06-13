package cn.itcast.chapter04.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class MyFilter03
 */
public class MyFilter03 implements Filter {
	private String characterEncoding;
	FilterConfig fc;
    public MyFilter03() {
    }

	public void destroy() {	
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		characterEncoding=fc.getInitParameter("encoding");
		ServletContext context=fc.getServletContext();
		String name=(String) context.getInitParameter("name");
		context.setAttribute("name2", "hujing");
		System.out.println("context:"+name);
		
		System.out.println("encoding初始化编码为:"+characterEncoding);
		response.getWriter().write("第三个Filter<br />");
		chain.doFilter(request, response);
		
		String name2=(String)context.getAttribute("name2");
		System.out.println(name2);
		Enumeration e=fc.getInitParameterNames();
		while(e.hasMoreElements()) {
			String name1=(String) e.nextElement();
			System.out.println(name1+":"+fc.getInitParameter(name1));
		}
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		this.fc=fConfig;
	}

}
