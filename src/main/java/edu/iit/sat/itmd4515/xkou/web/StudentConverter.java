/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.web;

import edu.iit.sat.itmd4515.xkou.domain.Student;
import edu.iit.sat.itmd4515.xkou.service.StudentService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author xiaoh
 */
@FacesConverter(value = "studentConverter", managed = true)
public class StudentConverter implements Converter<Student>{

    @EJB StudentService studentSvc;
    
    /**
     * Converts a String value (such as an ID) to a Student object.
     * This is typically used when converting form submission data back into entity objects.
     *
     * @param context The FacesContext current instance.
     * @param component The UIComponent with which this converter is associated.
     * @param value The string value to be converted to a Student object.
     * @return The Student object that corresponds to the provided string value.
     */
    @Override
    public Student getAsObject(FacesContext context, UIComponent component, String value) {
        // find based on String value param (Entity ID)
        return studentSvc.read(Long.valueOf(value));
    }

    /**
     * Converts a Student object to its String representation, typically the ID.
     * This is used when rendering an entity as a string in the UI, such as in dropdown menus or links.
     *
     * @param context The FacesContext current instance.
     * @param component The UIComponent with which this converter is associated.
     * @param value The Student object to be converted to a string.
     * @return A string representation of the Student object, typically its ID.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Student value) {
        // return Entity ID as String
        return String.valueOf(value.getId());
    }
    
}
