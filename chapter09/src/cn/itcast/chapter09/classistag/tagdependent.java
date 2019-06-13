package cn.itcast.chapter09.classistag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class tagdependent extends TagSupport{

	public int doStartTag()throws JspException{
		
		return Tag.EVAL_BODY_INCLUDE;
	}
}
