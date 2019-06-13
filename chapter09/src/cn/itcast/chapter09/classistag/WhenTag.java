package cn.itcast.chapter09.classistag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport{
	
	private boolean test;
	public void setTest(boolean test) {
		this.test=test;
	}
	public void doTag() throws JspException, IOException {
		JspTag tag=this.getParent();
		if(!(tag instanceof ChooseTag)) {
			throw new JspTagException("OUT_OF_CHOOSE");
		}
		ChooseTag chooseTag=(ChooseTag) tag;
		if(test&&!chooseTag.isFlag()) {
			this.getJspBody().invoke(null);
			chooseTag.setFlag(true);
		}
	}
}
