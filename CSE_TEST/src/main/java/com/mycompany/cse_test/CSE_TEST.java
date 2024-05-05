/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cse_test;

import com.mycompany.cse_test.usermanagement.UserManagement;
import com.mycompany.cse_test.usermanagement.command.UserManagementInvoker;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class CSE_TEST {

    static UserManagement user = UserManagement.getInstance();
    
    public static void main(String[] args) {
        
        UserManagementInvoker invoker = new UserManagementInvoker();
        Scanner sc = new Scanner(System.in);
        
        while (true){
            String command = sc.nextLine();
            
            if (command.equalsIgnoreCase("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            
            invoker.executeCommand(command.toLowerCase());
        }
        
          sc.close();
        
        
        
    }
}
