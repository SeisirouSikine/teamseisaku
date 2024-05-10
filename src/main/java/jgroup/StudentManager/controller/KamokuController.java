package jgroup.StudentManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jgroup.StudentManager.model.Subject;
import jgroup.StudentManager.service.SubjectService;

@Controller
public class KamokuController {
    @Autowired
    private SubjectService subjectService;
    

    
    @GetMapping("/createSubject")
	public ModelAndView add2(Subject subject, ModelAndView model) {
	      model.addObject("subject", subject);
	      model.setViewName("createSubject");
	      return model;
	}
	
	@PostMapping("/createSubject")
	public String subject(@Validated @ModelAttribute @NonNull Subject subject, RedirectAttributes result,
		RedirectAttributes redirectAttributes) {	
		try {
			this.subjectService.save(subject);
			redirectAttributes.addFlashAttribute("exception", "");
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("exception", e.getMessage());
				}
		return "redirect:/kamokukannri";
		}
	
	
	@GetMapping("/kamokukannri")
		public ModelAndView add4(ModelAndView model) {
		System.out.println(subjectService.getSubjectList().toString());
		model.addObject("subjectList", subjectService.getSubjectList());
		model.setViewName("kamokukannri");
		return model;
		}
	
	@GetMapping("/hyoujikamoku/{id}")
	public ModelAndView add2(@PathVariable(name="id")Long id, Subject subject, ModelAndView model) {
		subject = subjectService.getOneBook(id);
		model.addObject("lists", this.subjectService.get(id));
		model.addObject("subject", subject);
	    model.setViewName("deltailsubject");
	    return model;
	}
// 本の情報を更新する
	@PostMapping("/hyoujikamoku/{id}")
	public String update(@ModelAttribute @Validated Subject editsubject, BindingResult result, Model model) {
		
    // バリデーションエラーの場合
		if (result.hasErrors()) {
        // 編集画面に遷移
			return "redirect:/kamokukannri";
		}
    
    // 本を更新する
		subjectService.update(editsubject);
	
    // 本の一覧画面にリダイレクト
		return "redirect:/kamokukannri";
		}
	
	
	//削除
	@GetMapping("/deleteSubject/{id}")
	public String delete(@PathVariable(name="id")Long id, Model model, Subject subject){
		subjectService.delete(subject.getId());
		return "redirect:/kamokukannri";
	}
}

		

		
