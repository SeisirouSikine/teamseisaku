package jgroup.StudentManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgroup.StudentManager.model.Student;
import jgroup.StudentManager.model.Subject;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByEntyearAndClassnumAndIsattend(Integer Entyear, String Classnum, boolean Isattend);
	List<Subject> findByEntyearAndClassnum(Integer Entyear, String Classnum);
}