package cn.itcast.chapter08.entity;

public class Ceshi {

	public static void main(String[] args) {
		setNums(5);

	}
	
	public static void setNums(int nums) {
		
		while(nums>0) {
			nums--;
			System.out.println(nums);
		}
		System.out.println(nums);
	}
}
