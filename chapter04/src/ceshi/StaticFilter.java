package ceshi;

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

/**
 * Servlet Filter implementation class StaticFilter
 */
public class StaticFilter implements Filter {
	FilterConfig config;

    public StaticFilter() {
       
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		
		String category=request.getParameter("category");
		ServletContext sc=config.getServletContext();
		Map<String,String> statciMap=(Map<String,String>) sc.getAttribute("static_map");
		if(statciMap==null) {
			 statciMap=new HashMap<String,String>();
			 sc.setAttribute("static_map", statciMap);
		}
		String key="book_"+category;
		if(statciMap.containsKey(key)) {
			String staticPath=statciMap.get(key);
			response.sendRedirect(request.getContextPath()+"/html/"+staticPath);
			return;
		}
		
		String staticPaht=key+".html";
		String realPath=sc.getRealPath("/html/"+staticPaht);
		try {
			StaticResponse sr=new StaticResponse(response,realPath);
			chain.doFilter(request,sr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statciMap.put(key,staticPaht);
		response.sendRedirect(request.getContextPath()+"/html/"+staticPaht);
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config=fConfig;
	}

}
