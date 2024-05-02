package jgroup.StudentManager.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "TEACHER")
public class Teacher {
    @Id
    @Column(name = "ID", nullable = false, length = 10)
    private String id;
    
    @Column(name = "PASSWORD", length = 30)
    private String password;
    
    @Column(name = "NAME", length = 10)
    private String name;
    
    @Column(name = "SCHOOL_CD", length = 3)
    private String schoolCd;
    
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
    
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getSchool_cd() {
        return schoolCd;
    }
 
    public void setSchool_cd(String schoolCd) {
        this.schoolCd = schoolCd;
    }
}