/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cse_test.BookManagement;

/**
 *
 * @author Lenovo
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class BookList implements Subject {

    private List<Observer> observers;
    private List<Book> books;

    public BookList() {
        observers = new ArrayList<>();
        books = new ArrayList<>();
        localFile();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(books);
        }
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
        notifyObservers();
    }

    @Override
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        notifyObservers();
    }

    private void localFile() {

        String paths = System.getProperty("user.dir");
        File projectPath = new File(paths + "/DB/BookList.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader(projectPath))) {
           String line;
           int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                if (lineNumber == 0) { // 첫 번째 행은 열 이름
                    lineNumber++;
                    continue;
                }

                String[] data = line.split("\t");

                String title = data[0];
                String author = data[1];
                String publisher = data[2];
                String isbn = data[3];

                Book book = new Book(title, author, publisher, isbn);
                books.add(book);
                
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
