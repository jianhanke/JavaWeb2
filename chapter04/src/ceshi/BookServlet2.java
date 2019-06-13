package ceshi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BookServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BookServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list=null;
		String category=request.getParameter("category");
		BookDao bookdao=new BookDao();
		if(category==null||category.isEmpty()) {
			try {
				list=bookdao.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			int num=Integer.parseInt(category);
			try {
				list=bookdao.findByCategory(num);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("bookList", list);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
