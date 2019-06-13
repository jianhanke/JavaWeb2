package library.Servlet.Admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.Dao.BooksDao;

/**
 * Servlet implementation class BookExistServlet
 */
public class BookExistServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BooksDao bookdao=new BooksDao();
		
		try {
			List  list = bookdao.findBorrowed();
			Object count=list.size();
			request.setAttribute("list", list);
			request.setAttribute("count", count);
			request.getRequestDispatcher("/Admin/no_borrow.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
