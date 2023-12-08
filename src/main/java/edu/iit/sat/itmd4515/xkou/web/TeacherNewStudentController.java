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
     *
     */
    public TeacherNewStudentController() {
    }
    
    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside the StudentController.postConstruct method");
        
        stu = new Student();
    }
    
    /**
     *
     * @return
     */
    public String demoAction() {
        LOG.info("TeahcerNewStudentController.demlAction has been invoked with student + " + stu.toString());
        
        return "confirmation.xhtml";
    }
    
    /**
     *
     * @param s
     * @return
     */
    public String displayReadStudentPage(Student s) {
        this.stu = s;

        LOG.info("TeahcerNewStudentController.displayReadStudentPage has been invoked with pet + " + stu.toString());

        return "/teacher/readStudent.xhtml";
    }

    /**
     *
     * @param s
     * @return
     */
    public String displayUpdateStudentPage(Student s) {
        this.stu = s;

        LOG.info("TeahcerNewStudentController.displayUpdateStudentPage has been invoked with pet + " + stu.toString());

        return "/teacher/updateStudent.xhtml";
    }

    /**
     *
     * @param s
     * @return
     */
    public String displayDeleteStudentPage(Student s) {
        this.stu = s;

        LOG.info("TeahcerNewStudentController.displayDeleteStudentPage has been invoked with pet + " + stu.toString());

        return "/teacher/deleteStudent.xhtml";
    }
    
    /**
     *
     * @return
     */
    public String saveStu(){
        LOG.info("TeahcerNewStudentController.saveStu has been invoked with stu + " + stu.toString() + "and" + twc.getTeacher().toString());
        
        stuSvc.createStudentAndManageRelationships(stu, twc.getTeacher());

        LOG.info("TeahcerNewStudentController.saveStu after the EJV call + " + stu.toString());
        
        twc.refreshTeacher();
        
        return "/teacher/welcome.xhtml";
    }
    
    /**
     *
     * @return
     */
    public String updateStu() {
        LOG.info("TeahcerNewStudentController.updateStu has been invoked with pet + " + stu.toString() + " and " + twc.getTeacher().toString());
        stuSvc.updatePetAndManageRelationships(stu);
        twc.refreshTeacher();
        return "/teacher/welcome.xhtml";
    }

    /**
     *
     * @return
     */
    public String deleteStu() {
        LOG.info("TeahcerNewStudentController.deleteStu has been invoked with pet + " + stu.toString() + " and " + twc.getTeacher().toString());
        stuSvc.deleteStudentAndManageRelationships(stu, twc.getTeacher());
        twc.refreshTeacher();
        return "/teacher/welcome.xhtml";
    }
    
    /**
     *
     * @return
     */
    public StudentGender[] getAllStudentGenders(){
        return StudentGender.values();
    }
    
    /**
     *
     * @return
     */
    public Student getStu() {
        return stu;
    }

    /**
     *
     * @param stu
     */
    public void setStu(Student stu) {
        this.stu = stu;
    }
    
}
