/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

/**
 *
 * @author Minul
 */
public interface ClassRosterAuditDao {
    
    void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
    
}
