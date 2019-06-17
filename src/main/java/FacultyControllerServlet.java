import models.Type;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class FacultyControllerServlet
 */
@WebServlet("/faculty")
public class FacultyControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FacultyDbUtil facultyDbUtil=new FacultyDbUtil();
	private List<User> users=new ArrayList<>();
	

	
	@Override
	public void init() throws ServletException {
		super.init();

	}

	private void allFaculties(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
		ServletContext allUsersContext= req.getServletContext();
		if(allUsersContext==null){
			resp.sendRedirect("/");
		}
		users=(List<User>) allUsersContext.getAttribute("allUsers");
		facultyDbUtil=new FacultyDbUtil();
		facultyDbUtil.setUsers(users);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		allFaculties(request,response);
		if(users.size()==0){
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing faculties
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listFaculties(request, response);
				break;
				
			case "ADD":
				addFaculty(request, response);
				break;
				
			case "LOAD":
				loadFaculty(request, response);
				break;
				
			case "UPDATE":
				updateFaculty(request, response);
				break;
			
			case "DELETE":
				deleteFaculty(request, response);
				break;
				
			default:
				listFaculties(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteFaculty(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read faculty id from form data
		String theFacultyId = request.getParameter("facultyId");
		
		// delete faculty from database
		facultyDbUtil.deleteFaculty(theFacultyId);
		
		// send them back to "list faculties" page
		listFaculties(request, response);
	}

	private void updateFaculty(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read faculty info from form data
		int id = Integer.parseInt(request.getParameter("id"));

		String password = request.getParameter("password");
		
		// create a new faculty object

		
		// perform update on database
		facultyDbUtil.updateFaculty(""+id,password);
		
		// send them back to the "list faculties" page
		listFaculties(request, response);
		
	}

	private void loadFaculty(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read faculty id from form data
		String theFacultyId = request.getParameter("facultyId");
		
		// get faculty from database (db util)
		//Faculty theStudent = studentDbUtil.getStudent(theStudentId);
		
		// place student in the request attribute
		//request.setAttribute("THE_STUDENT", theStudent);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-faculty-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addFaculty(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read faculty info from form data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type=request.getParameter("type");
		Type t=Type.valueOf(type);
		int newId = users.size()+1;
		String id= newId + "";
		//String email = request.getParameter("email");
		
		// create a new faculty object
		User theFaculty = new User(id, username, password,t);
		facultyDbUtil.addFaculty(theFaculty);

		listFaculties(request, response);
	}

	private void listFaculties(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
//		ServletContext allUsersContext=request.getServletContext();
//		users=(List<User>)allUsersContext.getAttribute("allUsers");
		// get faculties from db util
		List<User> faculties = facultyDbUtil.getFaculties();
		
		// add faculties to the request
		request.setAttribute("FACULTY_LIST", faculties);
		HttpSession session= (HttpSession) request.getSession();
				session.setAttribute("AllFaculties",faculties);
				
		// send to JSP page (view)
	RequestDispatcher dispatcher = request.getRequestDispatcher("views/list-faculties.jsp");
	dispatcher.forward(request, response);

	}


}













