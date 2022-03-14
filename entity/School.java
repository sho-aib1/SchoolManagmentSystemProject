package entity;

public class School {
	private int SchoolID;

	private String name;
	private String yearofOpening;
	private String medium;

	@Override
	public String toString() {
		return "School [ name=" + name + ", yearofOpening=" + yearofOpening + ", medium=" + medium + ", SchoolID="
				+ SchoolID + "]";
	}

	public int getSchoolID() {
		return SchoolID;
	}

	public void setSchoolID(int schoolID) {
		SchoolID = schoolID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYearofOpening() {
		return yearofOpening;
	}

	public void setYearofOpening(String yearofOpening) {
		this.yearofOpening = yearofOpening;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public School()

	{

	}

	public School(String name, String year, String medium, int SchoolID) {

		this.name = name;
		this.yearofOpening = year;
		this.medium = medium;
		this.SchoolID = SchoolID;
	}

}
