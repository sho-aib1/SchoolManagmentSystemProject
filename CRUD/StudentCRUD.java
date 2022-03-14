package CRUD;

import java.util.ArrayList;
import java.util.Iterator;

import entity.Student;

public class StudentCRUD {
	ArrayList<Student> studentList = new ArrayList<>();

	public int createStudent(Student s) {
		studentList.add(s);
		return s.getRollno();
	}

	// get all students details

	public ArrayList<Student> getAllStudentDetails() {
		return studentList;
	}

//here we use iterator because we do not know about
	// the range of Students to fetch

	public Student getstudentdetailsByRoll(int i) {
		Iterator<Student> itr = studentList.iterator();
		while (itr.hasNext()) {
			Student s = itr.next();
			if (s.getRollno() == i) {
				return s;
			}
		}
		return null;

	}

	// update student details
	public int updateStudentDetails(Student student) {
		Iterator<Student> itr = studentList.iterator();
		int count = 0;
		while (itr.hasNext()) {
			Student s1 = itr.next();
			if (s1.getRollno() == student.getRollno()) {
				studentList.set(count, student);
				return student.getRollno();
			}
			count++;
		}
		return 0;

	}

	public int deleteStudentDetails(int rollno) {
		Iterator<Student> itr = studentList.iterator();
		while (itr.hasNext()) {
			Student s = itr.next();
			if (s.getRollno() == rollno) {
				studentList.remove(s);
				return s.getRollno();
			}
		}
		return 0;
	}

}
