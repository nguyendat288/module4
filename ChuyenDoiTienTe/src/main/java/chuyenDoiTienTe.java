import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns="/money")
public class chuyenDoiTienTe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float rate =Float.parseFloat(req.getParameter("VND"));
        float usd =Float.parseFloat(req.getParameter("USD"));
        float result= rate*usd;
        PrintWriter writer= resp.getWriter();
        writer.println("Result = "+result+" VND");
        writer.println("xin chào mọi người");
    }
}
