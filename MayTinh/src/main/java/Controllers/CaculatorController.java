package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
@RequestMapping("/caculator")
    public String Tinh(@RequestParam int a, @RequestParam int b , @RequestParam String cal, Model model){
    int result=0;
    if (cal.equals("add")){
        result = a + b;
    } else if(cal.equals("sub")){
        result = a - b;
    } else if (cal.equals("mul")){
        result = a * b;
    } else {
        result = a / b;
    }
    model.addAttribute("result",result);
    return "WEB-INF/Caculator.jsp";
}
@GetMapping("/caculator")
    public String show(){
    return "WEB-INF/Caculator.jsp";
}
}
