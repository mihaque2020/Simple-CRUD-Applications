/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Minul
 */
public class ClassRosterDaoFileImplTest {

    ClassRosterDao testDao;

    public ClassRosterDaoFileImplTest() {
    }

    // Before each test, we create a new, blank testroster.txt file using the File Writer
    // Then use that as our file name when instantiatign our testDAo
    @BeforeEach
    public void setUp() throws IOException {
        String testFile = "testroster.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new ClassRosterDaoFileImpl(testFile);
    }

    @Test
    public void testAddGetStudent() throws Exception {
        // Arrange - Create our method test inputs;
        String studentId = "0001";
        Student student = new Student(studentId);
        student.setFirstName("Ada");
        student.setLastName("Lovelace");
        student.setCohort("Java-May-1845");

        // Act - add the student to the DAO
        testDao.addStudent(studentId, student);
        // Get the student from the DAO
        Student retrievedStudent = testDao.getStudent(studentId);

        // Assert - Check that the data is equal
        assertEquals(student.getStudentId(),
                retrievedStudent.getStudentId(),
                "Checking student id.");
        assertEquals(student.getFirstName(),
                retrievedStudent.getFirstName(),
                "Checking student first name.");
        assertEquals(student.getLastName(),
                retrievedStudent.getLastName(),
                "Checking student last name.");
        assertEquals(student.getCohort(),
                retrievedStudent.getCohort(),
                "Checking student cohort.");
    }

    @Test
    public void testAddGetAllStudents() throws Exception {
        // Arrange - Create two Student objects and then add them to the DAO

        // Arrange 1 - Create out first Student
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1845");

        // Arrange 2 - Create our second student
        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1845");

        // Arrange 3 - Add both Students to the Dao
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);

        // Act - Get all students from the DAO
        // Retrieve list of all students within the DAO
        List<Student> allStudents = testDao.getAllStudents();

        // Assert - Check that DAO returnted the two student objects
        // Assert 1 - first check the general contents of the list
        assertNotNull(allStudents, "The list of students must not be null");
        assertEquals(2, allStudents.size(), "L:ist of students should have 2 students");

        // Then check the specific contents of each Student object if they match what was defined in ARRANGE
        assertTrue(testDao.getAllStudents().contains(firstStudent),
                "The list of students should include Ada");
        assertTrue(testDao.getAllStudents().contains(secondStudent),
                "The list of students should include Charles");

        // These tests will fail if equals/hashCode additions were not made to the Student Class
    }

    @Test
    public void testRemoveStudent() throws Exception {
        // Arrange - Create two student objects
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1945");

        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1945");

        // Act - add both to the DAO
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);

        // Act - Remove one(first) Student
        Student removedStudent = testDao.removeStudent(firstStudent.getStudentId());

        // Assert - Check that the correct object was removed
        assertEquals(removedStudent, firstStudent, "The removed student should be Ada");

        // Assert - Check to see if there is onle one student left in the DAO
        // (Get all students)
        List<Student> allStudents = testDao.getAllStudents();

        // Assert - first general check
        assertNotNull(allStudents, "All students list should not be null");
        assertEquals(1, allStudents.size(), "All students should only have 1 student");

        // Assert - second check specifics
        assertFalse(allStudents.contains(firstStudent.getStudentId()),
                "All students should NOT include Ada.");
        assertTrue(allStudents.contains(secondStudent.getStudentId()),
                "All students should include Charles");

        // Act - Remove other(second) student
        removedStudent = testDao.removeStudent(secondStudent.getStudentId());

        // Assert - check that correct student was removed
        assertEquals(removedStudent, secondStudent, "The removed student should be Charles.");

        // Act - Retrieve all students and check the list
        allStudents = testDao.getAllStudents();

        // Assert - Check the contents of the list - should be empty
        assertTrue(allStudents.isEmpty(), "The list of students should be empty");

        // Assert - Try to get both students by tehir old id - should be null
        Student retrievedStudent = testDao.getStudent(firstStudent.getStudentId());
        assertNull(retrievedStudent, "Ada was removed, should be null");
        
        retrievedStudent = testDao.getStudent(secondStudent.getStudentId());
        assertNull(retrievedStudent, "Charles was removed, should be null.");
    }
}
