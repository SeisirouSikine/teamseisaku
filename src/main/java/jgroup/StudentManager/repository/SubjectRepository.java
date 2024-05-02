package jgroup.StudentManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgroup.StudentManager.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	List<Subject> findByName(String name);
}
