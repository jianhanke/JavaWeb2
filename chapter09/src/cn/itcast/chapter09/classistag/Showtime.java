package cn.itcast.chapter09.classistag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Showtime extends SimpleTagSupport{
	
	private User user;
	public void setUser(User user) {
		this.user=user;
	}
	public void doTag() throws IOException {
		PageContext pageContext=(PageContext) this.getJspContext();
		JspWriter out=pageContext.getOut();
		out.write("当前用户的名字:"+user.getName());
	}
	
}
