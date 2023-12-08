/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.web;

import edu.iit.sat.itmd4515.xkou.domain.Book;
import edu.iit.sat.itmd4515.xkou.service.BookService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.logging.Logger;

/**
 *
 * @author xiaoh
 */
@Named
@RequestScoped
public class BookWelcomeController {

    private static final Logger LOG = Logger.getLogger(BookWelcomeController.class.getName());

    // Model
    private Book book;

    @Inject LoginController loginController;
    @EJB BookService bookSvc;
    
    /**
     *
     */
    public BookWelcomeController() {
    }

    @PostConstruct
    private void postContruct() {
        book = new Book();
        LOG.info("Inside OwnerWelcomeController.postConstruct");
        book = bookSvc.findByUsername(loginController.getCurrentUser());
        LOG.info("Leaving OwnerWelcomeController.postConstruct with " + book.toString());
    }

    // utility or helpers

    /**
     *
     */
    public void refreshTeacher(){
        book = bookSvc.findByUsername(loginController.getCurrentUser());
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

}
