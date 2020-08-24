/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author Minul
 */
public interface DVDLibraryDao {
    
    /**
     * Adds the given DVD to the Collection and associates it with the given
     * title. If there is already a DVD associated with the given
     * title it will add it to the array list of DVD objects
     *
     * @param DVD dvd to be added to the Collection
     * @return the dvd entry
     */

    DVD addDVD(DVD dvd)
     throws DVDLibraryDaoException;
    
    /**
     * Returns a List of all DVDs in the Collection.
     *
     * @return List containing all DVDs in the Collection.
     */
    
    List<DVD> getAllDVDs()
     throws DVDLibraryDaoException;
    
    /**
     * Returns the dvd object associated with the given title.
     * Returns null if no such dvd exists
     *
     * @param title of the dvd to retrieve
     * @return the dvd object associated with the given dvd title,  
     * null if no such dvd exists
     */
    
    List<DVD> getDVD(String title)
     throws DVDLibraryDaoException;
    
    /**
     * Returns the DVD object after edits are complete
     * Prompts for new entry of all info
     * @param title of DVD to edit
     */
    
    DVD editDVD(String title, String directorsName, DVD editedDVD)
     throws DVDLibraryDaoException;
    
    /**
     * Removes from the Library the dvd associated with the given title.
     * Returns the dvd object that is being removed or null if
     * there is no dvd associated with the given title
     *
     * @param title of dvd to be removed
     * @return dvd object that was removed or null if no dvd
     * was associated with the given dvd title
    */
    
    DVD removeDVD(String title, String directorsName)
     throws DVDLibraryDaoException;
    
    /**
     * Determines if entry exists within list
     * @param title
     * @param directorsName
     * @return true/false if exists/doesn't exist
     */
    boolean existEntry(String title, String directorsName)
     throws DVDLibraryDaoException;
}
