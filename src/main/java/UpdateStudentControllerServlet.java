import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updatestudent")
public class UpdateStudentControllerServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        request.setAttribute("id",id);
        request.setAttribute("username", username);
        request.getRequestDispatcher("views/update-student-form.jsp").forward(request, response);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("views/update-student-form.jsp");
//        dispatcher.forward(request, response);
    }


}
