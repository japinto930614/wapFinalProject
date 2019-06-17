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
 * Servlet implementation class StaffControllerServlet
 */
@WebServlet("/staff")
public class StaffControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StaffDbUtil staffDbUtil=new StaffDbUtil();
	private List<User>users=new ArrayList<>();
	

	
	@Override
	public void init() throws ServletException {
		super.init();

	}

	private void allStaffs(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		ServletContext allUsersContext= req.getServletContext();
		if(allUsersContext==null){
			resp.sendRedirect("/");
		}
		users=(List<User>) allUsersContext.getAttribute("allUsers");
		staffDbUtil=new StaffDbUtil();
		staffDbUtil.setUsers(users);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		allStaffs(request,response);
		if(users.size()==0){
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing Staffs
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listStaffs(request, response);
				break;
				
			case "ADD":
				addStaff(request, response);
				break;
				
			case "LOAD":
				loadStaff(request, response);
				break;
				
			case "UPDATE":
				updateStaff(request, response);
				break;
			
			case "DELETE":
				deleteStaff(request, response);
				break;
				
			default:
				listStaffs(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteStaff(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read Staff id from form data
		String theStaffId = request.getParameter("staffId");
		
		// delete Staff from database
		staffDbUtil.deleteStaff(theStaffId);
		
		// send them back to "list Staffs" page
		listStaffs(request, response);
	}

	private void updateStaff(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read Staff info from form data
		int id = Integer.parseInt(request.getParameter("staffId"));

		String password = request.getParameter("password");
		
		// create a new Staff object

		
		// perform update on database
		staffDbUtil.updateStaff(""+id,password);
		
		// send them back to the "list Staffs" page
		listStaffs(request, response);
		
	}

	private void loadStaff(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read Staff id from form data
		String theStaffId = request.getParameter("staffId");
		
		// get Staff from database (db util)
		//Staff theStaff = StaffDbUtil.getStaff(theStaffId);
		
		// place Staff in the request attribute
		//request.setAttribute("THE_Staff", theStaff);
		
		// send to jsp page: update-Staff-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-staff-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addStaff(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read Staff info from form data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type=request.getParameter("type");
		Type t=Type.valueOf(type);
		String id=""+users.size()+1;
		//String email = request.getParameter("email");
		
		// create a new Staff object
		User theStaff = new User(id, username, password,t);
		

		listStaffs(request, response);
	}

	private void listStaffs(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
//		ServletContext allUsersContext=request.getServletContext();
//		users=(List<User>)allUsersContext.getAttribute("allUsers");
		// get Staffs from db util
		List<User> staffs = staffDbUtil.getStaff();
		
		// add Staffs to the request
		request.setAttribute("STAFF_LIST", staffs);
		HttpSession session= (HttpSession) request.getSession();
				session.setAttribute("AllStaffs",staffs);
				
		// send to JSP page (view)
	RequestDispatcher dispatcher = request.getRequestDispatcher("views/list-staffs.jsp");
	dispatcher.forward(request, response);

	}


}













