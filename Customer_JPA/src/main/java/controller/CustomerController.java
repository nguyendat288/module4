package controller;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ICustomerService;

import java.util.ArrayList;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping("/show")
    public ModelAndView show(@RequestParam(defaultValue = "0") int pageNumber,@RequestParam(defaultValue = "3") int sizePage) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", iCustomerService.findAll(PageRequest.of(pageNumber,sizePage)));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", iCustomerService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        iCustomerService.delete(iCustomerService.findById(id));
        return new ModelAndView("redirect:/show");
    }
    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName){
        ModelAndView modelAndView=new ModelAndView("show");
        modelAndView.addObject("list",iCustomerService.findAllByName(findName));
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
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