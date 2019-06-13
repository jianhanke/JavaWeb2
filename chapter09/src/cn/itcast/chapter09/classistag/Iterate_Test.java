package cn.itcast.chapter09.classistag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Iterate_Test extends TagSupport{
	
	private int num;
	public void setNum(int num) {
		this.num=num;
	}
	
	public int doStartTag()throws JspException{
		num++;
		System.out.println("doStartTag:"+num);
		return Tag.EVAL_BODY_INCLUDE;
	}
	public int doAfterBody() throws JspException{
		num++;
		if(num<=5) {
			System.out.println("doAfterBody<=Îå:"+num);
			return EVAL_BODY_AGAIN;
		}else {
			System.out.println("doAfterBody>Îå:"+num);
			return SKIP_BODY;
		}
	}
	
}
