/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Minul
 */
public class ClassRosterServiceLayerImplTest {

    // Need to create the Service Layer object and wire in our stub DAO's
    private ClassRosterServiceLayer service;

    // Need to create the Service Layer object and wire in our stub DAO's
    public ClassRosterServiceLayerImplTest() {
        ClassRosterDao dao = new ClassRosterDaoStubImpl() {
        };
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();

        service = new ClassRosterServiceLayerImpl(dao, auditDao);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // Assertung that the creation of a claid Student (no duplicate ID/values) 
    // doesnt casue exception to be thrown
    @Test
    public void testCreateVlaidStudent() {
        // ARRANGE
        Student student = new Student("002");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        // ACT
        try {
            service.createStudent(student);
        } catch (ClassRosterDuplicateIdException
                | ClassRosterDataValidationException
                | ClassRosterPersistenceException e) {
            // ASSERT
            fail("Student was valid. No exception should have been thrown.");
        }
    }

    // Asserts that ClassRosterDuplicateIdException is thrown when trying 
    // to create a student wtih an existing ID
    // We know stubbed implementeation of Class Roster DAO has existing student 
    // w/ ID: 0001, so attempt tp create a new student with that ID
    // B/c we expect an exception to be thrown, we surround it w/ try-catch
    // If call executes and no exception thrown, we fail the test with a message 
    // saying we expected an exception to be thrown
    // If expected exception thrown, return. Since no errors/exceptions - test passed
    // If different exception thrown, test will fail
    @Test
    public void testCreateDuplicateIdStudent() {
        // ARRANGE
        Student student = new Student("0001");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        // ACT
        try {
            service.createStudent(student);
            fail("expected DupeId Exception was not thrown.");
        } catch (ClassRosterDataValidationException
                | ClassRosterPersistenceException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (ClassRosterDuplicateIdException e) {
            return;
        }
    }

    /**
     * This test is similar to the test for duplicate Student Id. Here we ensure
     * that we don’t have a duplicate Student Id and then also leave one of the
     * fields blank. We use the same try/catch techniques as shown in the
     * previous example except we are looking for a different exception.
     */
    @Test
    public void testCreateStudentInvalidData() throws Exception {

        // ARRANGE
        Student student = new Student("0002");
        student.setFirstName("");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        // ACT
        try {
            service.createStudent(student);
            fail("Expected ValidationException was not thrown.");
        } catch (ClassRosterDuplicateIdException
                | ClassRosterPersistenceException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (ClassRosterDataValidationException e) {
            return;
        }
    }

    /**
     * b/c we know the stubbed Class Roster DAO only contains one Student, we
     * assert only one Student is returned from getAllStudents Service Layer
     * method:
     */
    @Test
    public void testGetAllStudents() throws Exception {
        // ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // ACT & ASSERT
        assertEquals(1, service.getAllStudents().size(),
                "Should only have one student.");
        assertTrue(service.getAllStudents().contains(testClone),
                "The one student should be Ada.");
    }

    // Since we know that the stubbed Class Roster DAO only contains on Student 
    // with Student Id = 0001, we assert that a Student is returned when we ask 
    // for Student Id 0001 and that no student is returned when we ask for 
    // Student Id 0042:
    @Test
    public void testGetStudent() throws Exception {
        // ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // ACT & ASSERT
        Student shouldBeAda = service.getStudent("0001");
        assertNotNull(shouldBeAda, "Getting 0001 should be not null.");
        assertEquals(testClone, shouldBeAda,
                "Student stored under 0001 should be Ada.");

        Student shouldBeNull = service.getStudent("0042");
        assertNull(shouldBeNull, "Getting 0042 should be null.");

    }
    
    
    // The behavior of the removeStudent method is that it will remove the 
    // Student and return the associated Student object if a Student exists for 
    // the given Student Id. Otherwise, it will do nothing and return null. 
    // Here we assert that a Student object is returned when we remove 
    // Student Id 0001 and that null is returned when we remove Student Id 0042:
    @Test
    public void testRemoveStudent() throws Exception {
        // ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // ACT & ASSERT
        Student shouldBeAda = service.removeStudent("0001");
        assertNotNull(shouldBeAda, "Removing 0001 should be not null.");
        assertEquals(testClone, shouldBeAda, "Student removed from 0001 should be Ada.");

        Student shouldBeNull = service.removeStudent("0042");
        assertNull(shouldBeNull, "Removing 0042 should be null.");
    }
}
