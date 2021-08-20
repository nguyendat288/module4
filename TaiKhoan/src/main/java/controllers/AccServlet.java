package controllers;

import models.TaiKhoan;
import service.AccService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"","/acc"})
public class AccServlet extends HttpServlet {
    AccService accService=new AccService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                resp.sendRedirect("views/CreateAcc.jsp");
                break;
            case "edit":
                int indexEdit=Integer.parseInt(req.getParameter("index"));
                req.setAttribute("acc",accService.list.get(indexEdit));
                dispatcher= req.getRequestDispatcher("views/editAcc.jsp");
                dispatcher.forward(req,resp);
                break;
            case "delete":
                int index= Integer.parseInt(req.getParameter("index"));
                try {
                    accService.delete(index);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/");
                break;
            case "findName":
                String name = req.getParameter("findName");
                try {
                    req.setAttribute("ListAcc", accService.findByName(name));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispatcher = req.getRequestDispatcher("views/ShowAcc.jsp");
                    dispatcher.forward(req, resp);
                break;
            default:
                req.setAttribute("ListAcc",accService.list);
                dispatcher = req.getRequestDispatcher("views/ShowAcc.jsp");
                dispatcher.forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        switch (action) {
            case "create":
                int id = Integer.parseInt(req.getParameter("id"));
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String email = req.getParameter("email");

                TaiKhoan tk = new TaiKhoan(id, username, password, email);
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

            case "edit":
                int idedit = Integer.parseInt(req.getParameter("id"));
                String usernameedit = req.getParameter("username");
                String passwordedit = req.getParameter("password");
                String emailedit = req.getParameter("email");

                TaiKhoan tkedit = new TaiKhoan(idedit, usernameedit, passwordedit, emailedit);

                int index = Integer.parseInt(req.getParameter("index"));
                try {
                    accService.edit(tkedit, index);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                // chuyển hướng request và response sang thàng jsp
                req.setAttribute("ListAcc", accService.list);
                dispatcher = req.getRequestDispatcher("views/ShowAcc.jsp");
                dispatcher.forward(req, resp);
                break;
            case "find":
                int idfind = Integer.parseInt(req.getParameter("idfind"));
                ArrayList<TaiKhoan> list1=new ArrayList<>();
                for(TaiKhoan x: accService.list){
                    if(x.getId()==idfind){
                        list1.add(x);
                    }
                }
                req.setAttribute("ListAcc",list1);
                dispatcher= req.getRequestDispatcher("views/ShowAcc.jsp");
                dispatcher.forward(req, resp);
                break;

        }
    }
}
