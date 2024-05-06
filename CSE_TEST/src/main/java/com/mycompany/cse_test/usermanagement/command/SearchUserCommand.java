/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cse_test.usermanagement.command;

import com.mycompany.cse_test.usermanagement.UserManagement;

/**
 *
 * @author jasuj
 */
public class SearchUserCommand implements Command {
    private UserManagement userManager = UserManagement.getInstance();

    public SearchUserCommand(UserManagement userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        userManager.SearchUserList();
    }
}