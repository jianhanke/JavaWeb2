package cn.itcast.chapter04.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.itcast.chapter04.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
        System.out.println("测试容器实例化");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if("itcast".equals(username)&&"1".equals(password)) {
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			request.getSession().setAttribute("user", user);
			String autoLogin=request.getParameter("autologin");
			if(autoLogin!=null) {
				Cookie cookie=new Cookie("autologin",username+"-"+password);
				cookie.setMaxAge(Integer.parseInt(autoLogin));
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			request.setAttribute("errerMsg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
