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
     * Converts a String value (such as an ID) to a Book object.
     * This is typically used when converting form submission data back into entity objects.
     * 
     * @param context The FacesContext current instance.
     * @param component The UIComponent with which this converter is associated.
     * @param value The string value to be converted to a Book object.
     * @return The Book object that corresponds to the provided string value.
     */
    @Override
    public Book getAsObject(FacesContext context, UIComponent component, String value) {
        // find based on String value param (Entity ID)
        return bookSvc.read(Long.valueOf(value));
    }

    /**
     * Converts a Book object to its String representation, typically the ID.
     * This is used when rendering an entity as a string in the UI, such as in dropdown menus or links.
     *
     * @param context The FacesContext current instance.
     * @param component The UIComponent with which this converter is associated.
     * @param value The Book object to be converted to a string.
     * @return A string representation of the Book object, typically its ID.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Book value) {
        // return Entity ID as String
        return String.valueOf(value.getId());
    }
    
}
