package jgroup.StudentManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jgroup.StudentManager.model.Student;
import jgroup.StudentManager.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentList(String schoolcd) {
        return studentRepository.findBySchoolCd(schoolcd);
    }


    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public List<Student> filterStudents(Integer Entyear, String Classnum, boolean Isattend) {
        return studentRepository.findByEntyearAndClassnumAndIsattend(Entyear, Classnum, Isattend);
    }
    
    public List<Student> filterStudents(Integer Entyear, String Classnum) {
        return studentRepository.findByEntyearAndClassnum(Entyear, Classnum);
    }


	public List<Student> getStudentEntyear(String schoolcd) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
    
}
