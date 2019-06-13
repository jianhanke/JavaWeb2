package cn.itcast.chapter07.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("username", "itcast");
		request.setAttribute("password", "123");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("≤‚ ‘");
		StringBuffer sbuffer=new StringBuffer(10);
		System.out.println(sbuffer);
		request.getRequestDispatcher("ceshi.jsp").include(request,response);
		
	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
