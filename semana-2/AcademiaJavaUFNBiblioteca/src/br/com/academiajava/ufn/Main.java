package br.com.academiajava.ufn;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Library library = getLibrary();

        System.out.println("\nLivros na Biblioteca");
        List<Books> allBooks = library.listBooks();
        printBooks(allBooks);

        String titleToSearch = "Retorno do Rei";
        List<Books> booksByTitle = library.searchByTitle(titleToSearch);
        System.out.println("\nLivros com o titulo '" + titleToSearch + "':");
        printBooks(booksByTitle);

        System.out.println("\nEmpréstimo de Livro");
        String isbnToBorrow = "ISBN-1";
        borrowBook(library, isbnToBorrow);
        isbnToBorrow = "ISBN-2";
        borrowBook(library, isbnToBorrow);
        isbnToBorrow = "ISBN-2.1";
        borrowBook(library, isbnToBorrow);
        isbnToBorrow = "ISBN-1";
        borrowBook(library, isbnToBorrow);

        System.out.println("\nDevolução de Livro");
        String isbnToReturn = "ISBN-1";
        LocalDate borrowedDate = LocalDate.of(2023, 10, 31);
        returnBook(library, isbnToReturn, borrowedDate);
        isbnToReturn = "ISBN-5";
        returnBook(library, isbnToReturn, borrowedDate);

        System.out.println("\nRemoção de Livro");
        String isbnToRemove = "ISBN-3";
        deleteBook(library, isbnToRemove);
        isbnToRemove = "ISBN-5";
        deleteBook(library, isbnToRemove);

        System.out.println("\nLivros na Biblioteca");
        printBooks(allBooks);

        System.out.println("\nLivros Emprestados");
        List<Books> borrowedBooks = library.getBorrowedBooks();
        printBooks(borrowedBooks);

        System.out.println("\nRevistas");
        Magazine magazine1 = new Magazine("Magazine 1", "Company A", 1, 1);
        Magazine magazine2 = new Magazine("Magazine 2", "Company B", 2, 5);
        Magazine magazine3 = new Magazine("Magazine 3", "Company C", 3, 1);

        if(magazine1.reserve()) {
            System.out.println("Revista emprestada.");
        }
        if(!magazine1.reserve()) {
            System.out.println("Revista já emprestada.");
        }
        System.out.println(magazine1);
        magazine1.returnMagazine();
        System.out.println(magazine1);

        magazine1.imprimir();
        System.out.println(magazine1);
    }

    private static Library getLibrary() {
        Books book1 = new Books("Blade Runner", "Philip K. Dick", "ISBN-1");
        Books book2 = new Books("Retorno do Rei", "J.R.R. Tolkien", "ISBN-2");
        Books book3 = new Books("Retorno do Rei", "J.R.R. Tolkien", "ISBN-2.1");
        Books book4 = new Books("Elusive Samurai", "Yusei Matsui", "ISBN-3");


        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        return library;
    }

    public static void printBooks(List<Books> books) {
        for (Books book : books) {
            System.out.println(book);
        }
    }

    public static void borrowBook(Library library, String isbn) {
        boolean successfullyBorrowed = library.borrowBook(isbn);
        if (successfullyBorrowed) {
            System.out.println("Livro emprestado com sucesso ISBN: " + isbn);
        } else {
            System.out.println("ISBN não existe ou Livro já emprestado " + isbn);
        }
    }

    public static void returnBook(Library library, String isbn, LocalDate borrowedBook) {
        boolean successfullyReturn = library.returnBook(isbn, borrowedBook);
        if (successfullyReturn) {
            System.out.println("Livro devolvido ISBN: " + isbn);
        } else {
            System.out.println("ISBN não existe ou Livro não está emprestado "  + isbn);
        }
    }

    public static void deleteBook(Library library, String isbn) {
        boolean removed = library.removeBookISBN(isbn);
        if (removed) {
            System.out.println("Livro com ISBN: " + isbn + " removido com sucesso.");
        } else {
            System.out.println("Livro com ISBN: " + isbn + " não encontrado na biblioteca.");
        }
    }
}
