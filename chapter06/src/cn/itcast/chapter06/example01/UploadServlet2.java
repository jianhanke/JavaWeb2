package cn.itcast.chapter06.example01;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet2
 */

	//ºÚªØ≤‚ ‘£¨ 
public class UploadServlet2 extends HttpServlet {

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
			System.out.println(fileupload.getFileItemFactory());
			fileupload.setHeaderEncoding("GBK");
			List<FileItem>fileitems=fileupload.parseRequest(request);
			PrintWriter writer=response.getWriter();
			for (FileItem fileitem:fileitems) {
				if(fileitem.isFormField()) {
					writer.print("’‚ «type:text<br />");
				}else {
					writer.println("TYPE:file<br />");
					String filename=fileitem.getName();
					filename=filename.substring(filename.lastIndexOf("\\")+1);
					filename=UUID.randomUUID().toString()+"_"+filename;
					String webPath="/upload/";
					String filepath=getServletContext().getRealPath(webPath+filename);
					File file=new File(filepath);
					file.getParentFile().mkdirs();
					file.createNewFile();
					InputStream in=fileitem.getInputStream();
					OutputStream out=new FileOutputStream(file);
					byte[] buffer=new byte[1024];
					int len;
					while((len=in.read(buffer))>0) {
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					fileitem.delete();
				}	
			}
		} catch (FileUploadException e) {
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
