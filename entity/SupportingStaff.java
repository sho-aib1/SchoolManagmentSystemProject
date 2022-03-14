package entity;

public class SupportingStaff extends Person {

	int id;
	String domain;

	public SupportingStaff(String name, int age, String address, int id, String domain) {
		super(name, age, address);
		this.id = id;
		this.domain = domain;

	}

	@Override
	public String toString() {
		System.out.println(super.toString());
		return "SupportingStaff [id=" + id + ", domain=" + domain + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public void work() {
		System.out.println("Works as Supportive Staff");

	}

}
