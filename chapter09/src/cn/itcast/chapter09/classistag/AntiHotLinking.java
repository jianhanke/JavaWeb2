package cn.itcast.chapter09.classistag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AntiHotLinking extends SimpleTagSupport{
	private String url;
	private int age;
	public void setUrl(String url) {
		this.url=url;
	}
	public void setAge(int age) {
		System.out.println("ceshi");
		this.age=age;
	}
		
	public void doTag() throws IOException {
		PageContext pagecontext=(PageContext) this.getJspContext();
		HttpServletRequest request=(HttpServletRequest) pagecontext.getRequest();
		String refer=request.getHeader("referer");
		String serverName="http://"+request.getServerName();
		System.out.println(serverName);
		if(refer!=null&&refer.startsWith(serverName)) {
			
		}else {
			HttpServletResponse resp=(HttpServletResponse) pagecontext.getResponse();
			resp.sendRedirect(url);
		}
		
	}
}
