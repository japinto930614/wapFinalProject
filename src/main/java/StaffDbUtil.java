import models.Staff;
import models.Type;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class StaffDbUtil {

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private List<User> users;



	public List<User> getStaff() throws Exception {

		List<User> staff = new ArrayList<>();
		for(User user:users){
			if(((user.getType().equals(Type.Staff)))) {
				staff.add(user);
			}
		}
		return staff;
	}


	public void addStaff(User theStaff) throws Exception {
		if(!(users.contains(theStaff)))
		users.add(theStaff);
	}

	public User getStaff(String theStaffId)  {

		for(User staff:users){
			if(theStaffId.equals(staff.getUsername()))return staff;
		}

		return null;
	}

	public void updateStaff(String id,String password)  {

		for(User staff:users){
			if(id.equals(staff.getId())){
				staff.setPassword(password);
			}
		}

	}

	public void deleteStaff(String theStaffId)  {

		for(User staff:users){
			if(theStaffId.equals(staff.getUsername())){
				int i=users.indexOf(staff);
				users.remove(i);
			}
		}

	}
}















