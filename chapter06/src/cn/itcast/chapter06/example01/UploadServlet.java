package cn.itcast.chapter06.example01;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			File f=new File("F:\\Target");
			if(!f.exists()){
				f.mkdirs();
			}
			factory.setRepository(f);
			ServletFileUpload fileupload = new ServletFileUpload(factory);
			fileupload.setHeaderEncoding("gbk");
			List<FileItem>fileitems = fileupload.parseRequest(request);
			PrintWriter writer=response.getWriter();
			int i=0;
			for (FileItem fileitem : fileitems) {
				System.out.println(i++);
				if (fileitem.isFormField()) {
					System.out.println("字段");
					// 获得字段名和字段值
					String name = fileitem.getFieldName();
					String value = fileitem.getString("gbk");
					writer.print(name+"上传者："+value+"<br>");
				} else {
					String filename = fileitem.getName();
					writer.print("文件来源："+filename+"<br>");
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
					writer.print("成功上传的文件："+filename+"<br>");
					// 文件名需要唯一
					filename = UUID.randomUUID().toString() + "_" + filename;
					String webPath = "/upload/";
					String filepath =getServletContext().getRealPath(webPath+filename);
					File file = new File(filepath);
					if(!file.exists()) {
						file.getParentFile().mkdirs();
					}
//					boolean flag=file.getParentFile().mkdirs();
//					System.out.println(flag);
					file.createNewFile();				
					InputStream in = fileitem.getInputStream();
					OutputStream out = new FileOutputStream(file);

					byte[] buffer = new byte[1024];
					int len;
					while ((len = in.read(buffer)) > 0)
						out.write(buffer, 0, len);
					in.close();
					out.close();
					fileitem.delete();
				}
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		doGet(request, response);
	}
}
