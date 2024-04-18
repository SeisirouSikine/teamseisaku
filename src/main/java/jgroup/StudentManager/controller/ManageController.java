package jgroup.StudentManager.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import jgroup.StudentManager.service.ManageService;
@Controller
public class ManageController{

@Autowired
//private ManageService ManageService;

@GetMapping("/")
public String index() {
	
	
	return "home";
}




}

//@GetMapping("/logout")
//public String logout(HttpServletRequest request) {
//    HttpSession session = request.getSession(false);
//    if (session != null) {
//        session.invalidate(); 
//    }
//    return "redirect:/"; 
//}
//}