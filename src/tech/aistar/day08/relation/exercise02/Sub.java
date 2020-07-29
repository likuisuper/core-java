package tech.aistar.day08.relation.exercise02;

public class Sub extends Super {
	int j = 30;

	public Sub() {
		//super();
		System.out.println("----3---");
		print();
		j = 40;
	}

	public void print() {
		System.out.println("----2---4--");
		System.out.println(j);
	}

	public static void main(String[] args) {
		System.out.println(new Sub().j);
	}
}
