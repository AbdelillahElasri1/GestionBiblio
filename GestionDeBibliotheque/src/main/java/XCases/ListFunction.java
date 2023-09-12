package XCases;

import Dao.BookBorrowDao;
import Dao.BookDao;
import Dao.MembreDao;
import models.Book;
import models.BookBorrow;
import models.Membre;
import models.Status;
import utils.InputReader;
import utils.OutputWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ListFunction {
    static InputReader i = new InputReader(System.in);
    static OutputWriter o = new OutputWriter(System.out);
    Status status = null;
    BookDao bookDao = new BookDao();
    BookBorrowDao bookBorrowDao = new BookBorrowDao();
    MembreDao membreDao = new MembreDao();
    public void addBook(){
        o.println("                                                      ****************************");
        o.println("                                                      * Welcome to form add book *");
        o.println("                                                      ****************************");
        o.println("                                                      Enter Isbn : ");
        o.print("                                                        -> ");
        int isbn = i.readInt();
        o.println("                                                      Enter titre : ");
        o.print("                                                       -> ");
        String titre = i.readLine();
        o.println("                                                      Enter author : ");
        o.print("                                                       -> ");
        String author = i.readLine();
        Status status = Status.AVAILABLE;

        Book book = new Book(isbn,titre,author,status);
        bookDao.saveBook(book);
        o.println("                                                      book "+ book.getTitre() +" added successfully :)");
        o.println("");
    }
    public void editBook(){
        o.println("                                                     *******************************");
        o.println("                                                     * Welcome to form update book *");
        o.println("                                                     *******************************");
        o.println("                                                     Enter the isbn of book : ");
        o.print("                                                       -> ");
        int bookId = i.readInt();
        Book existingBook =  bookDao.getBookByIsbn(bookId);

        if (existingBook != null){
            o.println("                                               =>Existing book information: ");
            o.println("                                               ------------------------------------------");
            o.println("                                               | Isbn : "+ existingBook.getIsbn()    + "|");
            o.println("                                               ------------------------------------------");
            o.println("                                               | Titre : " + existingBook.getTitre()  +"|");
            o.println("                                               ------------------------------------------");
            o.println("                                               | Author : " + existingBook.getAuthor()+"|");
            o.println("                                               ------------------------------------------");
            o.println("                                               | Status : " + existingBook.getStatus()+"|");
            o.println("                                               ------------------------------------------");
            o.println("");


            o.println("                                                  Enter new book titre (or press Enter to keep existing) : ");
            o.print("                                                       -> ");
            String newTitre = i.readLine();

            o.println("                                                  Enter new book author (or press Enter to keep existing) : ");
            o.print("                                                       -> ");
            String newAuthor = i.readLine();

            o.println("                                                  Enter new book status (or press Enter to keep existing) : ");
            o.println("                                                        1- Available.");
            o.println("                                                        2- Borrowed.");
            o.println("                                                        3- Lost.");
            o.print("                                                       -> ");
            int newStatus = i.readInt();
            switch (newStatus){
                case 1:
                    existingBook.setStatus(Status.AVAILABLE);
                    break;
                case 2:
                    existingBook.setStatus(Status.BORROWED);
                    break;
                case 3:
                    existingBook.setStatus(Status.LOST);
            }
            if (!newTitre.isEmpty()){
                existingBook.setTitre(newTitre);
            }
            if (!newAuthor.isEmpty()){
                existingBook.setAuthor(newAuthor);
            }


            bookDao.updateBook(existingBook);
            o.println("                                                   Book "+ existingBook.getTitre() +" updated successfully :)");
        } else {
            o.println("                                                   Book with isbn" + bookId + "not found :(");
        }

    }
    public void dropBook(){
        o.println("                                                     *******************************");
        o.println("                                                     *  Delete book from database  *");
        o.println("                                                     *******************************");
        o.println("");
        o.println("                                                       Enter the isbn of the book you want to delete: ");
        o.print("                                                       -> ");
        int bookIsbn = i.readInt();
        bookDao.deleteBook(bookIsbn);
    }
    public void allBooksAvailable(){
        o.println("                                                       All books available in library :");

        List<Book> books = bookDao.getAllBooksAvailable();
        if (!books.isEmpty()){
            o.println("                                                     *******************************");
            o.println("                                                     *   List of book available    *");
            o.println("                                                     *******************************");
            for (Book book1 : books) {
                o.println("                                              -----------------------------------");
                o.println("                                              |Book isbn : " + book1.getIsbn()+"|");
                o.println("                                              |---------------------------------|");
                o.println("                                              |Titre : " + book1.getTitre()+"   |");
                o.println("                                              |---------------------------------|");
                o.println("                                              |Author : " + book1.getAuthor()+" |");
                o.println("                                              |---------------------------------|");
                o.println("                                              |Status : " + book1.getStatus()+" |");
                o.println("                                              |---------------------------------|");
            }

        }else {
            o.println("                                                   No books available inside library :(");
        }
    }
    public void allBooksBorrowed(){
        o.println("                                                     *******************************");
        o.println("                                                     * List book borrowed by member*");
        o.println("                                                     *******************************");

        List<Book> books2 = bookDao.getAllBooksBorrow();
        if (!books2.isEmpty()){
            o.println("                                                   List of books borrowed :");
            for (Book book2 : books2){
                o.println("                                              -----------------------------------");
                o.println("                                              |Book isbn : " + book2.getIsbn()+"|");
                o.println("                                              |---------------------------------|");
                o.println("                                              |Titre : " + book2.getTitre()   +"|");
                o.println("                                              |---------------------------------|");
                o.println("                                              |Author : " + book2.getAuthor() +"|");
                o.println("                                              |---------------------------------|");
                o.println("                                              |Status : " + book2.getStatus() +"|");
                o.println("                                              -----------------------------------");
            }
        }else {
            o.println("                                                   No books borrowed by members :(");
        }
    }
    public void addMember(){
        o.println("                                                     *******************************");
        o.println("                                                     * Welcome to form Add Member  *");
        o.println("                                                     *******************************");
        o.println("                                                     Enter number of member : ");
        o.print("                                                       -> ");
        int numMember = i.readInt();
        o.println("                                                     Enter name : ");
        o.print("                                                       -> ");
        String name = i.readLine();
        o.println("                                                     Enter cin : ");
        o.print("                                                       -> ");
        String cin = i.readLine();

        Membre membre = new Membre(numMember,name,cin);
        membreDao.saveMember(membre);
        o.println("                                                     Member "+ membre.getName() +" added  successfully :)");
    }
    public void editMember(){
        o.println("                                                     *********************************");
        o.println("                                                     * Welcome to form update Member *");
        o.println("                                                     *********************************");
        o.print("                                                       Enter the number of Member : ");
        int memberId = i.readInt();
        Membre existingMember = membreDao.getMemberByNumMember(memberId);

        if (existingMember != null){
            o.println("                                                 Existing Member information: ");
            o.println("                                                 Number of member : " + existingMember.getNumMember());
            o.println("                                                 Name : " + existingMember.getName());
            o.println("                                                 Cin : " + existingMember.getCin());


            o.println("                                                 Enter new member name (or press Enter to keep existing) : ");
            o.print("                                                       -> ");
            String newName = i.readLine();

            o.println("                                                 Enter new member cin (or press Enter to keep existing) : ");
            o.print("                                                       -> ");
            String newCin = i.readLine();


            if (!newName.isEmpty()){
                existingMember.setName(newName);
            }
            if (!newCin.isEmpty()){
                existingMember.setCin(newCin);
            }
            membreDao.updateMember(existingMember);
            o.println("                                                 Member "+ existingMember.getName() +" updated successfully :)");
        } else {
            o.println("                                                 Member with isbn" + memberId + "not found :(");
        }
    }
    public void dropMember(){
        o.println("                                                     *******************************");
        o.println("                                                     * Delete member from database *");
        o.println("                                                     *******************************");
        o.println("                                                     Enter the number of member you want to delete: ");
        o.print("                                                       -> ");
        int numberOfMember = i.readInt();
        membreDao.deleteMember(numberOfMember);
        o.println("                                                     The member is deleted successfully");
    }
    public void allMembers(){
        o.println("                                                     *******************************");
        o.println("                                                     *         All Members         *");
        o.println("                                                     *******************************");

        List<Membre> membres = membreDao.getAllMembers();
        if (!membres.isEmpty()){
            o.println("                                                 List of Member : ");
            for (Membre membre1 : membres) {
                o.println("                                            -------------------------------------------------");
                o.println("                                            |Number of member : " + membre1.getNumMember()+"|");
                o.println("                                            |-----------------------------------------------|");
                o.println("                                            |Name : " + membre1.getName()                 +"|");
                o.println("                                            |-----------------------------------------------|");
                o.println("                                            |Cin : " + membre1.getCin()                   +"|");
                o.println("                                            -------------------------------------------------");
            }
        }else {
            o.println("                                                 No member in library");
        }
    }
    public void searchBook(){
        o.println("                                                     *******************************");
        o.println("                                                     *    Welcome to search book   *");
        o.println("                                                     *******************************");
        o.println("                                                     Search books by: ");
        o.println("                                                       1- titre :");
        o.println("                                                       2- author :");
        o.println("                                                     choose search by title or author :");
        o.print("                                                       -> ");
        int searchChoice = i.readInt();
        switch (searchChoice){
            case 1:
                o.println("                                             Enter titre of the book : ");
                o.print("                                               -> ");
                String titreSearch = i.readLine();
                List<Book> books1 = bookDao.searchBookByTitre(titreSearch);
                if (!books1.isEmpty()){
                    o.println("                                         List of the book :");
                    for (Book book1 : books1){
                        o.println("                                    ----------------------------------------------");
                        o.println("                                    |Isbn of the book : " + book1.getIsbn()+"    |");
                        o.println("                                    |--------------------------------------------|");
                        o.println("                                    |Titre book : " + book1.getTitre()+"         |");
                        o.println("                                    |--------------------------------------------|");
                        o.println("                                    |Author of the book : " + book1.getAuthor()+"|");
                        o.println("                                    |--------------------------------------------|");
                        o.println("                                    |Status of the book : " + book1.getStatus()+"|");
                        o.println("                                    ---------------------------------------------|");
                    }

                }else {
                    o.println("                                         no book with this title.");
                }
                break;
            case 2:
                o.println("                                             enter author of the book : ");
                String authorSearch = i.readLine();
                List<Book> books3 = bookDao.searchBookByAuthor(authorSearch);
                if (!books3.isEmpty()){
                    o.println("                                         List of the book : ");
                    for (Book book1 : books3) {
                        o.println("                                    ----------------------------------------------");
                        o.println("                                    |Isbn of the book : " + book1.getIsbn()    +"|");
                        o.println("                                    |--------------------------------------------|");
                        o.println("                                    |Titre book : " + book1.getTitre()         +"|");
                        o.println("                                    |--------------------------------------------|");
                        o.println("                                    |Author of the book : " + book1.getAuthor()+"|");
                        o.println("                                    |--------------------------------------------|");
                        o.println("                                    |Status of the book : " + book1.getStatus()+"|");
                        o.println("                                    ----------------------------------------------");
                    }
                }else {
                    o.println("                                         no book with the author");
                }
                break;
        }
    }
    public void takeBook() throws ParseException {
        o.println("                                                     Take book from Library");
        o.println("                                                     Enter the isbn of book :");
        o.print("                                                       -> ");
        int isbnOfBook = i.readInt();
        o.println("                                                     Enter the number of member :");
        o.print("                                                       -> ");
        int numOfMember = i.readInt();
        o.println("                                                     Enter date of return book (YYYY-MM-DD) : ");
        o.print("                                                       -> ");

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(scanner.next());

        BookBorrow bookBorrow = new BookBorrow(date);
        bookBorrowDao.takeBookFromLibrary(isbnOfBook,numOfMember,bookBorrow);
        o.println("                                                     Book is borrowed successfully :)");
    }
    public void returnBooks(){
        o.println("                                                     Return book to Library");
        o.println("                                                     Enter isbn of the book borrowed: ");
        o.print("                                                       -> ");
        int isbnBook = i.readInt();
        o.println("                                                     Enter number of member : ");
        o.print("                                                       -> ");
        int numberOMember = i.readInt();
        bookBorrowDao.returnBookToLibrary(isbnBook,numberOMember);

    }
    public void bookStatistics(){
        o.println("                                                    =>Statistics of book in library : ");
        o.print("                                                      --------------------------All books      : ");
        bookDao.allBooksInLibrary();
        o.print("                                                      --------------------------book available : ");
        bookDao.bookAvailable();
        o.print("                                                      --------------------------book borrowed  : ");
        bookDao.bookBorrowed();
        o.print("                                                      --------------------------book Lost      : ");
        bookDao.bookLost();
    }
    public void booksBorrowedInfByBookId(int bookId){
        List<BookBorrow> bookBorrow = bookDao.booksBorrowedWithInfo(bookId);
        if (!bookBorrow.isEmpty()){
            o.println("                                         List of the book Borrowed by member with information : ");
            for (BookBorrow bookBorrow1 : bookBorrow) {
                o.println("                                     /////////////////////////////////////////////////////////////");
                o.println("                                     Isbn of the book : " + bookBorrow1.getBookId().getIsbn());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Titre of the book : " + bookBorrow1.getBookId().getTitre());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Author of the book : " + bookBorrow1.getBookId().getAuthor());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Status of the book : " + bookBorrow1.getBookId().getStatus());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     MemberId of the Member : " + bookBorrow1.getMemberId().getNumMember());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Name of the member : " + bookBorrow1.getMemberId().getName());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Cin of the member : " + bookBorrow1.getMemberId().getCin());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Date borrowed of the book : " + bookBorrow1.getDateOfBorrow());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Date return of the book : " + bookBorrow1.getDateOfReturn());
                o.println("                                     /////////////////////////////////////////////////////////////");
            }
        }else {
            o.println("                                         no book with this information.");
        }

    }
    public void booksBorrowedInfByMember(int memberId){
        List<BookBorrow> bookBorrow = membreDao.memberBorrowedBookWithInfo(memberId);
        if (!bookBorrow.isEmpty()){
            o.println("                                         List of the Member with book Borrowed details : ");
            for (BookBorrow bookBorrow1 : bookBorrow) {
                o.println("                                     /////////////////////////////////////////////////////////////");
                o.println("                                     MemberId of the Member : " + bookBorrow1.getMemberId().getNumMember());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Name of the member : " + bookBorrow1.getMemberId().getName());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Cin of the member : " + bookBorrow1.getMemberId().getCin());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Isbn of the book : " + bookBorrow1.getBookId().getIsbn());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Titre of the book : " + bookBorrow1.getBookId().getTitre());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Author of the book : " + bookBorrow1.getBookId().getAuthor());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Status of the book : " + bookBorrow1.getBookId().getStatus());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Date borrowed of the book : " + bookBorrow1.getDateOfBorrow());
                o.println("                                     ----------------------------------------------------------");
                o.println("                                     Date return of the book : " + bookBorrow1.getDateOfReturn());
                o.println("                                     /////////////////////////////////////////////////////////////");
            }
        }else {
            o.println("                                         no Member with this information.");
        }

    }
}
