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
     * Default constructor for creating an empty Student instance.
     */
    public Student() {
    }

    /**
     * Constructor for creating a Student instance with a specified name, admission date, and gender.
     * 
     * @param name The name of the student.
     * @param admissionDate The admission date of the student.
     * @param gender The gender of the student.
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
     * Retrieves the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name for the student.
     *
     * @param name The new name to be set for the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the admission date of the student.
     *
     * @return The admission date of the student.
     */
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

     /**
     * Sets a new admission date for the student.
     *
     * @param admissionDate The new admission date to be set for the student.
     */
    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * Retrieves the gender of the student.
     *
     * @return The gender of the student.
     */
    public StudentGender getGender() {
        return gender;
    }

    /**
     * Sets a new gender for the student.
     *
     * @param gender The new gender to be set for the student.
     */
    public void setGender(StudentGender gender) {
        this.gender = gender;
    }

    /**
     * Returns a string representation of the Student object.
     * 
     * @return A string representation of this student.
     */
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", admissionDate=" + admissionDate + ", gender=" + gender + '}';
    }

    /**
     *
     * Generates a hash code for this student based on its ID.
     * 
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compares this student to another object for equality, based primarily on student ID.
     * 
     * @param obj The object to compare with this student.
     * @return true if the given object represents a Student equivalent to this student, false otherwise.
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
     * Retrieves the list of teachers associated with the student.
     * 
     * @return A list of teachers associated with the student.
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Sets a new list of teachers for the student.
     * 
     * @param teachers The new list of teachers to be associated with the student.
     */
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

}
