package cn.itcast.chapter09.classistag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Iterate extends TagSupport{
	private int num;
	
	public void setNum(int num) {
		this.num=num;
	}
	public int doStartTag() throws JspException {
		System.out.println(EVAL_BODY_INCLUDE+"one");
		return Tag.EVAL_BODY_INCLUDE;
	}
	public int doAfterBody()throws JspException{
		num--;
		System.out.println();
		if(num>0) {
			System.out.println(EVAL_BODY_AGAIN+"two");
			return EVAL_BODY_AGAIN;
		}
		else {
			System.out.println(SKIP_BODY+"three");
			return SKIP_BODY;
		}
	}
}
