package Dao;

import models.Book;
import models.BookBorrow;

import java.util.List;

public interface BookDaoInterface {
     Book saveBook(Book book);
     Book updateBook(Book book);
     int deleteBook(int bookId);
     Book getBookByIsbn(int bookId);
     List<Book> getAllBooksAvailable();
     List<Book> getAllBooksBorrow();
     List<Book> searchBookByTitre(String titre);
     List<Book> searchBookByAuthor(String author);
     void bookAvailable();
     void bookBorrowed();
     void bookLost();
     void allBooksInLibrary();
     List<BookBorrow> booksBorrowedWithInfo(int bookId);

}
