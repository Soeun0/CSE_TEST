/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cse_test.BookManagement;

import java.util.List;


/**
 *
 * @author Lenovo
 */
public interface Subject {
    void registerObserver(Observer observer); //옵저버 추가
    void removeObserver(Observer observer); //옵저버 삭제
    void notifyObservers(); //변경 알림
    List<Book> getBooks();
    void addBook(Book book); //책 추가 
    void removeBook(String key); //책 삭제
}
