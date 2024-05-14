package jgroup.StudentManager.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
 
 
@Controller
public class ManageController {
 
//    private final UserDetailsServiceImpl userDetailsServiceImpl;
//
//    public ManageController(UserDetailsServiceImpl userDetailsServiceImpl) {
//        this.userDetailsServiceImpl = userDetailsServiceImpl;
//    }
 
    @GetMapping("/")
    public String index() {
        return "home";
    }
 
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
 
    
 
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
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
