/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cse_test.BookManagement;

/**
 *
 * @author Lenovo
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;

    public Book(String title, String author, String publisher, String isbn) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    // toString() method 만들기
    @Override
    public String toString() {
        return title + "\t" + author + "\t" + publisher + "\t" + isbn ;
    }
    
    // Getters, setters 만들기
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
