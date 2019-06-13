package cn.itcast.chapter04.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaticFilter implements Filter {
	private FilterConfig config;
    public StaticFilter() {
    }
	public void destroy() {	
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		ServletContext sc=  config.getServletContext();
		Map<String,String>staticMap=(Map<String, String>) sc.getAttribute("static_map");
		if(staticMap==null) {
			staticMap=new HashMap<String,String>();
			sc.setAttribute("static_map", staticMap);
		}
		String category=request.getParameter("category");
		String key="book_"+category;
		if(staticMap.containsKey(key)) {
			String staticPath=staticMap.get(key);
			res.sendRedirect(req.getContextPath()+"/html/"+staticPath);   //chapter04/html/book_1.html
			System.out.println("找到了html"+req.getContextPath());
			return;
		}
		System.out.println("没找到");
		String staticPath=key+".html";  //book_1.html
		String realPath=sc.getRealPath("/html/"+staticPath);  //F:\spiring\sts-bundle\pivotal-tc-server\instances\base-instance\wtpwebapps\chapter04\html
			try {
				StaticResponse sr=new StaticResponse(res,realPath);
				chain.doFilter(request, sr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		staticMap.put(key, staticPath);
		res.sendRedirect(req.getContextPath()+"/html/"+staticPath);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		this.config=fConfig;
	}
}
