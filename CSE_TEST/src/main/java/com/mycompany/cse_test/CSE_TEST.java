/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cse_test;

/**
 *
 * @author Lenovo
 */
public class CSE_TEST {

    static UserManagement user = UserManagement.getInstance();
    
    public static void main(String[] args) {
         System.out.println("<도서관리>");

        //user.AddUser();
        //user.DeleteUser();
        user.ModifyUser();
        
    }
}
