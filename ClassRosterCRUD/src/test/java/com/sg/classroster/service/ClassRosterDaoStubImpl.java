/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minul
 */
public abstract class ClassRosterDaoStubImpl implements ClassRosterDao {
    
    // Member field of type Student that represents the one and only student in the DAO Stub
    public Student onlyStudent;
    
    // no - arg constructor taht instatniates a hard-coded student for out stub
    public ClassRosterDaoStubImpl() {
        onlyStudent = new Student("0001");
        onlyStudent.setFirstName("Ada");
        onlyStudent.setLastName("Lovelace");
        onlyStudent.setCohort("Java-May-1845");
    }
    
    // Allows test student to be injected via teh constructor by a test case
    public ClassRosterDaoStubImpl(Student testStudent) {
        this.onlyStudent = testStudent;
    }
    
    // Returns our only student field if the id matches lonelyStudents ID
    // otherwise it return null - no persistence here: inputted student never added toi the DAOstub/persisted in anyway
    
    @Override
    public Student addStudent(String studentId, Student student) 
            throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }
    
    // Returns a list containing the one and only student
    @Override
    public List<Student> getAllStudents()
                throws ClassRosterPersistenceException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(onlyStudent);
        return studentList;
    }
    
    // Returns our only student field if the id mathces our lonely student's ID, otherwise null
    @Override
    public Student getStudent(String studentId)
                throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }
    
    // Returns out only student field if ID matches our lonleyStudent's ID, null otherewise
    // NOTE: does not change/remove our only Studentexistence within our DAOStub
    @Override
    public Student removeStudent(String studentId)
                throws ClassRosterPersistenceException {
        if (studentId.equalsIgnoreCase(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }
}
