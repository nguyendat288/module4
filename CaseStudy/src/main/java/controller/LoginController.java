package controller;

import model.TaiKhoan;
import service.AccService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"", "/login"})
public class LoginController extends HttpServlet {
    AccService accService=new AccService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                resp.sendRedirect("view/DangNhap.jsp");
                break;
            default:
                req.setAttribute("ListAcc", accService.list);
                dispatcher = req.getRequestDispatcher("view/DangNhap.jsp");
                dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        switch (action) {
            case "create":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String email = req.getParameter("email");
                String address = req.getParameter("address");
                String loaitk = req.getParameter("loaitk");
                if (id == "" ||name==""||phone==""||email==""||address==""||classroom=="") {
                    req.setAttribute("checkNull", true);
                    dispatcher = req.getRequestDispatcher("views/CreateSV.jsp");
                    dispatcher.forward(req, resp);
                }
                else {

                TaiKhoan tk = new TaiKhoan( username, password, email, address,Integer.parseInt(loaitk));
                try {
                    accService.add(tk);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                // chuyển hướng request và response sang thàng jsp
                req.setAttribute("ListAcc", accService.list);
                dispatcher = req.getRequestDispatcher("views/ShowAcc.jsp");
                dispatcher.forward(req, resp);
                break;


        }
    }
}
