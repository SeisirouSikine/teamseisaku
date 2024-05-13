package jgroup.StudentManager.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
@Entity
@Data
@Table(name = "TEACHER")
public class Teacher {
    @Id
    @Column(name = "ID", nullable = false, length = 10)
    private String id;
    
    @Column(name = "PASSWORD", length = 256)
    private String password;
    
    @Column(name = "NAME", length = 10)
    private String name;
    
    @Column(name = "SCHOOLCD", length = 3)
    private String schoolcd;
    

}