package cn.itcast.chapter07.servlet;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.catalina.Session;


public class Welcome extends SimpleTagSupport{
	
	public void doTag() throws JspException, IOException {
		PageContext context=(PageContext) this.getJspContext();
		String name=(String) context.getSession().getAttribute("user");
		if(name!=null) {
			this.getJspBody().invoke(null);
		}
	}
}
