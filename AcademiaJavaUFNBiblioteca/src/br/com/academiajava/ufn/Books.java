package br.com.academiajava.ufn;

import java.time.LocalDate;

public class Books {

    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;
    private LocalDate dateLimitBorrowed;

    public Books() {}

    public Books(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public LocalDate getDateLimitBorrowed() {
        return dateLimitBorrowed;
    }

    public void setDateLimitBorrowed(LocalDate dateLimitBorrowed) {
        this.dateLimitBorrowed = dateLimitBorrowed;
    }

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
