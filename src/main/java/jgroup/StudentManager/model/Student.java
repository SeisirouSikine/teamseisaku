package jgroup.StudentManager.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @Column(name = "NO", nullable = false, length = 10)
    private String no;
 
    @Column(name = "NAME", length = 10)
    private String name;
 
    @Column(name = "ENTYEAR")
    private Integer entYear;
 
    @Column(name = "CLASSNUM", length = 3)
    private String classNum;
 
    @Column(name = "ISATTEND")
    private Boolean isAttend;
 
    @Column(name = "SCHOOLCD", length = 3)
    private String schoolCd;
    
//    public Boolean getIsAttend() {
//        return this.isAttend != null ? this.isAttend : true;
//    }

    
}
 