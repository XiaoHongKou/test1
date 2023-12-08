/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.web;

import edu.iit.sat.itmd4515.xkou.domain.Teacher;
import edu.iit.sat.itmd4515.xkou.service.TeacherService;
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
public class TeacherWelcomeController {

    private static final Logger LOG = Logger.getLogger(TeacherWelcomeController.class.getName());

    @Inject LoginController loginController;
    @EJB TeacherService teacherSvc;
    
    // model for the Owner Welcome page
    // the Owner that is currently authenticated
    private Teacher teacher;

    /**
     *
     */
    public TeacherWelcomeController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside TeacherWelcomeController.postConstruct");
        teacher = teacherSvc.findByUsername(loginController.getCurrentUser());
        LOG.info("Leaving TeacherWelcomeController.postConstruct with " + teacher.toString());
    }
    
    /**
     *
     */
    public void refreshTeacher(){
        teacher = teacherSvc.findByUsername(loginController.getCurrentUser());
    }

    /**
     * Get the value of owner
     *
     * @return the value of owner
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Set the value of owner
     *
     * @param teacher
     * @param owner new value of owner
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


}
