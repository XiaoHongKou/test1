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
     *
     */
    public TeacherService() {
        super(Teacher.class);
    }
    
    /**
     *
     * @return
     */
    public List<Teacher> findAll() {
        return super.findAll("Teacher.findAll");
    }
    
    /**
     *
     * @param username
     * @return
     */
    public Teacher findByUsername(String username){
        return em
                .createNamedQuery("Teacher.findByUsername", Teacher.class)
                .setParameter("uname", username)
                .getSingleResult();
    }
}
