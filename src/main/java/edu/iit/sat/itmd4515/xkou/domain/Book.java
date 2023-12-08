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
     *
     */
    public Book() {
    }

    /**
     *
     * @param name
     */
    public Book(String name) {
        this.name = name;
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
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Book other = (Book) obj;

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
    public Library getLibrary() {
        return library;
    }

    /**
     *
     * @param Library
     */
    public void setLibrary(Library Library) {
        this.library = Library;
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
        return "Vet{" + "id=" + id + ", name=" + name + ", Library=" + library + '}';
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
