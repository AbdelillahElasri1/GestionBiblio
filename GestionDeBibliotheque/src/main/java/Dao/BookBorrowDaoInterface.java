package Dao;

import models.BookBorrow;

public interface BookBorrowDaoInterface {
    void takeBookFromLibrary(int bookId, int memberId, BookBorrow bookBorrow);
    void returnBookToLibrary(int bookIsbn, int memberNumber);
}
