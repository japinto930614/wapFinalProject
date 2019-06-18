import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
//        System.out.println("before destroying:"+session.getAttribute("user").toString());
        if(session!=null){
            session.invalidate();
        }

        //resp.sendRedirect("index.jsp");
        resp.sendRedirect("/");
    }
}
