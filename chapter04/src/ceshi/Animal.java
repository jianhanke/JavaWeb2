package ceshi;

public class Animal {
	public static void main(String[] args) {
		Dog dog=new Dog("Tom");
		dog.shout();
	}
	public Animal(String name) {
		System.out.println("�������ж���ĳ�ʼ��"+name);
	}
	public void shout() {
		System.out.println("���ж���Ľ���");
	}
}
class Dog  extends Animal{
	public String name;

	public Dog(String name) {
		super(name);
		this.name=name;
	}
	
	public void shout() {
		System.out.println("������"+name);
	}
}

