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
     *
     */
    public BookService() {
    }
    
    /**
     *
     * @param b
     */
    public void create(Book b) {
        em.persist(b);
    }    

    /**
     *
     * @param id
     * @return
     */
    public Book read(Long id) {
        return em.find(Book.class, id);
    }

    /**
     *
     * @param b
     */
    public void update(Book b) {
        em.merge(b);
    }

    /**
     *
     * @param b
     */
    public void delete(Book b) {
        em.remove(em.merge(b));
    }
    
    /**
     *
     * @return
     */
    public List<Book> findAll() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }
    
    /**
     *
     * @param username
     * @return
     */
    public Book findByUsername(String username){
        return em
                .createNamedQuery("Book.findByUsername", Book.class)
                .setParameter("uname", username)
                .getSingleResult();
    }
    
}
