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
import java.util.List;

/**
 *
 * @author Minul
 */
public class ClassRosterServiceLayerImpl implements 
        ClassRosterServiceLayer{
    
    private ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;
    
    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    public void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException {
        
        // First check if there is already a student with that ID
        // If so...Done here and throw ClassRosterDuplicateIdException
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(
                    "ERROR: Could not create student. Student ID: "
                    + student.getStudentId()
                    + " already exists");
        }
        
        // Now validate all the fields of the given student
        // Methods throws if validation rules violated
        validateStudentData(student);
        
        // At this point, all business rule checks 
        // So, persist the new student object
        dao.addStudent(student.getStudentId(), student);
        
        // The student was successfully created, and can now
        // be written to the audit log
        auditDao.writeAuditEntry(
                "Student " + student.getStudentId() + " CREATED");
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        //Write Audit log
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }
    
    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {
        
        if(student.getFirstName() == null
            || student.getFirstName().trim().length() == 0
            || student.getLastName() == null
            || student.getLastName().trim().length() == 0
            || student.getCohort() == null
            || student.getCohort().trim().length() == 0) {
            
            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
}
