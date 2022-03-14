package CRUD;

import java.util.ArrayList;
import java.util.Iterator;

import entity.Teacher;

public class TeacherCRUD {
	ArrayList<Teacher> teacherList = new ArrayList<>();

	public int createTeacherDetails(Teacher s) {
		teacherList.add(s);
		return s.getId();
	}

	public ArrayList<Teacher> getAllTeacherDetails() {
		return teacherList;
	}

	public Teacher getTeacherdetails(int i) {
		Iterator<Teacher> itr = teacherList.iterator();
		while (itr.hasNext()) {
			Teacher s = itr.next();
			if (s.getId() == i) {
				return s;
			}
		}
		return null;

	}

	// update student details
	public int updateTeacherDetails(Teacher teacher) {
		Iterator<Teacher> itr = teacherList.iterator();
		int count = 0;
		while (itr.hasNext()) {
			Teacher s1 = itr.next();
			if (s1.getId() == teacher.getId()) {
				teacherList.set(count, teacher);
				return teacher.getId();
			}
			count++;
		}
		return 0;

	}

	public int deleteTeacherDetails(int id) {
		Iterator<Teacher> itr = teacherList.iterator();
		while (itr.hasNext()) {
			Teacher s = itr.next();
			if (s.getId() == id) {
				teacherList.remove(s);
				return s.getId();
			}
		}
		return 0;
	}

}
