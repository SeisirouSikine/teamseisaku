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
    private Integer entyear;
 
    @Column(name = "CLASSNUM", length = 3)
    private String classnum;
 
    @Column(name = "ISATTEND")
    private Boolean isattend;
 
    @Column(name = "SCHOOLCD", length = 3)
    private String schoolcd;
    
    public Boolean getIsattend() {
        return this.isattend != null ? this.isattend : true;    }

    
}
 