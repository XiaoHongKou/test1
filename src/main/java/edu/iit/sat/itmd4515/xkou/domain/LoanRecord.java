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
     * Default constructor for creating an empty LoanRecord instance.
     */
    public LoanRecord() {
    }

    /**
     *
     * Constructor for creating a LoanRecord instance with specified date, time, and type.
     * 
     * @param date The date of the loan.
     * @param time The time of the loan.
     * @param type The type of the loan.
     */
    public LoanRecord(LocalDate date, LocalTime time, String type) {
        this.date = date;
        this.time = time;
        this.type = type;
    }

    /**
     *  Schedules a new loan involving a teacher, student, and book.
     * 
     * @param t The teacher involved in the loan.
     * @param s The student involved in the loan.
     * @param b The book involved in the loan.
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
     * Removes a loan involving a specific teacher, student, and book.
     * 
     * @param t The teacher involved in the loan.
     * @param s The student involved in the loan.
     * @param b The book involved in the loan.
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
     * Removes the current loan from the associated teacher and book records.
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
     * Retrieves the ID of the loan record.
     *
     * @return The ID of the loan record.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets a new ID for the loan record.
     *
     * @param id The new ID to be set for the loan record.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * Generates a hash code for this loan record based on its ID.
     * 
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * Compares this loan record to another object for equality, based primarily on loan record ID.
     * 
     * @param obj The object to compare with this loan record.
     * @return true if the given object represents a LoanRecord equivalent to this loan record, false otherwise.
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
     * Retrieves the date of the loan record.
     *
     * @return The date of the loan record.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets a new date for the loan record.
     *
     * @param date The new date to be set for the loan record.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Retrieves the time of the loan record.
     *
     * @return The time of the loan record.
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Sets a new time for the loan record.
     *
     * @param time The new time to be set for the loan record.
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Retrieves the type of the loan record.
     *
     * @return The type of the loan record.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets a new type for the loan record.
     *
     * @param type The new type to be set for the loan record.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retrieves the teacher associated with the loan record.
     *
     * @return The teacher associated with the loan record.
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Sets a new teacher for the loan record.
     *
     * @param teacher The new teacher to be associated with the loan record.
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Retrieves the student associated with the loan record.
     *
     * @return The student associated with the loan record.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets a new student for the loan record.
     *
     * @param student The new student to be associated with the loan record.
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Retrieves the book associated with the loan record.
     *
     * @return The book associated with the loan record.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets a new book for the loan record.
     *
     * @param book The new book to be associated with the loan record.
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     *
     * Returns a string representation of the LoanRecord object, including its ID, date, time, type, and associated teacher, student, and book.
     * 
     * @return A string representation of this loan record.
     */
    @Override
    public String toString() {
        return "LoanRecord{" + "id=" + id + ", date=" + date + ", time=" + time + ", type=" + type + ", teacher=" + teacher + ", student=" + student + ", book=" + book + '}';
    }

}
