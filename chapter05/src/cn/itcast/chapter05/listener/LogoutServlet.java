package cn.itcast.chapter05.listener;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logoutServlet
 */
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		request.getSession().removeAttribute("user");
		OnlineUser onuser=OnlineUser.getInstance();
		
		onuser.removeUser(user);
		Map users=onuser.getOnlineUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/showuser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
