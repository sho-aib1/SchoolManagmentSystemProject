package CRUD;

import java.util.ArrayList;
import java.util.Iterator;

import entity.SupportingStaff;

public class SuppoertiveStaffCRUD {
	ArrayList<SupportingStaff> staffList = new ArrayList<>();

	public int createSupportingStaffDetails(SupportingStaff s) {
		staffList.add(s);
		return s.getId();
	}

	public ArrayList<SupportingStaff> getAllSupportiveStaffDetails() {
		return staffList;
	}

	public SupportingStaff getSupportingStaffdetails(int i) {
		Iterator<SupportingStaff> itr = staffList.iterator();
		while (itr.hasNext()) {
			SupportingStaff s = itr.next();
			if (s.getId() == i) {
				return s;
			}
		}
		return null;

	}

	// update student details
	public int updateSupportingStaffDetails(SupportingStaff staff) {
		Iterator<SupportingStaff> itr = staffList.iterator();
		int count = 0;
		while (itr.hasNext()) {
			SupportingStaff s1 = itr.next();
			if (s1.getId() == staff.getId()) {
				staffList.set(count, staff);
				return staff.getId();
			}
			count++;
		}
		return 0;

	}

	public int deleteSupportingStaffDetails(int id) {
		Iterator<SupportingStaff> itr = staffList.iterator();
		while (itr.hasNext()) {
			SupportingStaff s = itr.next();
			if (s.getId() == id) {
				staffList.remove(s);
				return s.getId();
			}
		}
		return 0;
	}

}
