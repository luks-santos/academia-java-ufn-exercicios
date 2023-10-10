package br.com.academiajava.ufn;

import java.time.LocalDate;
import java.util.*;

public class Library {

    private List<Books> bookList;

    public Library() {
        this.bookList = new ArrayList<>();
    }


    public void addBook(Books book) {
        bookList.add(book);
    }

    public boolean removeBookISBN(String isbn) {
        for (Books book: bookList) {
            if (book.getIsbn().equals(isbn)) {
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }

    public List<Books> searchByTitle(String title) {
        List<Books> booksByTitleList = new ArrayList<>();
        for (Books book : bookList) {
            if (book.getTitle().equals(title)) {
                booksByTitleList.add(book);
            }
        }
        return booksByTitleList;
    }

    private Books searchByISBN(String isbn) {
        for (Books book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public boolean borrowBook(String isbn) {
        Books book = searchByISBN(isbn);
        if (book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            LocalDate currentDate = LocalDate.now();
            int DAYS_LIMIT_BORROWED = 14;
            LocalDate limitDate = currentDate.plusDays(DAYS_LIMIT_BORROWED);
            book.setDateLimitBorrowed(limitDate);
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn, LocalDate borrowedDate) {
        Books book = searchByISBN(isbn);
        if (book != null && book.isBorrowed()) {
            if(borrowedDate.isAfter(book.getDateLimitBorrowed())) {
                System.out.println("O Livro foi devolvido com atraso " + book.getIsbn());
            }
            book.setDateLimitBorrowed(null);
            book.setBorrowed(false);
            return true;
        }
        return false;
    }

    public List<Books> getBorrowedBooks() {
        List<Books> borrowedBooks  = new ArrayList<>();
        for (Books book : bookList) {
            if (book.isBorrowed()) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }

    public List<Books> listBooks() {
        return bookList;
    }
}
