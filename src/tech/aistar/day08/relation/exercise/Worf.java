package tech.aistar.day08.relation.exercise;

public class Worf extends Animal {
	private String name;
	private double weight;

	public Worf(String name, double weight) {
		//super();//优先走父类Animal的空参构造
		System.out.println("==3==");
		this.name = name;
		this.weight = weight;
	}


	public String getDesc() {
		System.out.println("===2==");
		return "Worf:" + name + "体重:" + weight;
	}

	public static void main(String[] args) {
//		Worf:null体重:0.0
		System.out.println
				//打印对象就是找toString()
				(new Worf("羊", 10));
	}
}
