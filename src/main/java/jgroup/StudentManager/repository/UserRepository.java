
package jgroup.StudentManager.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgroup.StudentManager.model.Teacher;
 
@Repository

public interface UserRepository extends JpaRepository<Teacher, String> {

    Teacher findByIdEquals(String id);

	Teacher getByName(String userid);

}
