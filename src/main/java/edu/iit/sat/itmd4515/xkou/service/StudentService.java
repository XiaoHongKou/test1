/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.service;

import edu.iit.sat.itmd4515.xkou.domain.LoanRecord;
import edu.iit.sat.itmd4515.xkou.domain.Student;
import edu.iit.sat.itmd4515.xkou.domain.Teacher;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xiaoh
 */
@Named
@Stateless
public class StudentService extends AbstractService<Student>{

    /**
     * Default constructor initializing with Student entity class.
     */
    public StudentService() {
        super(Student.class);
    }
    
    /**
     *
     * Retrieves a list of all Student entities.
     * 
     * @return A list of Student entities.
     */
    public List<Student> findAll() {
        return super.findAll("Student.findAll");
    }
    
    /**
     *
     * Creates a Student entity and manages its relationships with a Teacher entity.
     * 
     * @param s The Student entity to be created.
     * @param t The Teacher entity to be associated with the student.
     */
    public void createStudentAndManageRelationships(Student s, Teacher t){
        em.persist(s);
        
        Teacher managedTeacherReference = em.getReference(Teacher.class, t.getId());
        managedTeacherReference.addStudent(s);
        em.merge(managedTeacherReference);
    }
    
    /**
     *
     * Updates a Student entity and manages its relationships.
     * 
     * @param s The Student entity with updated fields.
     */
    public void updatePetAndManageRelationships(Student s){
        // First step - we need a managed entity to work with in JPA
        Student managedPetRef = em.getReference(Student.class, s.getId());
        
        // Second step - we know what fields are updated, because we know what
        // fields were available to use on the form.  The updated info is in the param
        managedPetRef.setName(s.getName());
        managedPetRef.setAdmissionDate(s.getAdmissionDate());
        managedPetRef.setGender(s.getGender());
        
        // Final step - merge the updated managed entity ref into the database
        em.merge(managedPetRef);
    }
    
    /**
     * Deletes a Student entity and manages its relationships, including removing related LoanRecords.
     * @param s The Student entity to be deleted.
     * @param t The Teacher entity associated with the student.
     */
    public void deleteStudentAndManageRelationships(Student s, Teacher t) {
        Student managedPetRef = em.getReference(Student.class, s.getId());
//        Owner managedOwnerRef = em.getReference(Owner.class, o.getId());

        List<LoanRecord> lrs = 
                em.createNamedQuery("LoanRecord.findLrsByStudentID", LoanRecord.class)
                        .setParameter("stuid", s.getId())
                        .getResultList();
        
        for (LoanRecord lr : lrs) {
            lr.removeLoan();
            em.remove(lr);
        }
        
//        for(Teacher owner : managedPetRef.getOwners()) {
        for(Teacher teacher : new ArrayList<Teacher>(managedPetRef.getTeachers())) {
//            LOG.info("Removing pet from owner: " + teacher.toString());
            teacher.removeStudent(managedPetRef);
            em.merge(teacher);
        }
        
        em.remove(managedPetRef);
        
    }
    
}
