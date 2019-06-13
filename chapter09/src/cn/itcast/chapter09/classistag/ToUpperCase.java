package cn.itcast.chapter09.classistag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class ToUpperCase extends BodyTagSupport{
	
	public int doEndTag() throws JspException{
		String content=getBodyContent().getString();
		content=content.toUpperCase();
		try {
			bodyContent.getEnclosingWriter().write(content);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}
}
