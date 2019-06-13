package cn.itcast.chapter09.classistag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class IpTag extends TagSupport{
	
	public int doStartTag()throws JspException{
		
		String IP=pageContext.getRequest().getRemoteAddr();
		try {
			pageContext.getOut().write("�����û���IP�ĵ�ַΪ:"+IP);
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(super.doStartTag());
		return super.doStartTag();
	}
	
}
