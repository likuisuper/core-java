package tech.aistar.day08.relation.exercise;

public class Animal {
	private String desc;

	public Animal() {
		System.out.println("==1==");
		this.desc = getDesc();
	}

	public String getDesc() {
		System.out.println("打死不走...");
		return "Animal";
	}

	public String toString() {
		System.out.println("==4==");
		return desc;
	}
}
