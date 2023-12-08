/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author xiaoh
 */
@Entity
@NamedQuery(name = "Student.findAll", query = "select s from Student s")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Long id;

    @NotBlank
    @Column(name = "STUDENT_NAME", nullable = false, unique = true)
    private String name;

    @PastOrPresent
    @Column(name = "STUDENT_ADDATE")
    private LocalDate admissionDate;

    @Column(name = "STUDENT_GENDER")
    @Enumerated(EnumType.STRING)
    private StudentGender gender;

    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers = new ArrayList<>();

    /**
     *
     */
    public Student() {
    }

    /**
     *
     * @param name
     * @param admissionDate
     * @param gender
     */
    public Student(String name, LocalDate admissionDate, StudentGender gender) {
        this.name = name;
        this.admissionDate = admissionDate;
        this.gender = gender;
    }

    

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    /**
     *
     * @param admissionDate
     */
    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     *
     * @return
     */
    public StudentGender getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender(StudentGender gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", admissionDate=" + admissionDate + ", gender=" + gender + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        
        if (this.id == null || other.id == null) {
            return false;
        }
        
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @return
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     *
     * @param teachers
     */
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

}
