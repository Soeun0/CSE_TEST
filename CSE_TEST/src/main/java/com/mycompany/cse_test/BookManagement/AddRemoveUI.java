/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cse_test.BookManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class AddRemoveUI {
    private final BookList booklist = new BookList();

    public AddRemoveUI() {       
        ObserverAdd(booklist);
    }

    public void mainUI() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = "";
            System.out.println("1. 책 추가하기\n2. 책 삭제하기\n 3. 이전으로");
            System.out.print("▶ 번호를 입력하시오: ");

            try {
                line = br.readLine();
                if (line.isEmpty()) {
                    System.out.println("입력이 없습니다. 다시 시도해주세요.");
                    continue;
                }

                switch (line) {
                    case "1":
                        add(booklist);
                        break;
                    case "2":
                        remove(booklist);
                        break;
                    case "3":
                        return;
                    default:
                        System.out.println("다시 입력해주세요.");
                        break;
                }
            } catch (NoSuchElementException | IOException e) {
                System.out.println("입력이 없습니다. 다시 시도해주세요.");
            }
        }
    }

    private void add(BookList books) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("<책 정보 등록시 주의사항>");
            System.out.println("1. 책 제목, 저자, 출판사, ISBN 순서로 입력한다.");
            System.out.println("2. 각 정보마다 TAB키로 구분해준다.\n");

            while (true) {
                String line = null;

                System.out.print("▶ 책 정보를 입력하시오: ");
                line = scanner.nextLine();
                String[] tokens = line.split("\t");

                if (tokens.length != 4) {
                    System.out.println("입력이 잘못되었습니다. 다시 입력해주세요.");
                    continue;
                } else {
                    Book book = new Book(tokens[0], tokens[1], tokens[2], tokens[3]);
                    System.out.println("제목: " + tokens[0]);
                    System.out.println("저자: " + tokens[1]);
                    System.out.println("출판사: " + tokens[2]);
                    System.out.println("ISBN: " + tokens[3]);

                    while (true) {
                        System.out.print("▶ 해당 내용이 맞습니까? (y/n) : ");
                        String Check = scanner.nextLine();

                        switch (Check) {
                            case "y":
                                books.addBook(book);
                                System.out.println("책이 성공적으로 추가되었습니다.");
                                System.out.println("------------------------------------");
                                return;
                            case "n":
                                System.out.println("취소되었습니다.");
                                System.out.println("------------------------------------");
                                return;
                            default:
                                System.out.println("다시 입력해주세요.");
                                break;
                        }
                    }
                }
            }
        }
    }

    private void remove(BookList books) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("▶ 삭제하고 싶은 책의 ISBN을 입력하시오: ");
            String isbn = scanner.nextLine();

            // ISBN으로 Book 객체 찾기
            Book foundBook = null;
            for (Book book : books.getBooks()) {
                if (book.getIsbn().equals(isbn)) {
                    foundBook = book;
                    break;
                }
            }

            if (foundBook != null) {
                // ISBN이 일치하는 Book 객체를 찾았을 때의 처리
                System.out.println("제목: " + foundBook.getTitle());
                System.out.println("저자: " + foundBook.getAuthor());
                System.out.println("출판사: " + foundBook.getPublisher());
                System.out.println("ISBN: " + foundBook.getIsbn());

                while (true) {
                    System.out.print("▶ 삭제하시겠습니까? (y/n): ");
                    String confirm = scanner.nextLine();

                    switch (confirm) {
                        case "y":
                            books.removeBook(isbn);
                            System.out.println("책이 삭제되었습니다.");
                            System.out.println("------------------------------------");
                            return;
                        case "n":
                            System.out.println("삭제가 취소되었습니다.");
                            System.out.println("------------------------------------");
                            return;
                        default:
                            System.out.println("다시 입력해주세요.");
                            break;

                    }
                }

            } else {
                // ISBN이 일치하는 Book 객체를 찾지 못했을 때의 처리
                System.out.println("책을 찾을 수 없습니다.");
                System.out.println("------------------------------------");
            }
        }

    }

    private void ObserverAdd(BookList booklist) {
        BookFileWriter a = new BookFileWriter();
        booklist.registerObserver(a);
    }
}
