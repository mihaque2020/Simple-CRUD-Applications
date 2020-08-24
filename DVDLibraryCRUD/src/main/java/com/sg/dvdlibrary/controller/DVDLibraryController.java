/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author Minul
 */
public class DVDLibraryController {
    
    
    private DVDLibraryDao dao;
    private DVDLibraryView view;
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
    
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDVDLibrary();
                        break;
                    case 2:
                        createDVDEntry();
                        break;
                    case 3:
                        viewDVD(); 
                        break;
                    case 4:
                        editDVD();
                        break;
                    case 5:
                        removeDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }            
            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createDVDEntry() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD);
        view.displayCreateSuccessBanner();
    }
    
    private void listDVDLibrary() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdLibrary = dao.getAllDVDs();
        view.displayDVDLibrary(dvdLibrary);
    } 
    
    private void viewDVD() throws DVDLibraryDaoException {
        String title = view.getTitleSearch();
        view.displaySearchResultsBanner();
        List<DVD> searchResults = dao.getDVD(title);
        view.displayDVD(searchResults);
    }
    
    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();;
        String title = view.getTitleSearch();
        String directorsName = view.getDirectorsNameSearch();
        DVD removedDVD = dao.removeDVD(title, directorsName);
        view.displayRemoveResult(removedDVD);
    }
    
    private void editDVD() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        String title = view.getTitleSearch();
        String directorsName = view.getDirectorsNameSearch();
        
        if (dao.existEntry(title, directorsName)) {
            view.displayEnterEditsBanner();
            DVD editedDVD = view.getNewDVDInfo();
            DVD editDVD = dao.editDVD(title, directorsName, editedDVD);
            view.displayEditResult(editDVD);
        } else {
            view.noEntry();
        }
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
}
