package library.Servlet.Admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.Dao.UserDao;
import library.Entity.User;

/**
 * Servlet implementation class UsermodifyServlet
 */
public class UsermodifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=utf-8");
		UserDao userdao=new UserDao();
		if(request.getMethod().contentEquals("GET") ) {
			try {
				User user=userdao.find(request.getParameter("id"));
				request.setAttribute("user", user);
				request.getRequestDispatcher("/Admin/userModify.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return;
		}else {
			User user=new User();
			user.setUser_id(request.getParameter("user_id"));
			user.setUser_name(request.getParameter("user_name"));
			user.setUser_pwd(request.getParameter("user_pwd"));
			user.setUser_sex(request.getParameter("user_sex"));
			user.setUser_tele(request.getParameter("user_tele"));
			boolean flag = userdao.update(user);
			if(flag) {
				response.sendRedirect(request.getContextPath()+"/UsershowServlet");
			}else {
				request.setAttribute("message", "ÐÞ¸ÄÊ§°Ü");
				request.getRequestDispatcher("/UsermodifyServlet?id="+request.getParameter("user_id")).forward(request, response);
			}
			
			
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
