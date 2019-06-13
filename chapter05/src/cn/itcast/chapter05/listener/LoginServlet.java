package cn.itcast.chapter05.listener;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username!=null&&!username.trim().equals("")) {
			User user=new User();
			user.setId(UUID.randomUUID().toString());
			user.setUsername(username);
			user.setPassword(password);
			request.getSession().setAttribute("user", user);
			Map users=OnlineUser.getInstance().getOnlineUsers();
			request.setAttribute("users", users);
			request.getRequestDispatcher("/showuser.jsp").forward(request,response);
		}else {
			request.setAttribute("errorMsg","用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
