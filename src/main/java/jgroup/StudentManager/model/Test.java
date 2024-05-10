package jgroup.StudentManager.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TEST")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "STUDENTNO", nullable = false, length = 10)
    private String studentno;
    
    @Column(name = "SUBJECTCD", nullable = false, length = 3)
    private String subjectcd;
    
    @Column(name = "SCHOOLCD", nullable = false, length = 10)
    private String schoolcd;
    
    @Column(name = "NO", nullable = false, length = 10)
    private String no;
    
    @Column(name = "POINT", length = 10)
    private String point;
    
    @Column(name = "CLASSNUM", length = 5)
    private String classnum;
    

    
    // Getter and Setter methods
}
