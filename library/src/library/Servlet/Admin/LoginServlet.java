package library.Servlet.Admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.Dao.AdminDao;
import library.Entity.Admin;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Admin admin=new Admin();
			admin.setId(request.getParameter("id"));
			admin.setPwd(request.getParameter("pwd"));
			AdminDao admindao=new AdminDao();
			try {
				Boolean flag=admindao.checkLogin(admin);
				if(flag) {
					Admin admin2=admindao.sessionAdmin(request.getParameter("id"));
					request.getSession().setAttribute("admin", admin2);
					response.sendRedirect("/library/Admin/index.jsp");
				}else {
					request.setAttribute("message","’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
					request.getRequestDispatcher("/Admin/login.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
