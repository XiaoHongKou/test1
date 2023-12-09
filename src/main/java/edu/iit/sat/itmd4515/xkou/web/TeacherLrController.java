/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.web;

import edu.iit.sat.itmd4515.xkou.domain.*;
import edu.iit.sat.itmd4515.xkou.service.LoanRecordService;
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
public class TeacherLrController {

    private static final Logger LOG = Logger.getLogger(TeacherLrController.class.getName());

    // Model
    private LoanRecord lr;
    @Inject TeacherWelcomeController twc;
    @EJB LoanRecordService lrSvc;
    
    /**
     * Default constructor.
     */
    public TeacherLrController() {
    }

    @PostConstruct
    private void postConstruct() {
        // initialize our model
        lr = new LoanRecord();
        
        // AND the model within the model...
        lr.setStudent(new Student());
        lr.setBook(new Book());
        //appt.setOwner(new Owner());
        lr.setTeacher(twc.getTeacher());
    }
    
    // MVC style action methods

    /**
     * Prepares the controller with a specific LoanRecord and navigates to the readLr page.
     *
     * @param lr The LoanRecord to be displayed.
     * @return The navigation path to the readLr page.
     */
    public String displayReadLrPage(LoanRecord lr){
        this.lr = lr;
        
        return "/teacher/readLr.xhtml";
    }
    
    /**
     * Prepares the controller for scheduling a LoanRecord for a specific student and navigates to the schedLr page.
     *
     * @param s The Student for whom the LoanRecord is to be scheduled.
     * @return The navigation path to the schedLr page.
     */
    public String displaySchedLrPage(Student s){
        // set the model
        lr.setStudent(s);
        // navigate to the page
        return "/teacher/schedLr.xhtml";
    }
    
    /**
     * Saves the LoanRecord and refreshes the teacher data.
     *
     * @return The navigation path to the teacher welcome page.
     */
    public String saveLr(){
        LOG.info("TeacherLrController.saveAppt with " + lr.toString());
        
        // we can not do this.  it does not manage relationships
        //apptSvc.create(appt);
        lrSvc.scheduleLr(lr);
        twc.refreshTeacher();
        return "/teacher/welcome.xhtml";
    }

    /**
     * Gets the LoanRecord model for this controller.
     *
     * @return The LoanRecord model.
     */
    public LoanRecord getLr() {
        return lr;
    }

    /**
     * Sets the LoanRecord model for this controller.
     *
     * @param lr The LoanRecord to be set.
     */
    public void setLr(LoanRecord lr) {
        this.lr = lr;
    }
}
