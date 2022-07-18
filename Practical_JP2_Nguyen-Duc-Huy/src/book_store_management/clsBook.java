/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_store_management;

/**
 *
 * @author Tuan
 */
public class clsBook {
    public String BookID;
    public String BookTitle;
    public String Author;
    public double Price;

    public clsBook() {
        BookID = "";
        BookTitle = "";
        Author = "";
        Price = 0.0;
    }

    public clsBook(String BookID, String BookTitle, String Author, double Price) {
        this.BookID = BookID;
        this.BookTitle = BookTitle;
        this.Author = Author;
        this.Price = Price;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getBookID() {
        return BookID;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public String getAuthor() {
        return Author;
    }

    public double getPrice() {
        return Price;
    }
    
    @Override
    public String toString(){
        return "BookID: " + this.BookID + ", Book Title: " + this.BookTitle + ", Author: " + this.Author + ", Price: " + this.Price;
    }
}
