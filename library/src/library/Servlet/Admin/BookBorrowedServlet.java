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
 * Servlet implementation class BookBorrowedServlet
 */
public class BookBorrowedServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BooksDao bookdao=new BooksDao();
		if(request.getMethod().equals("POST")) {
			try {
				List list=bookdao.findByKeys(request.getParameter("search-sort"),request.getParameter("keywords") );
				request.setAttribute("list", list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			try {
				List list = bookdao.findBorrowed();
				Object count=list.size();
				request.setAttribute("list", list);
				request.setAttribute("count", count);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.getRequestDispatcher("/Admin/haved_borrow.jsp").forward(request, response);
			
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
