package jgroup.StudentManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jgroup.StudentManager.model.Subject;
import jgroup.StudentManager.service.SubjectService;

@Controller
public class KamokuController {
    @Autowired
    private SubjectService subjectService;
    
    @GetMapping("/kamokukannri")
    public String getAllSubject(Model model) {
        List<Subject> subject = subjectService.getSubjectList();
        model.addAttribute("subject", subject);
        return "kamokukannri";
    }
    
    @GetMapping("/kamokutouroku")
    public String showCreateSForm(Model model) {
        model.addAttribute("subjectModel", new Subject());
        return "kamokutouroku";
    }
    
    @PostMapping("/kamokutouroku")
    public String saveSubject(Model model, @ModelAttribute("subjectModel") Subject subject) {
        try {
            subjectService.saveSubject(subject);
            return "redirect:/kamokukannri";
        } catch(Exception e){
            System.out.println("エラーが発生しました：" + e.getMessage());
            return "redirect:/kamokutouroku";
        }
    }
}

		
//		//編集
//		@GetMapping("/gakuseihensyu/{id}")
//		public String showEditSubjectForm(@PathVariable Long id, Model model) {
//			Subject subject = subjectService.getSubjectById(id);
//		    model.addAttribute("subject", subject);
//		    return "gakuseihensyu";
//		}
//		
//		@PostMapping("/gakuseihensyu/{id}")
//		public String updatesubject(@PathVariable Long id, @ModelAttribute("subject") Subject updatedsubject) {
//			Subject subject = subjectService.getSubjectById(id);
//		    if (subject != null) {
//		    	subject.setCd(updatedSubject.getCd());
//		    	subject.setName(updatedSubject.getName());
//		    	
//		        subjectService.updateSubject(subject);
//		    }
//		    return "redirect:/gakuseikannri";
//		}
		
