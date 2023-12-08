/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.web;

import edu.iit.sat.itmd4515.xkou.domain.Book;
import edu.iit.sat.itmd4515.xkou.service.BookService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author xiaoh
 */
@FacesConverter(value = "bookConverter", managed = true)
public class BookConverter implements Converter<Book>{

    @EJB BookService bookSvc;
    
    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Book getAsObject(FacesContext context, UIComponent component, String value) {
        // find based on String value param (Entity ID)
        return bookSvc.read(Long.valueOf(value));
    }

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Book value) {
        // return Entity ID as String
        return String.valueOf(value.getId());
    }
    
}
