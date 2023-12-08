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
     *
     */
    public Teacher() {
    }

    /**
     *
     * @param name
     * @param email
     * @param birthDate
     */
    public Teacher(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    /**
     *
     * @param s
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
     * @param s
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
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Teacher other = (Teacher) obj;

        if (this.id == null || other.id == null) {
            return false;
        }

        return Objects.equals(this.id, other.id);
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
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     *
     * @return
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     *
     * @param students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     *
     * @return
     */
    public List<LoanRecord> getLrs() {
        return lrs;
    }

    /**
     *
     * @param lrs
     */
    public void setLrs(List<LoanRecord> lrs) {
        this.lrs = lrs;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + '}';
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
