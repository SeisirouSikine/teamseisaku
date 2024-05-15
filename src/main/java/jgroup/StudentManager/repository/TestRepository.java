package jgroup.StudentManager.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgroup.StudentManager.model.Test;


@Repository
public interface TestRepository  extends JpaRepository<Test, Long>{

}