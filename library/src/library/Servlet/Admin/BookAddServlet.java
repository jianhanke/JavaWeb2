package library.Servlet.Admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
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

import library.Dao.BooksDao;
import library.Entity.Books;

/**
 * Servlet implementation class BookAddServlet
 */
public class BookAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Books book=new Books();
		boolean flag=false;
		
		if(request.getMethod().equals("POST")) {
			BooksDao bookdao=new BooksDao();
			try {
				DiskFileItemFactory factory=new DiskFileItemFactory();
				File f=new File("c:\\Tceshi");
				if(!f.exists()) {
					f.mkdirs();
				}
				factory.setRepository(f);
				ServletFileUpload fileupload=new ServletFileUpload(factory);
				
				fileupload.setHeaderEncoding("GBK");
	
				List<FileItem>fileitems=fileupload.parseRequest(request);
				
				for (FileItem fileitem:fileitems) {
					if(fileitem.isFormField()) {						
						if(fileitem.getFieldName().equals("press") ) {
							book.setPress(fileitem.getString("utf-8"));
						}else if(fileitem.getFieldName().equals("book_name") ) {
							book.setBook_name(fileitem.getString("utf-8"));
						}else if(fileitem.getFieldName().equals("author") ){
							book.setAuthor(fileitem.getString("utf-8"));
						}else if(fileitem.getFieldName().equals("remark") ){
							book.setRemark(fileitem.getString("utf-8"));
						}	
					}else {
						String filename=fileitem.getName();
						filename=filename.substring(filename.lastIndexOf("."));
						filename=UUID.randomUUID().toString()+"_"+filename;
						
						String webpath="/images/";
						String filepath="E:\\wamp\\apache\\library\\Public\\books\\"+filename;
						File file=new File(filepath);
						InputStream in=fileitem.getInputStream();
						OutputStream out=new FileOutputStream(file);
						byte[] buffer=new byte[1024];
						int len;
						while((len=in.read(buffer))>0) {
							out.write(buffer,0,len);
						}
						book.setPicture(filepath);
						
						in.close();
						out.close();
						fileitem.delete();
					}	
				}
			
				flag=bookdao.add(book);
				if(flag) {
					request.setAttribute("message", "添加成功");
				}else {
					request.setAttribute("message", "添加失败");
				}
			} catch (Exception e) {
				request.setAttribute("message", "添加失败,信息不完善");
			}
		
		}
		request.getRequestDispatcher("/Admin/bookAdd.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
