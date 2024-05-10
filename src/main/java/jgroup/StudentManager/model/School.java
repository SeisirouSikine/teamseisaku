
package jgroup.StudentManager.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
@Entity
@Data
@Table(name = "SCHOOL")
public class School {
	 @Id
	 private Long id;
	 @Column(name = "CD", nullable = false, length = 3)
	  private String cd;
	
	 @Column(name = "NAME", length = 20)
	    private String name;
	

}