package cn.itcast.chapter06.exam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload extends HttpServlet {
	private long maxSize=1*1024*1024;   //1M
	String[] postfixs= {"jpg","text"};
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		DiskFileItemFactory dfactory=new DiskFileItemFactory();
		String tempath="F://itcast";
		File temfile=new File(tempath);
		dfactory.setRepository(temfile);
		ServletFileUpload sfupload=new ServletFileUpload(dfactory);
		PrintWriter writer=response.getWriter();
		try {
			List<FileItem> fitems=sfupload.parseRequest(request);
			for(FileItem fitem:fitems) {
				if(fitem.isFormField()) {
					writer.print("这是字段");
				}else {
					//判断长传文件类型
					String fileName=fitem.getName();
					String postfix=fileName.substring(fileName.lastIndexOf(".")+1);
					List list=Arrays.asList(postfixs);
					if(!list.contains(postfix) ) {
						request.setAttribute("message", "上传文件格式不对");
						request.getRequestDispatcher("message.jsp").include(request,response);
						return;
					}
					long fileSize=fitem.getSize();
					if(fileSize>maxSize) {     //判断上传文件大小
						request.setAttribute("message", "你长传文件过大");
						request.getRequestDispatcher("message.jsp").include(request, response);
						return ;
					}
					fileName=UUID.randomUUID().toString()+"_"+fileName;
					String uploadPath="/upload/";
					String realPath=getServletContext().getRealPath(uploadPath+fileName);
					File file=new File(realPath);
					file.getParentFile().mkdirs();
					InputStream in=fitem.getInputStream();
					OutputStream out=new FileOutputStream(file);
					int len;
					byte[] buffer=new byte[1024];
					while((len=in.read(buffer))>0)
						out.write(buffer);
					in.close();
					out.close();
					fitem.delete();
					request.setAttribute("message", "恭喜你上传成功");
					request.getRequestDispatcher("message.jsp").include(request, response);
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
