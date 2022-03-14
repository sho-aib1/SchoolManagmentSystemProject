package entity;

public abstract class Person {
	private int age;
	private String address;
	private String name;

	public Person(String name, int age, String address) {

		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", address=" + address + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void printDetails(Person p) {
		System.out.println("Person Details");
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getAddress());

	}

	public abstract void work();

}
