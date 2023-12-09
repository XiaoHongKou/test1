/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.domain;

import edu.iit.sat.itmd4515.xkou.security.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author xiaoh
 */
@Entity
@Table(name = "TEACHER")
@NamedQuery(name = "Teacher.findAll", query = "select t from Teacher t")
@NamedQuery(name = "Teacher.findByUsername", query = "select t from Teacher t where t.user.userName = :uname")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEACHER_ID")
    private Long id;

    private String name;

    private String email;

    private LocalDate birthDate;
    
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    @ManyToMany
    @JoinTable(name = "TEACHER_STUDENTS",
            joinColumns = @JoinColumn(name = "TEACHER_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "teacher")
    private List<LoanRecord> lrs = new ArrayList<>();
    
    /**
     * Default constructor for creating an empty Teacher instance.
     */
    public Teacher() {
    }

    /**
     * Constructor for creating a Teacher instance with specified name, email, and birth date.
     * 
     * @param name The name of the teacher.
     * @param email The email of the teacher.
     * @param birthDate The birth date of the teacher.
     */
    public Teacher(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    /**
     *
     * Adds a student to the teacher's list of students.
     * 
     * @param s The student to be added.
     */
    public void addStudent(Student s) {
        if (!this.students.contains(s)) {
            this.students.add(s);
        }

        if (!s.getTeachers().contains(this)) {
            s.getTeachers().add(this);
        }
    }

    /**
     *
     * Removes a student from the teacher's list of students.
     * 
     * @param s The student to be removed.
     */
    public void removeStudent(Student s) {

        if (this.students.contains(s)) {
            this.students.remove(s);
        }

        if (s.getTeachers().contains(this)) {
            s.getTeachers().remove(this);
        }
    }

    /**
     * Retrieves the unique identifier of the teacher.
     *
     * @return The ID of the teacher.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets a new identifier for the teacher.
     *
     * @param id The new ID to be set for the teacher.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * Generates a hash code for this teacher based on its ID.
     * 
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * Compares this teacher to another object for equality, based primarily on teacher ID.
     * 
     * @param obj The object to compare with this teacher.
     * @return true if the given object represents a Teacher equivalent to this teacher, false otherwise.
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
        final Teacher other = (Teacher) obj;

        if (this.id == null || other.id == null) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }

    /**
     * Retrieves the name of the teacher.
     *
     * @return The name of the teacher.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name for the teacher.
     *
     * @param name The new name to be set for the teacher.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the email address of the teacher.
     *
     * @return The email address of the teacher.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets a new email address for the teacher.
     *
     * @param email The new email address to be set for the teacher.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the birth date of the teacher.
     *
     * @return The birth date of the teacher.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets a new birth date for the teacher.
     *
     * @param birthDate The new birth date to be set for the teacher.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Retrieves the list of students associated with the teacher.
     *
     * @return A list of students associated with the teacher.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Sets a new list of students for the teacher.
     *
     * @param students The new list of students to be associated with the teacher.
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Retrieves the list of loan records associated with the teacher.
     *
     * @return A list of loan records associated with the teacher.
     */
    public List<LoanRecord> getLrs() {
        return lrs;
    }

    /**
     * Sets a new list of loan records for the teacher.
     *
     * @param lrs The new list of loan records to be associated with the teacher.
     */
    public void setLrs(List<LoanRecord> lrs) {
        this.lrs = lrs;
    }

    /**
     *
     * Returns a string representation of the Teacher object, including its ID, name, email, and birth date.
     * 
     * @return A string representation of this teacher.
     */
    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + '}';
    }

    /**
     * Retrieves the user account associated with the teacher.
     *
     * @return The user account associated with the teacher.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets a new user account for the teacher.
     *
     * @param user The new user account to be associated with the teacher.
     */
    public void setUser(User user) {
        this.user = user;
    }

}
