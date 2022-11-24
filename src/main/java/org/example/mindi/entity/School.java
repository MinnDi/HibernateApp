package org.example.mindi.entity;


import javax.persistence.*;

@Entity
@Table(name = "school")
public class School {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int schoolId;

    @Column(name = "school_number")
    int schoolNumber;

    @OneToOne()
    @JoinColumn(name = "principal_id", referencedColumnName = "id")
    Principal principal;

    public School() {
    }

    public School(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
}
