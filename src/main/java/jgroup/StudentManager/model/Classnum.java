package jgroup.StudentManager.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
@Entity
@Data
@Table(name = "CLASSNUM")
public class Classnum {
	@Id
    private Long id;
    @Column(name = "SCHOOLCD", nullable = false, length = 3)
    private String schoolcd;
	
	@Id
    @Column(name = "CLASSNUM", nullable = false, length = 5)
    private String classnum;
 

}
 