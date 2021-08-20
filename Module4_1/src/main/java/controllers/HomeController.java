package controllers;

import models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CRUDCustomer;

import javax.servlet.http.HttpServletRequest;
@Controller
public class HomeController {
    CRUDCustomer crudCustomer=new CRUDCustomer();
    @RequestMapping("/show")
    public String home(HttpServletRequest req){
        req.setAttribute("list",crudCustomer.list);
    return "/WEB-INF/show.jsp";
    }
    @GetMapping("/edit")
    public String ShowEdit(HttpServletRequest req){
        int index= Integer.parseInt(req.getParameter("index"));
        req.setAttribute("customer",crudCustomer.list.get(index));
    return "/WEB-INF/edit.jsp";
    }
    @GetMapping("/create")
    public String ShowCreate(){
        return "/WEB-INF/create.jsp";
    }
    @GetMapping("/delete")
    public String ShowDelete(HttpServletRequest req){
        int index=Integer.parseInt(req.getParameter("index"));
   crudCustomer.delete(index);
    return  "/WEB-INF/show.jsp";
    }
    @PostMapping("/edit")
    public String edit(HttpServletRequest req){
        int index=Integer.parseInt(req.getParameter("index"));
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        Customer customer=new Customer(id,name,email);
        crudCustomer.edit(customer,index);
    return "/WEB-INF/show.jsp";
    }

    @PostMapping("/create")
    public String create(HttpServletRequest req){
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String email=req.getParameter("email");
       Customer customer=new Customer(id,name,email);
       crudCustomer.save(customer);
        return "/WEB-INF/show.jsp";
    }
    
}
