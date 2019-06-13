package library.Filter;

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

import library.Entity.Admin;

/**
 * Servlet Filter implementation class SessionFilter
 */
public class SessionFilter implements Filter {
	
    public SessionFilter() {
        
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session = req.getSession();
		Admin admin=(Admin) session.getAttribute("admin");
		if(admin==null) {
			req.setAttribute("message", "你还没登录");
			req.getRequestDispatcher("/Admin/login.jsp").forward(req, response); 
			//	res.sendRedirect("/library/Admin/login.jsp");    //浏览器会无限重定向出错
		}
		chain.doFilter(request, response);
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
