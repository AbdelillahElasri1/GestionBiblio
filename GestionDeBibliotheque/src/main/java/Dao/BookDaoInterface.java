package Dao;

import models.Book;

import java.util.List;

public interface BookDaoInterface {
     void saveBook(Book book);
     void updateBook(Book book);
     void deleteBook(int bookId);
     Book getBookByIsbn(int bookId);
     List<Book> getAllBooksAvailable();
     List<Book> getAllBooksBorrow();
     List<Book> searchBookByTitre(String titre);
     List<Book> searchBookByAuthor(String author);
     void bookAvailable();
     void bookBorrowed();
     void bookLost();
     void allBooksInLibrary();

}
