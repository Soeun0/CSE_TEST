/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cse_test.BookManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BookFileWriter implements Observer {

    String paths = System.getProperty("user.dir");
    File filePath = new File(paths + "/DB/BookList.txt");

    @Override
    public void update(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,false))) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
