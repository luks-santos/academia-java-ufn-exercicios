package br.com.academiajava.ufn;

import java.time.LocalDate;

public class Books {

    private String title;
    private String author;
    private String isbn;
    private boolean borrowed;
    private LocalDate dateLimitBorrowed;

    public Books() {}

    public Books(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.borrowed = false;
    }

    public Books(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrowed = false;
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
        return borrowed;
    }

    private void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public boolean borrowed() {
        if(borrowed) {
            return false;
        } else {
            setBorrowed(true);
            return true;
        }
    }

    public boolean returnBook() {
        if(borrowed) {
            setBorrowed(false);
            return true;
        }
        return false;
    }

    public LocalDate getDateLimitBorrowed() {
        return dateLimitBorrowed;
    }

    public void setDateLimitBorrowed(LocalDate dateLimitBorrowed) {
        this.dateLimitBorrowed = dateLimitBorrowed;
    }

    public String toString() {
        String info;
        info = "Título: " + title  +
                ", Autor: '" + author;
        if(isbn != "") {
            info += ", ISBN: " + isbn;
        }
        if(borrowed) {
            info += ", (Disponível)";
        } else {
            info += ", (Emprestado)";
        }
        return info;
    }
}
