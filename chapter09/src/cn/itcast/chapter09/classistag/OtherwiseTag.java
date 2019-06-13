package cn.itcast.chapter09.classistag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherwiseTag extends SimpleTagSupport{
	
	
	public void doTag() throws JspException, IOException {
		JspTag tag=this.getParent();
		if(!(tag instanceof ChooseTag)) {
			throw new JspTagException("OUT_OF_CHOOSE2");
		}
		ChooseTag chooseTag=(ChooseTag)tag;
		if(!chooseTag.isFlag()) {
			this.getJspBody().invoke(null);
			chooseTag.setFlag(true);
		}
		
	}
	
}
