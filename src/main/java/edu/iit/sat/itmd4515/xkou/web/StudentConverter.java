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
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Student getAsObject(FacesContext context, UIComponent component, String value) {
        // find based on String value param (Entity ID)
        return studentSvc.read(Long.valueOf(value));
    }

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Student value) {
        // return Entity ID as String
        return String.valueOf(value.getId());
    }
    
}
