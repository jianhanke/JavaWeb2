package chapter10;

import java.util.*;

public class LocalExam {
	public static void  main(String[] args) {
		Locale locale=new Locale("en","US");
		System.out.println("美国地区的ISO语言代码:"+locale.getLanguage());
		System.out.println("美国地区的ISO国家代码"+locale.getCountry());
		
		System.out.println("显示本地用户的语言代码:"+locale.getDisplayLanguage());
		System.out.println("显示给美国用户的语言代码:"+locale.getDisplayLanguage(locale));
		
		System.out.println("显示给本地用户的信息代码:"+locale.getDisplayName());
		System.out.println("显示个美国用户的信息代码:"+locale.getDisplayName(locale) );
		
	}
}
