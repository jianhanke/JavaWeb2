package cn.itcast.chapter07.servlet;

public class HTMLFilter {
	public static String filter(String message) {
		if(message==null) {
			return null;
		}
		char content[]=new char[(message.length())];
		message.getChars(0, message.length(), content, 0);
		StringBuffer result=new StringBuffer(content.length+50);
		for(int i=0;i<content.length;i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&bt;");
				break;
			case '&':
				result.append("$amp;");
				break;
			case '"':
				result.append("$quot;");
				break;
			default:
				result.append(content[i]);
		}
	}
		return (result.toString());
}
}
