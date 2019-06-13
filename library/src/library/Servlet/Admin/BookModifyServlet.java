package library.Servlet.Admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import library.Dao.BooksDao;
import library.Entity.Books;

/**
 * Servlet implementation class BookModifyServlet
 */
public class BookModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Books book=new Books();
		boolean flag=false;
		if(request.getMethod().equals("POST")) {
			System.out.println("进来了");
			BooksDao bookdao=new BooksDao();
			
			try {
				DiskFileItemFactory factory=new DiskFileItemFactory();
				File f=new File("f:\\Tceshi");
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
						}else if(fileitem.getFieldName().equals("id") ){
							book.setId(fileitem.getString("utf-8"));
						}	
					}else {
						String filename=fileitem.getName();
						if(filename.isEmpty()||filename==null) {
							book.setPicture(" ");
						}else {
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
				}
					
				flag=bookdao.modify(book);
				if(flag) {
					request.setAttribute("message", "修改成功");
				}else {
					request.setAttribute("message", "修改失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "修改失败");
			}
			request.getRequestDispatcher("/BookshowServlet").forward(request, response);
			return;
		}
		
		String book_id=request.getParameter("book_id");
		BooksDao bookdao=new BooksDao();
		try {
			Books book2= bookdao.find(book_id);
			Object count=bookdao.count();
			request.setAttribute("book", book2);

			request.getRequestDispatcher("/Admin/bookModify.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/Admin/bookModify.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
