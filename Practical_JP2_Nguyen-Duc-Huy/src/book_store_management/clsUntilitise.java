/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_store_management;

import java.util.Scanner;

/**
 *
 * @author Tuan
 */
public class clsUntilitise {
    public static int InputInt(){
        Scanner input = new Scanner(System.in);
        int num;
        while(true){
            try{
                num = Integer.parseInt(input.nextLine());
                break;
            }catch(Exception e){
                System.out.println("Integer input error.");
            }
        }
        return num;
    }
    
    public static double InputDouble(){
        Scanner input = new Scanner(System.in);
        double num;
        while(true){
            try{
                num = Double.parseDouble(input.nextLine());
                break;
            }catch(Exception e){
                System.out.println("Error input double.");
            }
        }
        return num;
    }
}
