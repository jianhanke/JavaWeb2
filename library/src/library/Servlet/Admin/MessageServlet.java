package library.Servlet.Admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.Dao.MessageDao;
import library.Entity.Message;

/**
 * Servlet implementation class BookStaticServlet
 */
public class MessageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MessageDao dao=new MessageDao();
		boolean flag;
		if(request.getParameter("delete_id")!=null) {
			try {
				flag=dao.delteById(request.getParameter("delete_id"));
			} catch (SQLException e) {
				flag=false;
			}
			if(flag) {
				request.setAttribute("message", "É¾³ý³É¹¦");
			}else {
				request.setAttribute("message", "É¾³ýÊ§°Ü");
			}
		}else if(request.getParameter("top_id")!=null) {
				try {
					flag=dao.top(request.getParameter("top_id"));
					if(flag) {
						request.setAttribute("message", "ÖÃ¶¥³É¹¦");
					}else {
						request.setAttribute("message", "ÖÃ¶¥Ê§°Ü");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		try {
			List list=dao.findAll();
			Message one=dao.findOne();
			request.setAttribute("one", one);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/Admin/message.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
