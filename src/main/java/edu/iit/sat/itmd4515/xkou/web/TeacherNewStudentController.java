/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.web;

import edu.iit.sat.itmd4515.xkou.domain.Student;
import edu.iit.sat.itmd4515.xkou.domain.StudentGender;
import edu.iit.sat.itmd4515.xkou.service.StudentService;
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
public class TeacherNewStudentController {
    
    private Student stu;
    
    @Inject TeacherWelcomeController twc;
    @EJB StudentService stuSvc;

    private static final Logger LOG = Logger.getLogger(TeacherNewStudentController.class.getName());
    
    /**
     * Default constructor.
     */
    public TeacherNewStudentController() {
    }
    
    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside the StudentController.postConstruct method");
        
        stu = new Student();
    }
    
    /**
     * Demonstrates an action method, typically used for logging and testing purposes.
     *
     * @return The navigation path for a confirmation page.
     */
    public String demoAction() {
        LOG.info("TeahcerNewStudentController.demlAction has been invoked with student + " + stu.toString());
        
        return "confirmation.xhtml";
    }
    
    /**
     * Prepares the controller with a specific Student and navigates to the readStudent page.
     *
     * @param s The Student to be displayed.
     * @return The navigation path to the readStudent page.
     */
    public String displayReadStudentPage(Student s) {
        this.stu = s;

        LOG.info("TeahcerNewStudentController.displayReadStudentPage has been invoked with pet + " + stu.toString());

        return "/teacher/readStudent.xhtml";
    }

    /**
     * Prepares the controller with a specific Student and navigates to the updateStudent page.
     *
     * @param s The Student to be updated.
     * @return The navigation path to the updateStudent page.
     */
    public String displayUpdateStudentPage(Student s) {
        this.stu = s;

        LOG.info("TeahcerNewStudentController.displayUpdateStudentPage has been invoked with pet + " + stu.toString());

        return "/teacher/updateStudent.xhtml";
    }

    /**
     * Prepares the controller with a specific Student and navigates to the deleteStudent page.
     *
     * @param s The Student to be deleted.
     * @return The navigation path to the deleteStudent page.
     */
    public String displayDeleteStudentPage(Student s) {
        this.stu = s;

        LOG.info("TeahcerNewStudentController.displayDeleteStudentPage has been invoked with pet + " + stu.toString());

        return "/teacher/deleteStudent.xhtml";
    }
    
    /**
     * Saves the new or updated Student details.
     *
     * @return The navigation path to the teacher welcome page.
     */
    public String saveStu(){
        LOG.info("TeahcerNewStudentController.saveStu has been invoked with stu + " + stu.toString() + "and" + twc.getTeacher().toString());
        
        stuSvc.createStudentAndManageRelationships(stu, twc.getTeacher());

        LOG.info("TeahcerNewStudentController.saveStu after the EJV call + " + stu.toString());
        
        twc.refreshTeacher();
        
        return "/teacher/welcome.xhtml";
    }
    
    /**
     * Updates the selected Student details.
     *
     * @return The navigation path to the teacher welcome page.
     */
    public String updateStu() {
        LOG.info("TeahcerNewStudentController.updateStu has been invoked with pet + " + stu.toString() + " and " + twc.getTeacher().toString());
        stuSvc.updatePetAndManageRelationships(stu);
        twc.refreshTeacher();
        return "/teacher/welcome.xhtml";
    }

    /**
     * Deletes the selected Student.
     *
     * @return The navigation path to the teacher welcome page.
     */
    public String deleteStu() {
        LOG.info("TeahcerNewStudentController.deleteStu has been invoked with pet + " + stu.toString() + " and " + twc.getTeacher().toString());
        stuSvc.deleteStudentAndManageRelationships(stu, twc.getTeacher());
        twc.refreshTeacher();
        return "/teacher/welcome.xhtml";
    }
    
    /**
     * Retrieves all possible student gender values.
     *
     * @return An array of all StudentGender enum values.
     */
    public StudentGender[] getAllStudentGenders(){
        return StudentGender.values();
    }
    
    /**
     * Gets the Student model for this controller.
     *
     * @return The Student model.
     */
    public Student getStu() {
        return stu;
    }

    /**
     * Sets the Student model for this controller.
     *
     * @param stu The Student to be set.
     */
    public void setStu(Student stu) {
        this.stu = stu;
    }
    
}
