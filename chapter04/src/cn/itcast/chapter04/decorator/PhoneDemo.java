package cn.itcast.chapter04.decorator;

interface Phone{
	void action();
}
class Zuk implements Phone{
	public void action() {
		System.out.println("这是Zuk_edge手机配置");
	}
	public void call() {
		System.out.println("这是zuk_打电话功能");
	}
}
class Non_SmartPhone implements Phone{
	public void action() {
		System.out.println("可以打电话");
	}
}
class SmartPhone implements Phone{
	private Phone nonSmartPhone;
	public SmartPhone(Phone nonSmartPhone) {
		this.nonSmartPhone=nonSmartPhone;
	}
	public void action() {
		nonSmartPhone.action();
		System.out.println("可以玩愤怒的小鸟");
	}
}
public class PhoneDemo {
	public static void main(String[] args) {
		Phone nPhone=new Non_SmartPhone();
		System.out.println("----手机装饰前-----");
		nPhone.action();
		Phone smartPhone=new SmartPhone(nPhone);
		System.out.println("----手机装饰后-------");
		smartPhone.action();
		System.out.println("------分界线---------");
		Phone zuk=new Zuk();
		zuk.action();
	
		Zuk zuk2=new Zuk();
		zuk2.call();
	}
}

