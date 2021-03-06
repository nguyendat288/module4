package controller;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import repository.ICustomerRepo;
import service.ICustomerService;

import java.util.ArrayList;

@Controller
public class CustomerController {
    ArrayList<Customer> list = new ArrayList<>();
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        list = iCustomerService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/edit/{index}")
    public ModelAndView showEdit(@PathVariable int index) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", list.get(index));
        return modelAndView;
    }

    @GetMapping("/delete/{index}")
    public ModelAndView delete(@PathVariable int index) {
        iCustomerService.delete(list.get(index));
        return new ModelAndView("redirect:/show");
    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute Customer customer) {
        iCustomerService.edit(customer);
        return new ModelAndView("redirect:/show");
    }
    @GetMapping ("/create")
    public ModelAndView getCreate(){
        ModelAndView modelAndView=new ModelAndView("create");
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer){
        iCustomerService.save(customer);
        return "redirect:/show";
    }
}