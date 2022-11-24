package org.example.mindi.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "Principal")
public class Principal {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int principalId;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @OneToOne(mappedBy = "principal")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    School school;

    public Principal() {
    }

    public Principal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(int principalId) {
        this.principalId = principalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public org.example.mindi.entity.School getSchool() {
        return school;
    }

    public void setSchool(org.example.mindi.entity.School school) {
        this.school = school;
        school.setPrincipal(this);
    }
}
