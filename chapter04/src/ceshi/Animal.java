package ceshi;

public class Animal {
	public static void main(String[] args) {
		Dog dog=new Dog("Tom");
		dog.shout();
	}
	public Animal(String name) {
		System.out.println("这是所有动物的初始化"+name);
	}
	public void shout() {
		System.out.println("所有动物的叫声");
	}
}
class Dog  extends Animal{
	public String name;

	public Dog(String name) {
		super(name);
		this.name=name;
	}
	
	public void shout() {
		System.out.println("汪汪汪"+name);
	}
}

