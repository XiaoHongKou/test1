/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author xiaoh
 */
@Entity
@Table(name = "LoanRecord")
@NamedQuery(name = "LoanRecord.findAll", query = "select lo from LoanRecord lo")
@NamedQuery(name = "LoanRecord.findLrsByStudentID", query = "select lo from LoanRecord lo where lo.student.id=:stuid")
public class LoanRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LoanR_ID")
    private Long id;

    private LocalDate date;

    private LocalTime time;

    private String type;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    /**
     *
     */
    public LoanRecord() {
    }

    /**
     *
     * @param date
     * @param time
     * @param type
     */
    public LoanRecord(LocalDate date, LocalTime time, String type) {
        this.date = date;
        this.time = time;
        this.type = type;
    }

    /**
     *
     * @param t
     * @param s
     * @param b
     */
    public void schedLoan(Teacher t, Student s, Book b) {
        this.teacher = t;
        this.student = s;
        this.book = b;

        if (!t.getLrs().contains(this)) {
            t.getLrs().add(this);
        }
        
        if (!b.getLrs().contains(this)) {
            b.getLrs().add(this);
        }
        
    }
    
    /**
     *
     * @param t
     * @param s
     * @param b
     */
    public void removeLoan(Teacher t, Student s, Book b) {

        if (t.getLrs().contains(this)) {
            t.getLrs().remove(this);
        }
        
        if (b.getLrs().contains(this)) {
            b.getLrs().remove(this);
        }
        
        this.book = null;
        this.student = null;
        this.teacher = null;
    }
    
    /**
     *
     */
    public void removeLoan() {

        if (this.teacher.getLrs().contains(this)) {
            teacher.getLrs().remove(this);
        }
        
        if (book.getLrs().contains(this)) {
            book.getLrs().remove(this);
        }
        
        this.book = null;
        this.student = null;
        this.teacher = null;
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
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final LoanRecord other = (LoanRecord) obj;

        // if we are relying on GeneratedValue for id, we need to check whether
        // either Entity ID is null in order to reply on that field
        if (this.id == null || other.id == null) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     *
     * @param teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     *
     * @return
     */
    public Student getStudent() {
        return student;
    }

    /**
     *
     * @param student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     *
     * @return
     */
    public Book getBook() {
        return book;
    }

    /**
     *
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "LoanRecord{" + "id=" + id + ", date=" + date + ", time=" + time + ", type=" + type + ", teacher=" + teacher + ", student=" + student + ", book=" + book + '}';
    }

}
