package CRUD;

import java.util.ArrayList;
import java.util.Iterator;

import entity.School;

public class SchoolCRUD {
	public ArrayList<School> schoolList = new ArrayList<>();

	public int createSchoolDetails(School s) {
		schoolList.add(s);
		return s.getSchoolID();
	}

	public ArrayList<School> getAllSchoolDetails() {
		return schoolList;
	}

	public School getschooltdetailsById(int schoolid) {
		Iterator<School> itr = schoolList.iterator();
		while (itr.hasNext()) {
			School s = itr.next();
			if (s.getSchoolID() == schoolid) {
				return s;
			}
		}
		return null;

	}

	public int updateSchoolDetails(School s) {
		Iterator<School> itr = schoolList.iterator();
		int count = 0;
		while (itr.hasNext()) {
			School s1 = itr.next();
			if (s1.getSchoolID() == s.getSchoolID()) {
				schoolList.set(count, s);
				return s.getSchoolID();
			}
			count++;
		}
		return 0;

	}

	public int deleteSchoolDetails(int schoolid) {
		Iterator<School> itr = schoolList.iterator();
		while (itr.hasNext()) {

			School s = itr.next();
			if (s.getSchoolID() == schoolid) {
				schoolList.remove(s);
				return s.getSchoolID();
			}
		}
		return 0;
	}

	

}
