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
     *
     */
    public LoanRecordService() {
        super(LoanRecord.class);
    }
    
    /**
     *
     * @param lr
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
     * @return
     */
    public List<LoanRecord> findAll() {
        return super.findAll("LoanRecord.findAll");
    }
    
}
