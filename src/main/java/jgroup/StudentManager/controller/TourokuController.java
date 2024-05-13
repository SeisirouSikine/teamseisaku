package jgroup.StudentManager.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jgroup.StudentManager.model.Student;
import jgroup.StudentManager.model.Subject;
import jgroup.StudentManager.model.Teacher;
import jgroup.StudentManager.model.Test;
import jgroup.StudentManager.service.StudentService;
import jgroup.StudentManager.service.SubjectService;
import jgroup.StudentManager.service.TestService;


@Controller
public class TourokuController {
	@Autowired
    private StudentService studentService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private TestService testService;

	
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
	    List<Student> filteredStudents = studentService.filterStudents(student.getEntyear(), student.getClassnum(), student.getIsattend());
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
	        student.setClassnum(updatedStudent.getClassnum());
	        student.setIsattend(updatedStudent.getIsattend());
	        studentService.updateStudent(student);
	    }
	    return "redirect:/gakuseikannri";
	}

	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
	    Student student = studentService.getStudentById(id);
	    student.setIsattend(false);
	    studentService.updateStudent(student);
	    //studentService.deleteStudent(id);
	    return "redirect:/gakuseikannri";
	}
	
	
//	@GetMapping("/seisekitouroku")
//	public String getAllSubjects(@AuthenticationPrincipal UserDetails name, Model model) {
//		List<Subject> subjects = subjectService.getSubjectList();
//        model.addAttribute("subject", subjects);
//        model.addAttribute("user2",name);
//        return "seisekitouroku";
//	}
//
	
	
	//成績登録のページ
    @GetMapping("/seisekitouroku")
  public String getAllStudents(Model model, @AuthenticationPrincipal Teacher teacher, @AuthenticationPrincipal Student student, @AuthenticationPrincipal Subject subject) {
        // 学校コード
          Test test = new Test();
         String schoolcd = teacher.getSchoolcd();
        List<Test> students = testService.getAllStudentsBySchoolcd(schoolcd);
        model.addAttribute("tests", students);
        model.addAttribute("testmodel",test);

        // Studentmodel
        List<Student> studentList = studentService.getStudentEntyear(schoolcd);
        model.addAttribute("student", studentList);
      
        // SubjectModel
        List<Subject> subjectcd = subjectService.getAllSubjectBySchoolcd(schoolcd);
        model.addAttribute("subjectcd", subjectcd);
        return "seisekitouroku";
    }
	
	
	@PostMapping("/seisekitouroku")
	public String getFilteredStudents(
            @RequestParam(name= "entyear" , required = false) Integer entyear,
            @RequestParam(name= "classnum" , required = false) String classnum,
            @RequestParam(name= "cd" , required = false) String cd,
            @RequestParam(name= "no" , required = false) String no,
            Model model) {
        System.out.println(entyear);
        System.out.println(classnum);
        System.out.println(cd);
        System.out.println(no);

        model.addAttribute("cd",	cd);
        model.addAttribute("no",no);
        model.addAttribute("test",testService.Test(entyear,classnum));
	    return "seisekitouroku";
	}
 


	

	
	@PostMapping("/pointtouroku")
	public String test(@Validated @ModelAttribute @NonNull Test test, RedirectAttributes result,
		RedirectAttributes redirectAttributes) {
		System.out.println(test);
		try {
			this.testService.save(test);
			System.out.println("うんち");
//			System.out.println(test);

			redirectAttributes.addFlashAttribute("exception", "");
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("exception", e.getMessage());
				}
		return "/seisekikanryou";
		}
	
	@GetMapping("/seisekikanryou")
	public String index() {
		
		
		return "seisekikanryou";
	}
	

	
	

}


