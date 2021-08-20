import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
@WebServlet(name="DateServlet",urlPatterns = "/demo")
public class DateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String name=req.getParameter("name");
        String pass=req.getParameter("pass");
        writer.println("<html>");
        writer.println("Hom nay la ngay : ");

        Date today = new Date();

        writer.println("<h1>" + today + "</h1>");
        writer.println("CHuc moi nguoi 1 ngay vui ve <3 ");
        writer.println(pass+"  "+name);
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
