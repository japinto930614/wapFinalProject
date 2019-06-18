import com.google.gson.Gson;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentDbUtil studentDbUtil=new StudentDbUtil();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        try {
            String term = request.getParameter("term");
            System.out.println("Data from ajax call " + term);
            List<User> students = studentDbUtil.getStudents();
            List<String> list = students.stream()
                    .map(x -> x.getUsername()).collect(Collectors.toList());

            String searchList = new Gson().toJson(list);
            response.getWriter().write(searchList);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
