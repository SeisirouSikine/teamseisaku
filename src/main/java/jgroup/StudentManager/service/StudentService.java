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

    public List<Student> getStudentList() {
        return studentRepository.findAll();
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
    
    public List<Student> filterStudents(Integer entYear, String classNum, boolean isAttend) {
        return studentRepository.findByEntYearAndClassNumAndIsAttend(entYear, classNum, isAttend);
    }
    
}
