# LAB 4
itmd4515-f23-fp-XiaoHongKou created by GitHub Classroom

## JPA Test
<img width="1800" alt="截屏2023-09-25 08 42 34" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/61436cd1-6f94-4e00-b6c5-8b6fb0a2f79b">

```java
Running edu.iit.sat.itmd4515.xkou.StudentJPATest
9月 25, 2023 9:07:55 上午 org.hibernate.validator.internal.util.Version <clinit>
INFO: HV000001: Hibernate Validator 8.0.1.Final
[EL Info]: 2023-09-25 09:07:55.921--ServerSession(1187972599)--EclipseLink, version: Eclipse Persistence Services - 3.0.3.v202208191135
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.708 s - in edu.iit.sat.itmd4515.xkou.StudentJPATest

Results:

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  1.883 s
Finished at: 2023-09-25T09:07:56+08:00
------------------------------------------------------------------------
```

## Validation Test
<img width="1800" alt="截屏2023-09-25 08 41 49" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/bfa7c8ab-c28e-4203-8718-02723b2ccdae">

```java
Running edu.iit.sat.itmd4515.xkou.StudentValidationTest
9月 25, 2023 9:14:30 上午 org.hibernate.validator.internal.util.Version <clinit>
INFO: HV000001: Hibernate Validator 8.0.1.Final
Tests run: 4, Failures: 3, Errors: 0, Skipped: 0, Time elapsed: 0.213 s <<< FAILURE! - in edu.iit.sat.itmd4515.xkou.StudentValidationTest
edu.iit.sat.itmd4515.xkou.StudentValidationTest.studentAdmissionDateIsInvalid  Time elapsed: 0.06 s  <<< FAILURE!
org.opentest4j.AssertionFailedError: expected: <must be a past or present date> but was: <需要是一个过去或现在的时间>
	at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:151)
	at org.junit.jupiter.api.AssertionFailureBuilder.buildAndThrow(AssertionFailureBuilder.java:132)
	at org.junit.jupiter.api.AssertEquals.failNotEqual(AssertEquals.java:197)
	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:182)
	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:177)
	at org.junit.jupiter.api.Assertions.assertEquals(Assertions.java:1141)
	at edu.iit.sat.itmd4515.xkou.StudentValidationTest.assertConstraintViolation(StudentValidationTest.java:32)
	at edu.iit.sat.itmd4515.xkou.StudentValidationTest.studentAdmissionDateIsInvalid(StudentValidationTest.java:66)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)

edu.iit.sat.itmd4515.xkou.StudentValidationTest.studentNameIsInvalid  Time elapsed: 0.001 s  <<< FAILURE!
org.opentest4j.AssertionFailedError: expected: <must not be blank> but was: <不能为空>
	at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:151)
	at org.junit.jupiter.api.AssertionFailureBuilder.buildAndThrow(AssertionFailureBuilder.java:132)
	at org.junit.jupiter.api.AssertEquals.failNotEqual(AssertEquals.java:197)
	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:182)
	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:177)
	at org.junit.jupiter.api.Assertions.assertEquals(Assertions.java:1141)
	at edu.iit.sat.itmd4515.xkou.StudentValidationTest.assertConstraintViolation(StudentValidationTest.java:32)
	at edu.iit.sat.itmd4515.xkou.StudentValidationTest.studentNameIsInvalid(StudentValidationTest.java:60)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)

edu.iit.sat.itmd4515.xkou.StudentValidationTest.studentIdIsInvalid  Time elapsed: 0.001 s  <<< FAILURE!
org.opentest4j.AssertionFailedError: expected: <1> but was: <0>
	at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:151)
	at org.junit.jupiter.api.AssertionFailureBuilder.buildAndThrow(AssertionFailureBuilder.java:132)
	at org.junit.jupiter.api.AssertEquals.failNotEqual(AssertEquals.java:197)
	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:150)
	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:145)
	at org.junit.jupiter.api.Assertions.assertEquals(Assertions.java:527)
	at edu.iit.sat.itmd4515.xkou.StudentValidationTest.assertConstraintViolation(StudentValidationTest.java:31)
	at edu.iit.sat.itmd4515.xkou.StudentValidationTest.studentIdIsInvalid(StudentValidationTest.java:54)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)

Results:

Failures: 
  StudentValidationTest.studentAdmissionDateIsInvalid:66->assertConstraintViolation:32 expected: <must be a past or present date> but was: <需要是一个过去或现在的时间>
  StudentValidationTest.studentIdIsInvalid:54->assertConstraintViolation:31 expected: <1> but was: <0>
  StudentValidationTest.studentNameIsInvalid:60->assertConstraintViolation:32 expected: <must not be blank> but was: <不能为空>

Tests run: 4, Failures: 3, Errors: 0, Skipped: 0

------------------------------------------------------------------------
BUILD FAILURE
------------------------------------------------------------------------
Total time:  1.417 s
Finished at: 2023-09-25T09:14:31+08:00
------------------------------------------------------------------------
Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0:test (default-cli) on project xkou-fp: There are test failures.

Please refer to /Users/xiaoh/Documents/document/515/week4/xkou-fp/target/surefire-reports for the individual test results.
Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
-> [Help 1]

To see the full stack trace of the errors, re-run Maven with the -e switch.
Re-run Maven using the -X switch to enable full debug logging.

For more information about the errors and possible solutions, please read the following articles:
[Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```

## Business Domain Description

I have chosen to work with the education domain, focusing specifically on managing student information within an academic institution. This domain is integral to the functioning of educational organizations, as it encompasses various aspects such as student enrollment, course management, and grading. I selected this domain because it offers a diverse range of functionalities and relationships to explore, and it is a fundamental area that impacts a wide audience, including students, educators, and administrative staff. The complexities and multifaceted nature of this domain provide ample opportunities for developing a robust and comprehensive system.

## Additional Entities and Relationships

Beyond the `Student` entity required for Lab 4, several other entities can be identified within the education domain. These include `Course`, `Instructor`, `Enrollment`, and `Grade`. The `Course` entity represents the academic courses offered by the institution, with attributes such as course name, course code, and credits. The `Instructor` entity signifies the teaching staff, with details like instructor name, department, and contact information.

The relationships among these entities can be illustrated as follows:
- A `Student` can enroll in multiple `Courses`, and a `Course` can have multiple students enrolled. This many-to-many relationship can be represented through an associative entity called `Enrollment`, which may also store additional information such as enrollment date.
- An `Instructor` can teach multiple `Courses`, establishing a one-to-many relationship between `Instructor` and `Course`.
- The `Grade` entity can be associated with the `Enrollment` entity, representing the grades students receive for their enrolled courses. This establishes a one-to-one relationship between `Enrollment` and `Grade`.

These entities and relationships form the foundation of a student information management system within the education domain, allowing for the representation and management of various aspects of academic life. Designing a database incorporating these entities will facilitate the development of a comprehensive final project, addressing the diverse needs of the education sector.
