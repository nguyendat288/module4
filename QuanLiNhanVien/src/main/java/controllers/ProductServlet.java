package controllers;

import models.SanPham;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"","/product"})

public class ProductServlet extends HttpServlet {
    ProductService productService=new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                resp.sendRedirect("views/CreateProduct.jsp");
                break;
            case "edit":
                int indexEdit=Integer.parseInt(req.getParameter("index"));
                req.setAttribute("product",productService.list.get(indexEdit));
                dispatcher= req.getRequestDispatcher("views/EditProduct.jsp");
                dispatcher.forward(req,resp);
                break;
            case "delete":
                int index= Integer.parseInt(req.getParameter("index"));
                try {
                    productService.delete(index);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/");
                break;
            case "findName":
                String name = req.getParameter("findName");
                try {
                    req.setAttribute("ListProduct", productService.findByName(name));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispatcher = req.getRequestDispatcher("views/ShowProduct.jsp");
                dispatcher.forward(req, resp);
                break;
            default:
                req.setAttribute("ListProduct",productService.list);
                dispatcher = req.getRequestDispatcher("views/ShowProduct.jsp");
                dispatcher.forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        switch (action) {
            case "create":
                int idsp = Integer.parseInt(req.getParameter("idsp"));
                String nameproduct = req.getParameter("nameproduct");
                Float price = Float.parseFloat(req.getParameter("price"));
                int soluong = Integer.parseInt(req.getParameter("soluong"));
                String color = req.getParameter("color");
                int loaisp = Integer.parseInt(req.getParameter("loaisp"));

                SanPham sp = new SanPham(idsp, nameproduct, price, soluong,color,loaisp);
                try {
                    productService.add(sp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                // chuyển hướng request và response sang thàng jsp
                req.setAttribute("ListProduct", productService.list);
                dispatcher = req.getRequestDispatcher("views/ShowProduct.jsp");
                dispatcher.forward(req, resp);
                break;

            case "edit":
                int idsp1 = Integer.parseInt(req.getParameter("idsp"));
                String nameproduct1 = req.getParameter("nameproduct");
                Float price1 = Float.parseFloat(req.getParameter("price"));
                int soluong1 = Integer.parseInt(req.getParameter("soluong"));
                String color1 = req.getParameter("color");
                int loaisp1 = Integer.parseInt(req.getParameter("loaisp"));

                SanPham spedit = new SanPham(idsp1, nameproduct1, price1, soluong1,color1,loaisp1);

                int index = Integer.parseInt(req.getParameter("index"));
                try {
                    productService.edit(spedit, index);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                // chuyển hướng request và response sang thàng jsp
                req.setAttribute("ListProduct", productService.list);
                dispatcher = req.getRequestDispatcher("views/ShowProduct.jsp");
                dispatcher.forward(req, resp);
                break;
            case "find":
                int idfind = Integer.parseInt(req.getParameter("idfind"));
                ArrayList<SanPham> list1=new ArrayList<>();
                for(SanPham x: productService.list){
                    if(x.getIdsp()==idfind){
                        list1.add(x);
                    }
                }
                req.setAttribute("ListProduct",list1);
                dispatcher= req.getRequestDispatcher("views/ShowProduct.jsp");
                dispatcher.forward(req, resp);
                break;

        }
    }
}
