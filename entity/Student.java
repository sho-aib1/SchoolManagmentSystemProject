package entity;

public class Student extends Person {

	public Student(String name, int age, String address, int rollno, int standard, String areaofInterest) {
		super(name, age, address);
		this.rollno = rollno;
		this.standard = standard;
		this.areaofInterest = areaofInterest;
	}

	int standard;
	String areaofInterest;
	int rollno;

	@Override
	public String toString() {
		System.out.println(super.toString());
		return "Student [standard=" + standard + ", areaofInterest=" + areaofInterest + ", rollno=" + rollno + "]";
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public String getAreaofInterest() {
		return areaofInterest;
	}

	public void setAreaofInterest(String areaofInterest) {
		this.areaofInterest = areaofInterest;
	}

	@Override
	public void work() {
		System.out.println("Works as a Student");
	}

}
