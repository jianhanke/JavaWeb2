package library.Servlet.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.Dao.UserDao;

/**
 * Servlet implementation class UserdeleteServlet
 */
public class UserdeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("text/html;charset=utf-8");
		UserDao userdao=new UserDao();
		boolean flag=userdao.delete(request.getParameter("id"));
		System.out.println(flag);
		if(flag) {
			response.sendRedirect(request.getContextPath()+"/UsershowServlet");
		}else {
			response.sendRedirect(request.getContextPath()+"/UsershowServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
