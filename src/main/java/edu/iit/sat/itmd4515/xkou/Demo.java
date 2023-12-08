/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou;

import edu.iit.sat.itmd4515.xkou.domain.Student;
import edu.iit.sat.itmd4515.xkou.domain.StudentGender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

/**
 *
 * @author xiaoh
 */
public class Demo {

    /**
     *
     * @param args
     */
    public static void main(String... args) {
        
        Student s = new Student("Mike", LocalDate.of(2023, 4, 15), StudentGender.MAN);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
    
        System.out.println(em.getProperties());
        
        System.out.println(s.toString());
        
        tx.begin();
        
        em.persist(s);
        
        tx.commit();
    
        System.out.println(s.toString());
                
        em.close();
    }
}
