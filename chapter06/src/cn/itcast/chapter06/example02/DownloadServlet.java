package cn.itcast.chapter06.example02;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse 
		response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// ֪ͨ����������صķ�ʽ��
		response.addHeader("Content-Type", "application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=1.jpg");
		// ͨ���ļ�����ȡ�ļ�
		InputStream in = getServletContext().getResourceAsStream(
			"/download/1.jpg");
		// ��ȡresponse����������
		OutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
	}
  	public void doPost(HttpServletRequest request, HttpServletResponse 
  		response) throws ServletException, IOException {
		doGet(request, response);
	}
}
