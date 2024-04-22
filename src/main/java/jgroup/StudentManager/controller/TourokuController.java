package jgroup.StudentManager.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jgroup.StudentManager.model.Student;
import jgroup.StudentManager.service.StudentService;
 
@Controller
public class TourokuController {
	@Autowired
    private StudentService studentService;
	
	// 全生徒を取得
	@GetMapping("/gakuseikannri")
	public String getAllStudents(@AuthenticationPrincipal UserDetails user, Model model) {
		List<Student> students = studentService.getStudentList();
        model.addAttribute("students", students);
        model.addAttribute("user2",user);
        return "gakuseikannri";
	}
	
	@PostMapping("/gakuseikannri")
	public String filterStudents(Model model, @ModelAttribute("filterModel") Student student) {
	    List<Student> filteredStudents = studentService.filterStudents(student.getEntYear(), student.getClassNum(), student.getIsAttend());
	    model.addAttribute("students", filteredStudents);
	    return "gakuseikannri";
	}
	
	

	
	
	
	// 生徒の追加
	@GetMapping("/gakuseitouroku")
	public String showCreateStudentForm(Model model) {
        model.addAttribute("studentModel", new Student());
        return "gakuseitouroku";
    }
	
	@PostMapping("/gakuseitouroku")
	public String saveStudent(Model model, @ModelAttribute("studentModel") Student student) {
    	try {
			studentService.saveStudent(student);
        	return "redirect:/gtg";
    	} catch(Exception e){
        	System.out.println("エラーが発生しました：" + e.getMessage());
        	return "redirect:/gakuseitouroku";
    	}
    }
    //登録完了画面
	@GetMapping("/gtg")
	public String gakuseitourokunoat(Model model) {
        model.addAttribute("studentModel", new Student());
        return "gtg";
    }
	//編集
	@GetMapping("/gakuseihensyu/{id}")
	public String showEditStudentForm(@PathVariable Long id, Model model) {
	    Student student = studentService.getStudentById(id);
	    model.addAttribute("student", student);
	    return "gakuseihensyu";
	}
	
	@PostMapping("/gakuseihensyu/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student updatedStudent) {
	    Student student = studentService.getStudentById(id);
	    if (student != null) {
	        student.setName(updatedStudent.getName());
	        student.setClassNum(updatedStudent.getClassNum());
	        student.setIsAttend(updatedStudent.getIsAttend());
	        studentService.updateStudent(student);
	    }
	    return "redirect:/gakuseikannri";
	}

	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
	    Student student = studentService.getStudentById(id);
	    student.setIsAttend(false);
	    studentService.updateStudent(student);
	    //studentService.deleteStudent(id);
	    return "redirect:/gakuseikannri";
	}
}
