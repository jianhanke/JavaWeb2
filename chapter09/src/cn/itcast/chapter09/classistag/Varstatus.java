package cn.itcast.chapter09.classistag;

public class Varstatus {
	
	private int count;
	private int index;
	private boolean first;
	private boolean last;
	private String name;
	public Varstatus(String name){
		this.name=name;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean flag) {
		this.first = flag;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean flag) {
		this.last = flag;
	}	
}
