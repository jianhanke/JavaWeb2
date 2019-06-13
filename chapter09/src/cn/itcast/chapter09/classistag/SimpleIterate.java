package cn.itcast.chapter09.classistag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleIterate extends SimpleTagSupport{
	private int num;
	public void setNum(int num) {
		this.num=num;
	}
	public void doTag() throws JspException, IOException{
		JspFragment jf=this.getJspBody();
		JspContext context1 = this.getJspContext();
		JspContext context2=  jf.getJspContext();
		
		System.out.println(context1);
		System.out.println(context2);
		
		for (int i=0;i<num;i++) {
			jf.invoke(null);
		}
	}
	
}
