///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package edu.iit.sat.itmd4515.xkou;
//
//import edu.iit.sat.itmd4515.xkou.domain.Student;
//import edu.iit.sat.itmd4515.xkou.domain.StudentGender;
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;
//import java.time.LocalDate;
//import java.util.Set;
//import org.junit.jupiter.api.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class StudentValidationTest {
//
//    private static Validator validator;
//    private Student student;
//
//    private void assertNoConstraintViolations(Student student) {
//        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
//        assertEquals(0, constraintViolations.size());
//    }
//
//    private void assertConstraintViolation(Student student, String expectedMessage) {
//        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
//        assertEquals(1, constraintViolations.size());
//        assertEquals(expectedMessage, constraintViolations.iterator().next().getMessage());
//    }
//
//    @BeforeAll
//    public static void beforeAll() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }
//
//    @BeforeEach
//    public void beforeEach() {
//        student = new Student("Judy", LocalDate.of(2023, 4, 15), StudentGender.WOMAN);
//    }
//
//    @Test
//    public void studentIsValid() {
//        assertNoConstraintViolations(student);
//    }
//
//    @Test
//    public void studentIdIsInvalid() {
//        student.setId(99L);
//        assertConstraintViolation(student, "must be greater than 0");
//    }
//
//    @Test
//    public void studentNameIsInvalid() {
//        student.setName("Rick");
//        assertConstraintViolation(student, "must not be blank");
//    }
//
//    @Test
//    public void studentAdmissionDateIsInvalid() {
//        student.setAdmissionDate(LocalDate.of(2021, 4, 15));
//        assertConstraintViolation(student, "must be a past or present date");
//    }
//
//}
