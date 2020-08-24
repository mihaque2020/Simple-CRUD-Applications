/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minul
 */
public class LibraryBook {
    
    private String title;
    private String author;
    private String publisher;
    private String libraryCode;
    
    public LibraryBook(String title, String author, String libraryCode) {
        this.title = title;
        this.author = author;
        this.libraryCode = libraryCode;
    }
    
    public void setLibraryCode(String libraryCode) {
        this.libraryCode = libraryCode;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public String getLibraryCode() {
        return libraryCode;
    }
    
}
