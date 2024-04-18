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
}
