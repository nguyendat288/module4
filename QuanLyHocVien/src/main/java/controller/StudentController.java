package controller;

import model.Classroom;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IClassroomService;
import service.IStudentService;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
public class StudentController {
    @Autowired
    IStudentService iStudentService;
    @Autowired
    IClassroomService iClassroomService;


    @ModelAttribute
    public ArrayList<Classroom> listClassroom() {
        return iClassroomService.ShowAllClassroom();
    }

    @RequestMapping("/home")
    public ModelAndView show(@RequestParam(defaultValue = "0") int pageNumber,@RequestParam(defaultValue = "3") int sizePage) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("ListStudent", iStudentService.ShowAllStudent(PageRequest.of(pageNumber,sizePage)));
        modelAndView.addObject("ListClass", iClassroomService.ShowAllClassroom());
        return modelAndView;
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message",e.getMessage());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student",new Student());
        modelAndView.addObject("ListClass", iClassroomService.ShowAllClassroom());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("student") Student student,
                               BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        iStudentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id){
        iStudentService.delete(iStudentService.findById(id));
        return new ModelAndView("redirect:/home");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showedit(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("edit");
        modelAndView.addObject("student",iStudentService.findById(id));
        modelAndView.addObject("ListClass",iClassroomService.ShowAllClassroom());
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Student student,@RequestParam long classroomid){
        Classroom classroom = new Classroom();
        classroom.setId(classroomid);
        student.setClassroom(classroom);
        iStudentService.save(student);
        return new ModelAndView("redirect:/home");
    }

}
