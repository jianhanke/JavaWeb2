package chapter10;

import java.util.*;

public class LocalExam {
	public static void  main(String[] args) {
		Locale locale=new Locale("en","US");
		System.out.println("����������ISO���Դ���:"+locale.getLanguage());
		System.out.println("����������ISO���Ҵ���"+locale.getCountry());
		
		System.out.println("��ʾ�����û������Դ���:"+locale.getDisplayLanguage());
		System.out.println("��ʾ�������û������Դ���:"+locale.getDisplayLanguage(locale));
		
		System.out.println("��ʾ�������û�����Ϣ����:"+locale.getDisplayName());
		System.out.println("��ʾ�������û�����Ϣ����:"+locale.getDisplayName(locale) );
		
	}
}
