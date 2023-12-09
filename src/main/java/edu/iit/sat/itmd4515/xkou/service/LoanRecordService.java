/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.service;

import edu.iit.sat.itmd4515.xkou.domain.LoanRecord;
import edu.iit.sat.itmd4515.xkou.domain.*;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author xiaoh
 */
@Stateless
public class LoanRecordService extends AbstractService<LoanRecord>{

    /**
     * Default constructor initializing with LoanRecord entity class.
     */
    public LoanRecordService() {
        super(LoanRecord.class);
    }
    
    /**
     *
     * Schedules a new LoanRecord.
     * This involves creating a new LoanRecord entity and associating it with the relevant Teacher, Student, and Book entities.
     * @param lr The LoanRecord entity carrying the data to be scheduled.
     */
    public void scheduleLr(LoanRecord lr) {
        // given that appt the parameter has so many relationships it is carrying...
        // create a new managed entity to start working with.
        // in other owrds, use the parameter as a carrier again
        LoanRecord newLr = new LoanRecord();
        newLr.setType(lr.getType());
        newLr.setDate(lr.getDate());
        newLr.setTime(lr.getTime());
        
        newLr.schedLoan(
                em.getReference(Teacher.class, lr.getTeacher().getId()),
                em.getReference(Student.class, lr.getStudent().getId()),
                em.getReference(Book.class, lr.getBook().getId())
        );
        
        em.persist(newLr);
    }
    
    /**
     *
     * Retrieves a list of all LoanRecord entities.
     * 
     * @return A list of LoanRecord entities.
     */
    public List<LoanRecord> findAll() {
        return super.findAll("LoanRecord.findAll");
    }
    
}
