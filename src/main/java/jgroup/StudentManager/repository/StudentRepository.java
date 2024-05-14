package jgroup.StudentManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgroup.StudentManager.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByEntyearAndClassnumAndIsattend(Integer Entyear, String Classnum, boolean Isattend);
	List<Student> findByEntyearAndClassnum(Integer entyear, String classnum);
	List<Student> findBySchoolCd(String schoolcd);

}