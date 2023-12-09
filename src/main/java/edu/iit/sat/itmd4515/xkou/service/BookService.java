/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.service;

import edu.iit.sat.itmd4515.xkou.domain.Book;
import edu.iit.sat.itmd4515.xkou.domain.Teacher;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author xiaoh
 */
@Named
@Stateless
public class BookService {
    
    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;

    /**
     * Default constructor.
     */
    public BookService() {
    }
    
    /**
     * Persists the given Book entity into the database.
     * @param b The Book entity to be persisted.
     */
    public void create(Book b) {
        em.persist(b);
    }    

    /**
     * Finds a Book entity by its ID.
     * @param id The ID of the Book entity to find.
     * @return The found Book entity or null if not found.
     */
    public Book read(Long id) {
        return em.find(Book.class, id);
    }

    /**
     * Updates the given Book entity in the database.
     * @param b The Book entity to be updated.
     */
    public void update(Book b) {
        em.merge(b);
    }

    /**
     * Removes the given Book entity from the database.
     * @param b The Book entity to be removed.
     */
    public void delete(Book b) {
        em.remove(em.merge(b));
    }
    
    /**
     * Retrieves a list of all Book entities.
     * @return A list of all Book entities.
     */
    public List<Book> findAll() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }
    
    /**
     * Finds a Book entity by the username of its associated user.
     * @param username The username to search for.
     * @return The Book entity associated with the specified username.
     */
    public Book findByUsername(String username){
        return em
                .createNamedQuery("Book.findByUsername", Book.class)
                .setParameter("uname", username)
                .getSingleResult();
    }
    
}
