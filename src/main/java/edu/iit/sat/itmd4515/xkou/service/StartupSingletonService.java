/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.service;

import edu.iit.sat.itmd4515.xkou.domain.*;
import edu.iit.sat.itmd4515.xkou.security.Group;
import edu.iit.sat.itmd4515.xkou.security.GroupService;
import edu.iit.sat.itmd4515.xkou.security.User;
import edu.iit.sat.itmd4515.xkou.security.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Logger;

/**
 *
 * @author xiaoh
 */
@Startup
@Singleton
public class StartupSingletonService {

    private static final Logger LOG = Logger.getLogger(StartupSingletonService.class.getName());

    @EJB
    BookService bookSvc;
    @EJB
    TeacherService teacherSvc;
    @EJB
    StudentService stuSvc;
    @EJB
    LoanRecordService loanSvc;
    @EJB
    LibraryService libSvc;

    @EJB UserService userSvc;
    @EJB GroupService groupSvc;
    
    /**
     *
     */
    public StartupSingletonService() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("StartupSingletonService.postConstruct()");
        
//        Group vetGroup = new Group("VET_GROUP", "This is the group in the security realm representing vets");
//        Group ownerGroup = new Group("OWNER_GROUP", "The group representing owners in the security realm");
//        Group adminGroup = new Group("ADMIN_GROUP", "Group representing administrative users");
//        
//        groupSvc.create(vetGroup);
//        groupSvc.create(ownerGroup);
//        groupSvc.create(adminGroup);
//        
//        User book1 = new User("book1", "book1", true);
//        book1.addGroup(vetGroup);
//        book1.addGroup(adminGroup);
//        userSvc.create(book1);
//        
//        User book2 = new User("book2", "book2", true);
//        vet2.addGroup(vetGroup);
//        vet2.addGroup(ownerGroup);
//        userSvc.create(vet2);
//
//        User vet3 = new User("vet3", "vet3", true);
//        vet3.addGroup(vetGroup);
//        userSvc.create(vet3);
//
//        User owner1 = new User("owner1", "owner1", true);
//        owner1.addGroup(ownerGroup);
//        userSvc.create(owner1);
//        
//        User owner2 = new User("owner2", "owner2", true);
//        owner2.addGroup(ownerGroup);
//        userSvc.create(owner2);
//        
//        User admin = new User("admin", "admin", true);
//        admin.addGroup(adminGroup);
//        userSvc.create(admin);
        
        Group bookGroup = new Group("BOOK_GROUP", "This group represents books");
        Group teacherGroup = new Group("TEACHER_GROUP", "This group represents teachers");
        Group adminGroup = new Group("ADMIN_GROUP", "This group represents administrative users");

        groupSvc.create(bookGroup);        
        groupSvc.create(teacherGroup);
        groupSvc.create(adminGroup);
        
        User book1 = new User("book1", "book1", true);
        book1.addGroup(bookGroup);
        book1.addGroup(adminGroup);
        userSvc.create(book1);
        
        User book2 = new User("book2", "book2", true);
        book2.addGroup(bookGroup);
        book2.addGroup(teacherGroup);
        userSvc.create(book2);
        
        User book3 = new User("book3", "book3", true);
        book3.addGroup(bookGroup);
        userSvc.create(book3);
        
        User teacher1 = new User("teacher1", "teacher1", true);
        teacher1.addGroup(teacherGroup);
        userSvc.create(teacher1);
        
        User teacher2 = new User("teacher2", "teacher2", true);
        teacher2.addGroup(teacherGroup);
        userSvc.create(teacher2);
        
        User admin = new User("admin", "admin", true);
        admin.addGroup(adminGroup);
        userSvc.create(admin);
        
        Library li1 = new Library("Yifu");
        Library li2 = new Library("Mianyang");
        Library li3 = new Library("Nanshan");

        libSvc.create(li1);
        libSvc.create(li2);
        libSvc.create(li3);

        Student s1 = new Student("Lilei", LocalDate.of(2013, 9, 20), StudentGender.MAN);
        Student s2 = new Student("Hanmei", LocalDate.of(2012, 10, 21), StudentGender.WOMAN);
        Student s3 = new Student("Wangfang", LocalDate.of(2014, 9, 25), StudentGender.WOMAN);
        Student s4 = new Student("Zhangshan", LocalDate.of(2015, 9, 24), StudentGender.MAN);
        Student s5 = new Student("Liwu", LocalDate.of(2016, 9, 26), StudentGender.MAN);

        stuSvc.create(s1);
        stuSvc.create(s2);
        stuSvc.create(s3);
        stuSvc.create(s4);
        stuSvc.create(s5);

        Book b1 = new Book("Book One");
        b1.setUser(book1);
        b1.setLibrary(li3);
        Book b2 = new Book("Book Two");
        b2.setUser(book2);
        b2.setLibrary(li1);
        Book b3 = new Book("Book Three");
        b3.setUser(book3);
        b3.setLibrary(li2);

        bookSvc.create(b1);
        bookSvc.create(b2);
        bookSvc.create(b3);

        Teacher t1 = new Teacher("Teacher One", "teacherone@iit.edu", LocalDate.of(1980, 7, 20));
        Teacher t2 = new Teacher("Teacher Two", "teachertwo@iit.edu", LocalDate.of(1969, 1, 11));
        Teacher t3 = new Teacher("Teacher Three", "teacherthree@iit.edu", LocalDate.of(1970, 9, 25));
        t1.addStudent(s1);
        t1.addStudent(s2);
        t1.addStudent(s3);
        t1.setUser(teacher1);
        t2.addStudent(s3);
        t2.setUser(teacher2);
        t3.addStudent(s4);
        t3.addStudent(s5);
        t3.setUser(book2);

        teacherSvc.create(t1);
        teacherSvc.create(t2);
        teacherSvc.create(t3);

        LoanRecord lo1 = new LoanRecord(LocalDate.of(2023, 10, 20), LocalTime.of(9, 30), "Loan");
        lo1.schedLoan(t3, s5, b3);
        LoanRecord lo2 = new LoanRecord(LocalDate.of(2023, 10, 21), LocalTime.of(10, 20), "Loan");
        lo2.schedLoan(t2, s4, b1);
        loanSvc.create(lo2);
        loanSvc.create(lo1);

        LOG.info("================Teacher and their JPA Relationships==================");

        for (Teacher t : teacherSvc.findAll()) {
            LOG.info(t.toString());
            LOG.info("================Teacher relationship to student==================");
            for (Student s : t.getStudents()) {
                LOG.info("\t" + s.toString());
            }
            LOG.info("================Teacher relationship to LoanRecord==================");
            for (LoanRecord lo : t.getLrs()) {
                LOG.info("\t" + lo.toString());
            }
        }

        for (Book b : bookSvc.findAll()) {
            LOG.info(b.toString());
        }

    }

}
