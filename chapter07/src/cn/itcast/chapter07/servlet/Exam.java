package cn.itcast.chapter07.servlet;

public class Exam {
	static{
		System.out.println("tld�ļ���ʼ������");
	}
	
	public static String reverse(String message) {
		
		 return new StringBuilder(message).reverse().toString();  

	}
}
