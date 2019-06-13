package cn.itcast.chapter04.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		String param=request.getParameter("category");
		BookDao dao=new BookDao();
		List<Book>bookList=null;
		if(param==null||param.trim().isEmpty()) {
			try {
				bookList=dao.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {	
			int category=Integer.parseInt(param);
			try {
				bookList=dao.findByCategory(category);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doGet(request, response);
		} catch (Exception e) {
		}
	}

}
