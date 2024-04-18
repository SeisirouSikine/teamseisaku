package jgroup.StudentManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgroup.StudentManager.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByEntYearAndClassNumAndIsAttend(Integer entYearr, String classNum, boolean isAttend);
}