package jgroup.StudentManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jgroup.StudentManager.model.Subject;
import jgroup.StudentManager.repository.StudentRepository;
import jgroup.StudentManager.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository sutdentRepository;

    public List<Subject> getSubjectList() {
        return subjectRepository.findAll();
    }

    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void updateSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }
    public List<Subject> filterSubjects( Integer Entyear, String Schoolcd, String Name ) {
        return subjectRepository.findByName(Name);
    
    }
}
