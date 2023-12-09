/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.service;

import edu.iit.sat.itmd4515.xkou.domain.Teacher;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author xiaoh
 */
@Named
@Stateless
public class TeacherService extends AbstractService<Teacher> {
    
    /**
     * Default constructor initializing with Teacher entity class.
     */
    public TeacherService() {
        super(Teacher.class);
    }
    
    /**
     * Retrieves a list of all Teacher entities.
     * @return A list of Teacher entities.
     */
    public List<Teacher> findAll() {
        return super.findAll("Teacher.findAll");
    }
    
    /**
     *
     * Finds a Teacher entity by the username of its associated user.
     * 
     * @param username The username to search for.
     * @return The Teacher entity associated with the specified username.
     */
    public Teacher findByUsername(String username){
        return em
                .createNamedQuery("Teacher.findByUsername", Teacher.class)
                .setParameter("uname", username)
                .getSingleResult();
    }
}
