package jgroup.StudentManager.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TEST")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "STUDENT_NO", nullable = false, length = 10)
    private String studentNo;
    
    @Column(name = "SUBJECT_CD", nullable = false, length = 3)
    private String subjectCd;
    
    @Column(name = "SCHOOL_CD", nullable = false, length = 10)
    private String schoolCd;
    
    @Column(name = "NO", nullable = false, length = 10)
    private String no;
    
    @Column(name = "POINT", length = 10)
    private String point;
    
    @Column(name = "CLASS_NUM", length = 5)
    private String classNum;
    
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")
    private Student student;
    
    // Getter and Setter methods
}
