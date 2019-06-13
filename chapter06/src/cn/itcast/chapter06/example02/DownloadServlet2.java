package cn.itcast.chapter06.example02;
import java.io.*;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.http.*;
public class DownloadServlet2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
         response.setContentType("text/html;charset=utf-8");
          // ��þ���·�������ļ�����
         String path=getServletContext().getRealPath("/download/1.jpg");
         File file=new File(path);
          // ֪ͨ����������صķ�ʽ���ļ�
         System.out.println(file.getName());
		response.addHeader("Content-Type", "application/octet-stream");
         response.addHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(file.getName(),"utf-8"));
         
		InputStream in=new FileInputStream(file);
         // ��ȡresponse����������
		OutputStream out = response.getOutputStream();		
        byte [] buffer=new byte[1024];
		int len;
		while((len=in.read(buffer))!=-1){
			out.write(buffer,0,len);
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse  resp)throws ServletException, IOException {
		doGet(req, resp);
	}
}
