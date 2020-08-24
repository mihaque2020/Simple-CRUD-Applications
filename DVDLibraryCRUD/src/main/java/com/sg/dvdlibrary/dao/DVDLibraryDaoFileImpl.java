/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Minul
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    
    private List<DVD> dvds = new ArrayList<>();
    public static final String DVD_LIBRARY_FILE = "DVDLibrary.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public DVD addDVD(DVD dvd) 
     throws DVDLibraryDaoException {
        loadDVDLibrary();
        dvds.add(dvd);
        writeDVDLibrary();
        return dvd;
    }

    @Override
    public List<DVD> getAllDVDs() 
     throws DVDLibraryDaoException {
        loadDVDLibrary();
        return dvds;
    }
    
    // Will return any DVD that begins with the text entered into console
    @Override
    public List<DVD> getDVD(String title) 
     throws DVDLibraryDaoException {
        loadDVDLibrary();
        List<DVD> resultsList = new ArrayList<>();
        for (DVD currentDVD : dvds) {
            if (currentDVD.getTitle().toUpperCase().startsWith(title.toUpperCase())) {
                resultsList.add(currentDVD);
            }
        }
        return resultsList;
    }
    
    // Will only remove DVD entry if full text other than case matches
    @Override
    public DVD removeDVD(String title, String directorsName) 
     throws DVDLibraryDaoException {
        loadDVDLibrary();
        for (DVD currentDVD : dvds) {
            if(currentDVD.getTitle().equalsIgnoreCase(title) &&
                    currentDVD.getDirectorsName().equalsIgnoreCase(directorsName)) {
                dvds.remove(currentDVD);
                writeDVDLibrary();
                return  currentDVD;
            }
        }
        return null;
    }
    
    // Will only edit DVD Entry if full text other than case matches
    @Override
    public DVD editDVD(String title, String directorsName, DVD editedDVD) 
     throws DVDLibraryDaoException{
        loadDVDLibrary();
        for (int i = 0; i < dvds.size(); i++) {
            if (dvds.get(i).getTitle().equalsIgnoreCase(title) &&
                    dvds.get(i).getDirectorsName().equalsIgnoreCase(directorsName)) {
                dvds.set(i, editedDVD);
                writeDVDLibrary();
                return dvds.get(i);
            }
        }
        return null;
    }
    
    public boolean existEntry(String title, String directorsName) 
     throws DVDLibraryDaoException{
        for (DVD currentDVD : dvds) {
            if (currentDVD.getTitle().equalsIgnoreCase(title) &&
                    currentDVD.getDirectorsName().equalsIgnoreCase(directorsName)) {
                return true;
            }
        }
        return false;
    }
    
    private DVD unmarshallDVD(String dvdAsText){
        
        // DVDAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // Batman Begins::2005::PG-13::Christopher Nolan::Warner Bros. Pictures::Rating 
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in dvdTokens.
        // Which should look like this:
        // _________________________________________________________________________
        // |             |    |     |                 |                     |      |      
        // |Batman Begins|2005|PG-13|Christopher Nolan|Warner Bros. Pictures|Rating|
        // |             |    |     |                 |                     |      |
        // -------------------------------------------------------------------------
        //  [0]           [1]   [2]         [3]             [4]                [5]
        
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        // Given the pattern above, the student Id is in index 0 of the array.
        String title = dvdTokens[0];

        // Which we can then use to create a new DVD object to satisfy
        // the requirements of the DVD constructor.
        DVD dvdFromFile = new DVD(title);

        // However, there are 5 remaining tokens that need to be set into the
        // new DVD object. Do this manually by using the appropriate setters.

        // Index 1 - Release Date
        dvdFromFile.setReleaseDate(Integer.parseInt(dvdTokens[1]));

        // Index 2 - MPAA Rating
        dvdFromFile.setMpaaRating(dvdTokens[2]);

        // Index 3 - Director's Name
        dvdFromFile.setDirectorsName(dvdTokens[3]);
        
        // Index 4 Studio
         dvdFromFile.setStudio(dvdTokens[4]);
        
        // Index 5 User Review
        dvdFromFile.setUserRating(dvdTokens[5]);
        
        // We have now created a DVD Library Entry! Return it!
        return dvdFromFile;
    }
    
    private void loadDVDLibrary() throws DVDLibraryDaoException {
        dvds.clear();
        
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load DVD Library data into memory.", e);
        }
        
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDVD holds the most recent DVD unmarshalled
        DVD currentDVD;
        
        // Go through DVD_LIBRARY_FILE line by line, decoding each line into a 
        // DVD object by calling the unmarshallDVD method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a DVD
            currentDVD = unmarshallDVD(currentLine);
            // We are going to use the currentDVD object and add it to List<DVD>
            dvds.add(currentDVD);
        }
        // close scanner
        scanner.close();
    }
    
    private String marshallDVD(DVD dvdEntry){
        
        // We need to turn a DVD object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        
        // Batman Begins::2005::PG-13::Christopher Nolan::Warner Bros. Pictures::Rating 

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer. 

        // Start with the title, since that's supposed to be first.
        String dvdAsText = dvdEntry.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:

        // Release Date
        dvdAsText += dvdEntry.getReleaseDate() + DELIMITER;

        // MPAA Rating
        dvdAsText += dvdEntry.getMpaaRating() + DELIMITER;
        
        // Director's Name
        dvdAsText += dvdEntry.getDirectorsName() + DELIMITER;
        
        // Studio
        dvdAsText += dvdEntry.getStudio() + DELIMITER;
        
        // User Rating - don't forget to skip the DELIMITER here.
        dvdAsText += dvdEntry.getUserRating();

        // We have now turned a DVD to text! Return it!
        return dvdAsText;
    }
    
        /**
     * Writes all DVDs in the Library out to a DVD_Library_FILE.  See loadDVDLibrary
     * for file format.
     * 
     * @throws DVDLibraryDaoException if an error occurs writing to the file
     */
    private void writeDVDLibrary() throws DVDLibraryDaoException {
        
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save DVD data.", e);
        }

        // Write out the DVD objects to the DVDLibrary file.
        // get the Collection of DVDs and iterate over them 
        String dvdAsText;
        
        /*
        for (int i = 0; i < dvds.size(); i++) {
            // turn a DVD into a String            
            dvdAsText = marshallDVD(dvds.get(i));
            // write the DVD object to the file 
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close(); 
    }*/
        
        for (DVD currentDVD : dvds) {
            // turn a DVD into a String
            dvdAsText = marshallDVD(currentDVD);
            // write the DVD object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    } 
    
    
}