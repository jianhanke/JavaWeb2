package cn.itcast.chapter04.filter;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class StaticResponse extends HttpServletResponseWrapper{
	private HttpServletResponse response;
	private PrintWriter pw;
	
	public StaticResponse(HttpServletResponse response,String staticPath) throws Exception, UnsupportedEncodingException {
		super(response);
		this.response=response;
		pw=new PrintWriter(staticPath,"utf-8");
	}
	public PrintWriter getWriter() {
		return pw;
	}
	public void close() {
		pw.close();
	}
	
}
