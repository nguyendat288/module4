import models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet(urlPatterns= {"/product"})
public class ProductServlet extends HttpServlet {
    ArrayList<Product> list=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    list.add(new Product(1,"Tivi",15));
    list.add(new Product(2,"Tu lanh",25));
    list.add(new Product(3,"o to",55));
    list.add(new Product(4,"may tinh",200));

    req.setAttribute("listSP",list);
        RequestDispatcher dispatcher;
        dispatcher =req.getRequestDispatcher("ShowProduct.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        list.add(new Product(id,name,price));

        req.setAttribute("listSP", list);
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("ShowProduct.jsp");
        dispatcher.forward(req, resp);

    }
}
