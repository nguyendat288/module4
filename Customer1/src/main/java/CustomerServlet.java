import customer.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/customer",""})
public class CustomerServlet extends HttpServlet {
  static   ArrayList<Customer> list=new ArrayList<>();
    static {
        list.add(new Customer("Mai Van Hoang ","1983-08-20","ha noi", "img/123.jpg"));
        list.add(new Customer("Nguyen Van Nam ","1983-08-21","bac giang", "img/anhden.jpg"));
        list.add(new Customer("Nguyen Thai Hoa","1983-08-22","nam dinh", "img/dangki.png"));
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// Thêm cặp key-value vào request để gửi
        req.setAttribute("ListCustomer",list);
 // RequestDispatcher điều hướng request và response sang 1 servlet or jsp khác.
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("ShowCustomer.jsp");
// chuyển tếp request và reponse đi cho thằng servlet khác sử lý.
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name= req.getParameter("name");
    String age= req.getParameter("age");
    String address= req.getParameter("address");
    String img= req.getParameter("img");
    list.add(new Customer(name,age,address,img));

        req.setAttribute("ListCustomer", list);
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("ShowCustomer.jsp");
        dispatcher.forward(req, resp);
    }
}
