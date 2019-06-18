import models.Type;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/vote")
public class VotingServlet extends HttpServlet {

    VotingDbUtil votingDbUtil;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext allVotesContext= request.getServletContext();
        votingDbUtil =(VotingDbUtil) allVotesContext.getAttribute("allVotes");

        String student = request.getParameter("student");
        String staff = request.getParameter("staff");
        String faculty = request.getParameter("faculty");

        // create a new student object
        votingDbUtil.voteStudent(student);
        votingDbUtil.voteFaculty(faculty);
        votingDbUtil.voteStaff(staff);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome");
        dispatcher.forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
