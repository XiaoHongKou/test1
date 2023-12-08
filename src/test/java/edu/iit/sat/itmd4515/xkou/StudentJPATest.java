/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou;

import edu.iit.sat.itmd4515.xkou.domain.*;
import edu.iit.sat.itmd4515.xkou.domain.Student;
import edu.iit.sat.itmd4515.xkou.domain.StudentGender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author xiaoh
 */
public class StudentJPATest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    @BeforeAll
    public static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");

    }

    @BeforeEach
    public void beforeEach() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        Student s = new Student("Mike", LocalDate.of(2023, 4, 15), StudentGender.MAN);

        tx.begin();
        em.persist(s);
        tx.commit();
    }

    @Test
    public void createTest() {
        Student s = new Student("Judy", LocalDate.of(2023, 4, 15), StudentGender.WOMAN);

        tx.begin();
        em.persist(s);
        tx.commit();

        Student s1 = em.createQuery("select s "
                + "from Student s "
                + "where s.name = 'Judy'", Student.class)
                .getSingleResult();

        assertEquals(s.getName(), s1.getName());

        tx.begin();
        em.remove(s);
        tx.commit();
    }

    @Test
    public void readTest() {
        Student s = em.createQuery("select s "
                + "from Student s "
                + "where s.name = 'Mike'", Student.class)
                .getSingleResult();

        assertNotNull(s);

        assertTrue(s.getId() > 0);

        assertEquals("Mike", s.getName());
    }

    @Test
    public void updateTest() {
        Student s = em.createQuery("select s "
                + "from Student s "
                + "where s.name = 'Mike'", Student.class)
                .getSingleResult();

        assertNotNull(s);

        assertTrue(s.getId() > 0);

        assertEquals("Mike", s.getName());

        tx.begin();
        s.setGender(StudentGender.WOMAN);
        tx.commit();

        Student s1 = em.find(Student.class, s.getId());

        assertEquals(StudentGender.WOMAN, s1.getGender());
    }

    @Test
    public void deleteTest() {
        Student s = new Student("Judy", LocalDate.of(2023, 4, 15), StudentGender.WOMAN);

        tx.begin();
        em.persist(s);
        tx.commit();

        tx.begin();
        em.remove(s);
        tx.commit();
        
        try {
            Student s1 = em.createQuery("select s "
                    + "from Student s "
                    + "where s.name = 'Judy'", Student.class)
                    .getSingleResult();

            fail("Entity have been deleted");
        } catch (NoResultException e) {
        }

    }
    
     @Test
    public void uniDirectionalRelationshipTest(){
        Book b = new Book("Software Testing");
        Library l = new Library("YIFU");
        b.setLibrary(l);
        
        tx.begin();
        em.persist(b);
        em.persist(l);
        tx.commit();
        
        Book readBackFromDatabase = em.find(Book.class, b.getId());
        
        assertEquals("YIFU", readBackFromDatabase.getLibrary().getName());
    }
    
        @Test
    public void biDirectionalRelationshipTest(){
        Teacher t = new Teacher("Scott", "scott@iit.edu", LocalDate.of(1999, 1, 1));
        Student s = new Student("Rick", LocalDate.of(2022, 6, 9), StudentGender.MAN);

        t.addStudent(s);

        tx.begin();
        
        em.persist(t);
        em.persist(s);
        
        tx.commit();
        
        System.out.println("Navigating the relationship from the owning side: " + t.getStudents().toString());
        System.out.println("Navigating the relationship from the inverse side: " + s.getTeachers().toString());
        
        assertFalse(t.getStudents().isEmpty());
        assertTrue(s.getTeachers().size() == 1);
        assertNotNull(s.getId());
        assertTrue(t.getId() > 0);
        
        tx.begin();
        
        t.removeStudent(s);
        
        em.remove(t);
        em.remove(s);
        
        tx.commit();
    }

    @AfterEach
    public void afterEach() {
        Student s = em.createQuery("select s "
                + "from Student s "
                + "where s.name = 'Mike'", Student.class)
                .getSingleResult();

        tx.begin();
        em.remove(s);
        tx.commit();
    }

    @AfterAll
    public static void afterAll() {
        
    }
}
