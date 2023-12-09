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
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author xiaoh
 */
@Entity
@Table(name = "BOOK")
@NamedQuery(name = "Book.findAll", query = "select b from Book b")
@NamedQuery(name = "Book.findByUsername", query = "select b from Book b where b.user.userName = :uname")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long id;

    private String name;
    
    @OneToOne
    @JoinColumn(name = "LIB_ID")
    private Library library;
    
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    @OneToMany(mappedBy = "Book")
    private List<LoanRecord> lrs = new ArrayList<>();
    
    /**
     * Default constructor for creating an empty Book instance.
     */
    public Book() {
    }

    /**
     *Constructor for creating a Book instance with a specified name.
     *
     * 
     * @param name The name of the book.
     */
    public Book(String name) {
        this.name = name;
    }
    
    /**
     * Retrieves the unique identifier of the book.
     *
     * @return The ID of the book.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets a new identifier for the book.
     *
     * @param id The new ID to be set for the book.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj object
     * @return true if the given object represents a Book equivalent to this book, false otherwise.
     *
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
        final Book other = (Book) obj;

        // if we are relying on GeneratedValue for id, we need to check whether
        // either Entity ID is null in order to reply on that field
        if (this.id == null || other.id == null) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }

    /**
     * Retrieves the name of the book.
     *
     * @return The name of the book.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name for the book.
     *
     * @param name The new name to be set for the book.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the library associated with the book.
     *
     * @return The library associated with the book.
     */
    public Library getLibrary() {
        return library;
    }

    /**
     * Sets a new library for the book.
     *
     * @param Library The library to be associated with the book.
     */
    public void setLibrary(Library Library) {
        this.library = Library;
    }

    /**
     * Retrieves the list of loan records associated with the book.
     *
     * @return A list of loan records associated with the book.
     */
    public List<LoanRecord> getLrs() {
        return lrs;
    }

    /**
     * Sets a new list of loan records for the book.
     *
     * @param lrs The list of loan records to be associated with the book.
     */
    public void setLrs(List<LoanRecord> lrs) {
        this.lrs = lrs;
    }

    /**
     * Returns a string representation of the Book object.
     *
     * @return A string representation of this book.
     */
    @Override
    public String toString() {
        return "Vet{" + "id=" + id + ", name=" + name + ", Library=" + library + '}';
    }

    /**
     * Retrieves the user associated with the book.
     *
     * @return The user associated with the book.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets a new user for the book.
     *
     * @param user The user to be associated with the book.
     */
    public void setUser(User user) {
        this.user = user;
    }

}
