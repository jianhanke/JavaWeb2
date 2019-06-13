package cn.itcast.chapter07.servlet;

public class Exam {
	static{
		System.out.println("tld文件初始化测试");
	}
	
	public static String reverse(String message) {
		
		 return new StringBuilder(message).reverse().toString();  

	}
}
