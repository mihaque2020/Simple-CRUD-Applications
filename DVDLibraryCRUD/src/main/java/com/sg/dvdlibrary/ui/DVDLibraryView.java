/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author Minul
 */
public class DVDLibraryView {
    
    private UserIO io;
    
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List All DVDs");
        io.print("2. New DVD Entry");
        io.print("3. View DVD Info");
        io.print("4. Edit DVD Entry");
        io.print("5. Remove DVD Entry");
        io.print("6. Exit");

        return io.readInt("Please select from above choices", 1, 6);
    }
    
    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter DVD title");
        int releaseDate = io.readInt("Please enter DVD release date", 1850, 2020);
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorsName = io.readString("Please enter the director's name");
        String Studio = io.readString("Please enter DVD studio");
        String userRating = io.readString("Please enter a review or press spacebar and enter to leave blank");
        
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorsName(directorsName);
        currentDVD.setStudio(Studio);
        currentDVD.setUserRating(userRating);
        
        return currentDVD;
    }
    
    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }        
    
    public void displayCreateSuccessBanner() {
        io.readString("Entry successfully created.  Please hit enter to continue");
    }
    
    public void displayDVDLibrary(List<DVD> dvdLibrary) {
        for (DVD currentDVD : dvdLibrary) {
            String dvdInfo = String.format("Title: %s\n"
                    + "Release Date: %s\n"
                    + "Director: %s\n",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getDirectorsName());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    
    public void displaySearchResultsBanner() {
        io.print("=== Search Results ===");
    }
    
    public String getTitleSearch() {
        return io.readString("Please enter a title");
    }
    
    public String getDirectorsNameSearch() {
        return io.readString("Please enter the directors name");
    }
    
    public void displayDVD(List<DVD> dvds) {
        
        for (DVD currentDVD : dvds) {
            if (currentDVD != null) {
                io.print(currentDVD.getTitle());
                io.print(Integer.toString(currentDVD.getReleaseDate()));
                io.print(currentDVD.getMpaaRating());
                io.print(currentDVD.getDirectorsName());
                io.print(currentDVD.getStudio());
                io.print(currentDVD.getUserRating());
                io.print("");
            } else {
                io.print("No such DVD");
            }
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }
    
    public void displayRemoveResult(DVD removedDVD) {
        if (removedDVD != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such entry.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");        
    }
    
    public void displayEditResult(DVD editDVD) {
        if (editDVD != null) {
            io.print("DVD successfully edited");
        } else {
            io.print("No such entry.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayEnterEditsBanner() {
        io.print("=== Enter DVD Edits ==="); 
    }
    
    public void noEntry() {
        io.print("No such entry.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
