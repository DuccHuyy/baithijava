/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_store_management;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan
 */
public class BookStoreManagement {
    public static ArrayList<clsBook> listBook = new ArrayList<clsBook>();
    
    public static void AddBook(){
        Scanner input = new Scanner(System.in);
        
        String bookID;
        String bookTile;
        String author;
        double price;
        
        System.out.println("Enter book id:");
        bookID = input.nextLine();
        System.out.println("Enter book name:");
        bookTile = input.nextLine();
        System.out.println("Enter book of author.");
        author = input.nextLine();
        System.out.println("Enter Price of book.");
        price = clsUntilitise.InputDouble();
        clsBook book = new clsBook(bookID, bookTile, author, price);
        listBook.add(book);
    }
    
    public static void ReadFile(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("books.dat");
            ois = new ObjectInputStream(fis);
            //listBook.clear();
            int n = ois.readInt();
            for(int i = 0; i < n; i++){
                clsBook book = (clsBook) ois.readObject();
                listBook.add(book);
            }
            System.out.println("Load file success.");
        } catch (FileNotFoundException ex) {
            System.out.println("File not exists.");
            //Logger.getLogger(BookStoreManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("File opening error.");
            //Logger.getLogger(BookStoreManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if(ois != null) ois.close();
                if(fis != null) fis.close();
            } catch (IOException ex) {
               System.out.println("File closing error"); 
               // Logger.getLogger(BookStoreManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void WriteFile(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("books.dat", false);
            oos = new ObjectOutputStream(fos);
            oos.writeInt(listBook.size());
            for(int i = 0; i < listBook.size(); i++){
                oos.writeObject(listBook.get(i));
            }
            System.out.println("Write success.");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
            //Logger.getLogger(BookStoreManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("File write error.");
            //Logger.getLogger(BookStoreManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if(oos != null) oos.close();
                if(fos != null) fos.close();
            } catch (IOException ex) {
                System.out.println("File closing error.");
               //Logger.getLogger(BookStoreManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void DisplayListBook(){
        if(listBook.size() > 0){
            int n = listBook.size();
            System.out.println("Display " + n + " Book: ");
            System.out.println("   BookID          Book Name         Author       Price");
            System.out.println("  ----------     --------------     --------     ----------");
            
            listBook.forEach((book) ->{
                System.out.printf("%9s", book.getBookID());
                System.out.printf("%15s", book.getBookTitle());
                System.out.printf("%20s \n", book.getAuthor());
                System.out.printf("%40s $\n", book.getPrice());
            });
        }else{
            
        }
    }
    
    
    public static int Menu(){
        int select;
        System.out.println("Menu.");
        System.out.println("1.Add book records.");
        System.out.println("2.Save.");
        System.out.println("3.Display book records.");
        System.out.println("4.Exit.");
        System.out.println("Enter number from 1 to 4.");
        select = clsUntilitise.InputInt();
        return select;
    }
    
    
    public static void main(String[] args) {
        int select;
        do{
            select = Menu();
            switch(select){
                case 1:
                    AddBook();
                    break;
                case 2:
                    WriteFile();
                    break;
                case 3:
                    ReadFile();
                    DisplayListBook();
                    break;
                case 4:
                    System.out.println("Goobye.");
                    break;
                default:
                    System.out.println("Please chose number from 1 to 4.");
            }
        }while(select != 4);
    }
}
