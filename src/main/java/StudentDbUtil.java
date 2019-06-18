import models.Type;
import models.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentDbUtil {

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private List<User> users;


	
	public List<User> getStudents() throws Exception {
		
		List<User> students = new ArrayList<>();
		for(User user:users){
			if(((user.getType().equals(Type.Student)))) {
				students.add(user);
			}
		}
		return students;
	}


	public void addStudent(User theStudent) throws Exception {
		if(!(users.contains(theStudent)))
		users.add(theStudent);
	}

	public User getStudent(String theStudentId)  {

		for(User student:users){
			if(theStudentId.equals(student.getUsername()))return student;
		}

		return null;
	}

	public void updateStudent(String id,String password)  {

		for(User student:users){
			if(id.equals(student.getId())){
				student.setPassword(password);
			}
		}

	}

	public void deleteStudent(String theStudentId)  {

//		for(User student:users){
//			if(theStudentId.equals(student.getId())){
//				int i=users.indexOf(student);
//				users.remove(i);
//			}
//		}


		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
			User value = iterator.next();

			if(theStudentId.equals(value.getId())){
				int i=users.indexOf(value);
				iterator.remove();
			}
		}

	}

	public List<String> search(String keyword) {
		List<String> names = new ArrayList<String>();
		for (User user : users) {
			if (user.getUsername().toLowerCase().contains(keyword.toLowerCase())) {
				names.add(user.getUsername());
			}
		}
		return names;
	}
}















