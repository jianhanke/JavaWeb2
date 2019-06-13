package chapter10;

import java.util.Locale;
import java.util.ResourceBundle;

public class MyResourceBundle {

	public static void main(String[] args) {
		Locale locale=Locale.US;
		
		ResourceBundle myresouces=ResourceBundle.getBundle("MyResources",locale);
		
		String key=myresouces.getString("key");
		String value=myresouces.getString("value");
		
		System.out.println("key:"+key);
		System.out.println("value"+value);
	}
	
}
