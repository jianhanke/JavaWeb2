package cn.itcast.chapter06.example02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet22
 */
public class DownloadServlet22 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("这是一个测试");
		response.setContentType("text/html;charset=utf-8");
		String filepath=getServletContext().getRealPath("/download/1.jpg");
		File file=new File(filepath);
		response.setHeader("Context-Type", "application/octent-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(file.getName(),"utf-8"));
		
		InputStream finput=new FileInputStream(file);
		OutputStream out=response.getOutputStream();
		int len;
		byte[] buffer=new byte[1024];
		while((len=finput.read(buffer))!=-1) {
			out.write(buffer,0,len);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
