package cn.itcast.chapter09.classistag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Examforeach extends SimpleTagSupport {
	private Object object;
	private String begin;
	private String step;
	private String var;
	private String end;
	private String status_name;
	private Varstatus varStautus;
	
	public void setVarStatus(String name) {
		this.status_name=name;
		this.varStautus=new Varstatus(name);
	}
	public void setBegin(String begin) {
		this.begin=begin;
	}
	public void setStep(String step) {
		this.step=step;
	}
	public void setVar(String var) {
		this.var=var;
	}
	public void setObject(Object object) {
		this.object=object;
	}
	public void setEnd(String end) {
		this.end=end;
	}
	
	
	public void doTag() throws IOException, JspException {
		
		
		if(object.getClass().isArray() ) { //判断是否为数组
			this.doArray();
			return ;
		}else if(object instanceof Map ){  //是否为Map
			this.doMap();
			return;
	    }else if(object instanceof ArrayList&& varStautus!=null) {
	    	this.doArrayStaus();
	    	return;
	    }else if(object instanceof ArrayList){
	    	this.doList();
	    	return;
	    }
		
	}
	public Object[] transArray(Object object) {
		
		int len=Array.getLength(object);
		Object[] objects=new Object[len];
		for(int i=0;i<len;i++) {
			objects[i]=Array.get(object, i);
		}
		return objects;
	}
	public void doArray() throws JspException, IOException {
		int begin_num=0;
		int step_num=1;
	PageContext context=(PageContext) this.getJspContext();
	JspWriter out=context.getOut();
	JspFragment jf =this.getJspBody();
	Object[] objects= transArray(object);
	if(begin!=null) {
		begin_num=Integer.valueOf(begin);
	}
	if(step!=null) {
		step_num=Integer.valueOf(step);
	}
	for(int i=begin_num;i<objects.length;i=i+step_num) {
		if(var!=null) {
			context.setAttribute(var, objects[i]);
			jf.invoke(null);
		}else {
			out.println(objects[i]);
		}
	}
	}
	public void doMap() throws JspException, IOException {
		PageContext context=(PageContext) this.getJspContext();
		JspWriter out=context.getOut();
		JspFragment jf =this.getJspBody();
		Map map=(Map) object;
		int len=map.size();
		for(Object key: map.keySet() ) {
			if(var!=null) {
				context.setAttribute(var, map.get(key));
				jf.invoke(null);
			}else {
				out.println(map.get(key));
			}
		}
	}
	public void doList() throws IOException, JspException {
		int begin_num=0;
		int step_num=1;
		int end_num;
		if(begin!=null) {
			begin_num=Integer.valueOf(begin);
		}
		if(step!=null) {
			step_num=Integer.valueOf(step);
		}
		
		PageContext context=(PageContext) this.getJspContext();
		JspWriter out=context.getOut();
		JspFragment jf =this.getJspBody();
		List list=(List)object;
		end_num=list.size();
		if(end!=null) {
			end_num=Integer.valueOf(end);
		}
		for(int i=begin_num;i<end_num;i=i+step_num) {
			if(var!=null) {
				context.setAttribute(var,list.get(i));
				jf.invoke(null);
			}else {
				out.print(list.get(i)+" ");
			}
		}
		
	}
	public void doArrayStaus() throws JspException, IOException {
		PageContext context=(PageContext) this.getJspContext();
		JspWriter out=context.getOut();
		JspFragment jf =this.getJspBody();
		List list=(List)object;
		for(int i=0;i<list.size();i++) {
			varStautus.setCount(i+1);
			varStautus.setIndex(i);
			if(i==0) {
				varStautus.setFirst(true);
			}else {
				varStautus.setFirst(false);
			}if(i==list.size()-1) {
				varStautus.setLast(true);
			}else {
				varStautus.setLast(false);
			}
			context.setAttribute(var, list.get(i));
			context.setAttribute(status_name, varStautus);
			jf.invoke(null);
		}
		
	}
	
	
}
