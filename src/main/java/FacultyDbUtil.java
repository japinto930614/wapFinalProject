import models.Type;
import models.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FacultyDbUtil {

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private List<User> users;


	
	public List<User> getFaculties() throws Exception {
		
		List<User> faculties = new ArrayList<>();
		for(User user:users){
			if(((user.getType().equals(Type.Faculty)))) {
				faculties.add(user);
			}
		}
		return faculties;
	}


	public void addFaculty(User theFaculty) throws Exception {
		if(!(users.contains(theFaculty)))
		users.add(theFaculty);
	}

	public User getFaculty(String theFacultyId)  {

		for(User faculty:users){
			if(theFacultyId.equals(faculty.getUsername()))return faculty;
		}

		return null;
	}

	public void updateFaculty(String id,String password)  {

		for(User faculty:users){
			if(id.equals(faculty.getId())){
				faculty.setPassword(password);
			}
		}

	}

	public void deleteFaculty(String theFacultyId)  {

//		for(User student:users){
//			if(theStudentId.equals(student.getId())){
//				int i=users.indexOf(student);
//				users.remove(i);
//			}
//		}


		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
			User value = iterator.next();

			if(theFacultyId.equals(value.getId())){
				int i=users.indexOf(value);
				iterator.remove();
			}
		}

	}
}















