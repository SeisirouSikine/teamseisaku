package jgroup.StudentManager.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "SUBJECT")
public class Subject {
    @Id
    @Column
    private Long id;
    
    @Column(name = "SCHOOL_CD", nullable = false, length = 3)
    private String school_cd;
    
    @Column(name = "CD", nullable = false, length = 3)
    private String cd;
    
    @Column(name = "NAME", length = 20)
    private String name;
    
    public String getSchool_cd() {
        return school_cd;
    }
 
    public void setSchool_cd(String school_cd) {
        this.school_cd = school_cd;
    }
 
    public String getCd() {
        return cd;
    }
 
    public void setCd(String cd) {
        this.cd = cd;
    }
    
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}