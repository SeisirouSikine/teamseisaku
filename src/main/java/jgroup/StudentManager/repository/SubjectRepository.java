package jgroup.StudentManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgroup.StudentManager.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
