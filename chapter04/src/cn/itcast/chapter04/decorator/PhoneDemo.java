package cn.itcast.chapter04.decorator;

interface Phone{
	void action();
}
class Zuk implements Phone{
	public void action() {
		System.out.println("����Zuk_edge�ֻ�����");
	}
	public void call() {
		System.out.println("����zuk_��绰����");
	}
}
class Non_SmartPhone implements Phone{
	public void action() {
		System.out.println("���Դ�绰");
	}
}
class SmartPhone implements Phone{
	private Phone nonSmartPhone;
	public SmartPhone(Phone nonSmartPhone) {
		this.nonSmartPhone=nonSmartPhone;
	}
	public void action() {
		nonSmartPhone.action();
		System.out.println("�������ŭ��С��");
	}
}
public class PhoneDemo {
	public static void main(String[] args) {
		Phone nPhone=new Non_SmartPhone();
		System.out.println("----�ֻ�װ��ǰ-----");
		nPhone.action();
		Phone smartPhone=new SmartPhone(nPhone);
		System.out.println("----�ֻ�װ�κ�-------");
		smartPhone.action();
		System.out.println("------�ֽ���---------");
		Phone zuk=new Zuk();
		zuk.action();
	
		Zuk zuk2=new Zuk();
		zuk2.call();
	}
}

