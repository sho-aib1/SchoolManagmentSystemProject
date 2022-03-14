package Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import CRUD.SchoolCRUD;
import CRUD.StudentCRUD;
import CRUD.SuppoertiveStaffCRUD;
import CRUD.TeacherCRUD;
import entity.School;
import entity.Student;
import entity.SupportingStaff;
import entity.Teacher;

public class Main {
	
	
	static SchoolCRUD schoolCRUD = new SchoolCRUD();
	static StudentCRUD studentCRUD = new StudentCRUD();
	static TeacherCRUD teacherCRUD = new TeacherCRUD();
	static SuppoertiveStaffCRUD staffCRUD = new SuppoertiveStaffCRUD();

	public static void main(String[] args) {

		Main m = new Main();
		System.out.println("Welcome to School Managment Services. We are providing following functionality ");
		Scanner sc = new Scanner(System.in);
		int childchoice = 0;
		int parentchoice = 0;
		do {
			System.out.println("===============================================================");
			System.out.println("Enter 1 to perform student related operation ");
			System.out.println("Enter 2 to perform SupportiveStaff related operation ");
			System.out.println("Enter 3 to perform Teacher related operation ");
			System.out.println("Enter 4 to perform School related operation ");
			System.out.println("Enter 5 to Exit the Program ");
			System.out.println("===============================================================");
			parentchoice = sc.nextInt();
			switch (parentchoice) {
			case 1:
				System.out.println("===============================================================");
				System.out.println(
						"Enter 1 to create Student \n Enter 2 to get List of Students present at a time \n Enter 3 to get Student based on roll no  \n Enter 4 to update Student Details \n Enter 5 to delete Student Details \n Enter 6 to go back to Main menu");

				childchoice = sc.nextInt();
				try {
					m.studentTask(childchoice, sc);
				} catch (StudentStandardException e) {
					System.out.println("=========================================");
					System.out.println("An error Occured: "+e.getMessage());
					System.out.println("=========================================");
				}
				break;
			case 2:
				System.out.println("===============================================================");
				System.out.println(
						"Enter 1 to create STaff Worker \n Enter 2 to get List of STaff Worke present at a time \n Enter 3 to get STaff Worker based on ID  \n Enter 4 to update Teacher Details \n Enter 5 to delete Staff Details \n Enter 6 to go back to Main menu");

				childchoice = sc.nextInt();
				m.StaffTask(childchoice,sc);
				break;
			case 3:
			
				System.out.println("===============================================================");
				System.out.println(
						"Enter 1 to create Teacher \n Enter 2 to get List of Teacher present at a time \n Enter 3 to get Teacher based on ID  \n Enter 4 to update Teacher Details \n Enter 5 to delete Teacher Details \n Enter 6 to go back to Main menu");

				childchoice = sc.nextInt();
				m.TeacherTask(childchoice,sc);
			break;
			case 4:
				
				System.out.println("===============================================================");
				System.out.println(
						"Enter 1 to create School \n Enter 2 to get List of School present at a time \n Enter 3 to get School based on ID  \n Enter 4 to update School Details \n Enter 5 to delete School Details \n Enter 6 to go back to Main menu");

				childchoice = sc.nextInt();
				try {
					m.SchoolTask(childchoice,sc);
				} catch (YearOfOpeningException e) {
					System.out.println("=========================================");
					System.out.println("An error Occured: "+e.getMessage());
					System.out.println("=========================================");
				}
			break;
			case 5:
				System.out.println("=========================================================");
				System.out.println("Thank You For Using Our Services. Please Visit Again");
				System.out.println("=========================================================");
				break;

			}

		} while (parentchoice != 5);

	}


	private void SchoolTask(int childchoice, Scanner sc) throws YearOfOpeningException {
		if (childchoice == 1) {
			School school=getSchoolDetailsFromUser(sc);
			System.out.println("SupportiveStaff is Created and Added to list with "+schoolCRUD.createSchoolDetails(school)+ " ID");
		} else if (childchoice == 2) {
			ArrayList<School> schoolList=schoolCRUD.getAllSchoolDetails();
			schoolList.stream().forEach((list)-> System.out.println(list));
		} else if (childchoice == 3) {
			System.out.println("Please enter Id to get School Details");
			int ID = sc.nextInt();
			School sch=schoolCRUD.getschooltdetailsById(ID);
			if (sch != null) {
				System.out.println(sch);
			} else
				System.out.println("No Details Found");
		} else if (childchoice == 4) {
			SchoolTask(2, sc);
			System.out.println("Enter School Id for which you want to update the details");
			int id1 = sc.nextInt();
			School update = getSchoolDetailsFromUser(sc);
			update.setSchoolID(id1);
			int schoolid = schoolCRUD.updateSchoolDetails(update);
			if (schoolid > 0) {
				System.out.println("Update School Id no" + schoolid);
			} else {
				System.out.println("no Records Found");
			}
			
		} else if (childchoice == 5) {
			SchoolTask(2, sc);
			System.out.println("Enter School Id No for which you want to delete the details");
			int id2 = sc.nextInt();
			int deleteschoolid =schoolCRUD.deleteSchoolDetails(id2);
			if (deleteschoolid > 0) {
				System.out.println("School Data Deleted with this Id " + deleteschoolid);
			
			} else {
				System.out.println("No details Found with this Id ");
			}
		} else if (childchoice == 6) {
			System.out.println("=========================================================");
			System.out.println("You are navigating to main menu");
			System.out.println("=========================================================");
		}


		
	}


	private School getSchoolDetailsFromUser(Scanner sc) throws YearOfOpeningException {
		System.out.println("Please Enter following User Details..");
		System.out.println("Please enter name ");
		String name = sc.next();
		System.out.println("Please enter Year of Opening");
		String year = sc.next();
		boolean isvalid=Pattern.matches("\\d+", year);
		if(isvalid==false)
		{
			throw new YearOfOpeningException("Year of Opening must be in Digits");
		}
		System.out.println("Please Enter Medium ");
		String medium = sc.next();
		System.out.println("Please enter School ID");
		int id = sc.nextInt();
		
		School school = new School(name, year, medium, id); 
		return school;// 
	}


	private void StaffTask(int childchoice, Scanner sc) {
		if (childchoice == 1) {
			SupportingStaff SupportiveStaff=getSupportiveStaffDetailsFromUser(sc);
			System.out.println("SupportiveStaff is Created and Added to list with "+staffCRUD.createSupportingStaffDetails(SupportiveStaff)+ "ID");
		} else if (childchoice == 2) {
			ArrayList<SupportingStaff> SupportiveStaffList=staffCRUD.getAllSupportiveStaffDetails();
			SupportiveStaffList.stream().forEach((SupportiveStaffFromList)-> System.out.println(SupportiveStaffFromList));
		} else if (childchoice == 3) {
			System.out.println("Please enter Id to get SupportiveStaff Details");
			int ID = sc.nextInt();
			SupportingStaff stf=staffCRUD.getSupportingStaffdetails(ID);
			if (stf != null) {
				System.out.println(stf);
			} else
				System.out.println("No Details Found");
		} else if (childchoice == 4) {
			StaffTask(2, sc);
			System.out.println("Enter SupportiveStaffId for which you want to update the details");
			int id1 = sc.nextInt();
			SupportingStaff updateddata = getSupportiveStaffDetailsFromUser(sc);
			updateddata.setId(id1);
			int updateSupportiveStaffid = staffCRUD.updateSupportingStaffDetails(updateddata);
			if (updateSupportiveStaffid > 0) {
				System.out.println("Update staff Id" + updateSupportiveStaffid);
			} else {
				System.out.println("no Records Found");
			}
			
		} else if (childchoice == 5) {
			StaffTask(2, sc);
			System.out.println("Enter roll Noroll No for which you want to delete the details");
			int id2 = sc.nextInt();
			int deleteSupportiveStaffid =staffCRUD.deleteSupportingStaffDetails(id2);
			if (deleteSupportiveStaffid > 0) {
				System.out.println("Staff Data Deleted with this Id " + deleteSupportiveStaffid);
			
			} else {
				System.out.println("No details Found with this Id ");
			}
		} else if (childchoice == 6) {
			System.out.println("=========================================================");
			System.out.println("You are navigating to main menu");
			System.out.println("=========================================================");
		}


		
	}


	private SupportingStaff getSupportiveStaffDetailsFromUser(Scanner sc) {
		System.out.println("Please Enter following User Details..");
		System.out.println("Please enter name ");
		String name = sc.next();
		System.out.println("Please enter age");
		int age = sc.nextInt();
		System.out.println("Please Enter address ");
		String address = sc.next();
		System.out.println("Please enter Your Staff ID");
		int id = sc.nextInt();
		System.out.println("Please enter Domain");
		String dom = sc.next();
		SupportingStaff staff = new SupportingStaff(name, age, address, id,dom);
		return staff;// 
	}


	private  void TeacherTask(int childchoice, Scanner sc) {
		if (childchoice == 1) {
			Teacher teacher=getTeacherDetailsFromUser(sc);
			System.out.println("Teacher is Created and Added to list with "+teacherCRUD.createTeacherDetails(teacher)+" Id");
		} else if (childchoice == 2) {
			ArrayList<Teacher> teacherList=teacherCRUD.getAllTeacherDetails();
			teacherList.stream().forEach((TeacherFromList)-> System.out.println(TeacherFromList));
		} else if (childchoice == 3) {
			System.out.println("Please enter Id to get Teacher Details");
			int ID = sc.nextInt();
			Teacher teach=teacherCRUD.getTeacherdetails(ID);
			if (teach != null) {
				System.out.println(teach);
			} else
				System.out.println("No Details Found");
		} else if (childchoice == 4) {
			TeacherTask(2, sc);
			System.out.println("Enter TeacherId for which you want to update the details");
			int id1 = sc.nextInt();
			Teacher updateddata = getTeacherDetailsFromUser(sc);
			updateddata.setId(id1);
			int updateTeacherid = teacherCRUD.updateTeacherDetails(updateddata);
			if (updateTeacherid > 0) {
				System.out.println("Update Student's Roll no" + updateTeacherid);
			} else {
				System.out.println("no Records Found");
			}
			
		} else if (childchoice == 5) {
			TeacherTask(2, sc);
			System.out.println("Enter roll Noroll No for which you want to delete the details");
			int id2 = sc.nextInt();
			int deleteteacherid =teacherCRUD.deleteTeacherDetails(id2);
			if (deleteteacherid > 0) {
				System.out.println("Student Data Deleted with this roll no " + deleteteacherid);
			
			} else {
				System.out.println("No details Found with this Roll no ");
			}
		} else if (childchoice == 6) {
			System.out.println("=========================================================");
			System.out.println("You are navigating to main menu");
			System.out.println("=========================================================");
		}


	}

	



	private Teacher getTeacherDetailsFromUser(Scanner sc) {
		System.out.println("Please Enter following User Details..");
		System.out.println("Please enter name ");
		String name = sc.next();
		System.out.println("Please enter age");
		int age = sc.nextInt();
		System.out.println("Please Enter address ");
		String address = sc.next();
		System.out.println("Please enter Your Teacher ID");
		int id = sc.nextInt();
		System.out.println("Please enter Your Qualification (enter in comma seperated mode");
		String qualification = sc.next();
		System.out.println("Please enter Teacher Subjects (enter in comma seperared mode ");
		String subject = sc.next();
		Teacher teacher = new Teacher(name, age, address, id,qualification,subject);
		return teacher;// 
	
	}

	private void studentTask(int childchoice, Scanner sc) throws StudentStandardException {

		if (childchoice==1) {
		
			Student student = getStudentDetailsfromUser(sc);
			System.out.println(
					"Student is Created and added to List with " + studentCRUD.createStudent(student) + " Roll no");
		}
		else if (childchoice==2) {
			ArrayList<Student> studentList = studentCRUD.getAllStudentDetails();
			studentList.stream().forEach((StudentFromList) -> System.out.println(StudentFromList));

		}
			
		
		else if (childchoice==3) {
			System.out.println("Please enter roll no to get Student Details");
			int rno = sc.nextInt();
			Student searchStudent = studentCRUD.getstudentdetailsByRoll(rno);
			

			if (searchStudent != null) {
				System.out.println(searchStudent);
			} else
				System.out.println("No Details Found");

		}
		else if (childchoice==4) {
			studentTask(2, sc);
			System.out.println("Enter roll no for which you want to update the details");
			int rno1 = sc.nextInt();
			Student updateddata = getStudentDetailsfromUser(sc);
			updateddata.setRollno(rno1);
			int updateStudentRollno = studentCRUD.updateStudentDetails(updateddata);

			if (updateStudentRollno > 0) {
				System.out.println("Update Student's Roll no" + updateStudentRollno);
			} else {
				System.out.println("no Records Found");
			}

		}
		else if (childchoice==5) {
			studentTask(2, sc);
			System.out.println("Enter roll No for which you want to delete the details");
			int rno2 = sc.nextInt();
			int deleteStudentRollno = studentCRUD.deleteStudentDetails(rno2);

			if (deleteStudentRollno > 0) {
				System.out.println("Student Data Deleted with this roll no " + deleteStudentRollno);

			} else {
				System.out.println("No details Found with this Roll no ");
			}
			

	}
	else if (childchoice==6) {
			System.out.println("=========================================================");
			System.out.println("You are navigating to main menu");
			System.out.println("=========================================================");
		}

	}

	private Student getStudentDetailsfromUser(Scanner sc) throws StudentStandardException {
		System.out.println("Please Enter following User Details..");
		System.out.println("Please enter name ");
		String name = sc.next();
		System.out.println("Please enter age");
		int age = sc.nextInt();
		System.out.println("Please Enter address ");
		String address = sc.next();
		System.out.println("Please enter Your Roll No");
		int rollno = sc.nextInt();
		System.out.println("Please enter Your Standard");
		int standard = sc.nextInt();
		if(standard<0 || standard>12)
		{
			throw new StudentStandardException("Standard must be between 0 to 12");
		}
		System.out.println("Please enter Your Area Of Interest ");
		String areaofinterest = sc.next();
		Student student = new Student(name, age, address, rollno, standard, areaofinterest);
		return student;
		
	}
	
	
}
