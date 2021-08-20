import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/translet")
public class TuDien extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        String search= req.getParameter("a");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        String result = dictionary.get(search);
        if(result != null ){
            writer.println(" word : "+search);
            writer.println("<br>");
            writer.println(" result : "+result);
        }else writer.println("Not  fount !!!");
    writer.println("</html>");
    }
}
