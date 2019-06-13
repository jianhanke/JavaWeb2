package cn.itcast.chapter06.example01;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**  
 * 
 */
			//测试getItemIterator

public class UploadServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			DiskFileItemFactory factory=new DiskFileItemFactory();
			File f=new File("f:\\Tceshi");
			if(!f.exists()) {
				f.mkdirs();
			}
			factory.setRepository(f);
			ServletFileUpload fileupload=new ServletFileUpload(factory);
			
			fileupload.setHeaderEncoding("GBK");
			FileItemIterator itor=fileupload.getItemIterator(request);
			PrintWriter writer=response.getWriter();
			while(itor.hasNext()) {
				FileItemStream fstream=itor.next();
				if(fstream.isFormField()) {
					writer.println("这是text<br />");
				}else {
					writer.println("文件<br />");
					String filename=fstream.getName();
					filename=filename.substring(filename.lastIndexOf("\\")+1);
					filename=UUID.randomUUID().toString()+"-"+filename;
					String webpath="/upload/";
					String filepath=getServletContext().getRealPath(webpath+filename);
					File file=new File(filepath);
					file.getParentFile().mkdirs();
					InputStream inStream=fstream.openStream();
					
					OutputStream out=new FileOutputStream(file);
					byte[] buffer=new byte[1024];
					int len;
					while((len=inStream.read(buffer))>0)
						out.write(buffer,0,len);
					inStream.close();
					out.close();
				}
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
