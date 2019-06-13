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
 * Servlet implementation class UseraddServlet
 */
public class UseraddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=utf-8");
		User user=new User();
		user.setUser_id(request.getParameter("user_id"));
		user.setUser_name(request.getParameter("user_name"));
		user.setUser_pwd(request.getParameter("user_pwd"));
		user.setUser_sex(request.getParameter("user_sex"));
		user.setUser_tele(request.getParameter("user_tele"));
		UserDao userdao=new UserDao();
		System.out.println(request.getParameter("user_name"));
	
			try {
				boolean flag=userdao.insert(user);
				if(flag) {
					request.setAttribute("message", "添加成功");
				}else {
					request.setAttribute("message", "添加失败");
				}
				request.getRequestDispatcher("/Admin/userAdd.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
