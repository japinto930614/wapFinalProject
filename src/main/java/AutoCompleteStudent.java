import com.google.gson.Gson;
import models.Type;
import models.User;
import org.json.JSONArray;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@WebServlet("/autocompletestudent")
public class AutoCompleteStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;


    List<User> users = new ArrayList<>();




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext allUsersContext= request.getServletContext();
        if(allUsersContext==null){
            response.sendRedirect("/");
        }
        users=(List<User>) allUsersContext.getAttribute("allUsers");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        allUsersContext.setAttribute("allUsers",users);

        List<String> students = users.stream()
                .filter(x -> x.getType().equals(Type.Student)).map(x -> x.getUsername()).collect(Collectors.toList());



        JSONArray arrayObj=new JSONArray(students);



        out.println(arrayObj.toString());
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//Do something
    }

    @Override
    public void init() throws ServletException {

//        users.addAll(new UserRepository().getUsers());


        super.init();
    }

}
