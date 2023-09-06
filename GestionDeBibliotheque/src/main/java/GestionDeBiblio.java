import Dao.BookDao;
import Dao.MembreDao;
import Database.DatabaseConnectionManager;
import models.Book;
import models.Membre;
import models.Status;
import utils.InputReader;
import utils.OutputWriter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionDeBiblio {
	static InputReader i = new InputReader(System.in);
	static OutputWriter o = new OutputWriter(System.out);

	Status status = null;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		while (true) {
			o.println("Welcome to library system management");
			o.println("1- add books to library");
			o.println("2- update book");
			o.println("3- Delete book from database");
			o.println("4- get all books available");
			o.println("5- get all books borrowed");
			o.println("6- add member.");
			o.println("7- update member");
			o.println("8- delete member");
			o.println("9- getAllMembers");
			o.println("10- search for book inside library");
			o.println("11- take book from library");
			o.println("12- return book to library");
			o.println("13- Statistics of book");
			o.println("0- exit");
			o.print("enter your choice:  ");
			int choice = i.readInt();
			switch (choice){
				case 1:
					o.println("Welcome to form add book");
					o.println("Enter Isbn");
					int isbn = i.readInt();
					o.println("Enter titre");
					String titre = i.readLine();
					o.println("Enter author");
					String author = i.readLine();
					Status status = Status.AVAILABLE;
//					o.println("Enter status of book");
//					Status status = Status.valueOf(i.readLine());

					Book book = new Book(isbn,titre,author,status);
					BookDao bookDao = new BookDao();
					bookDao.saveBook(book);
					o.println("book added");
					break;
				case 2:
					o.println("update book");
					o.println("enter the isbn of book : ");
					int bookId = i.readInt();
					BookDao bookDao1 = new BookDao();
					Book existingBook =  bookDao1.getBookByIsbn(bookId);

					if (existingBook != null){
						o.println("existing book information: ");
						o.println("isbn : "+ existingBook.getIsbn());
						o.println("titre : " + existingBook.getTitre());
						o.println("author : " + existingBook.getAuthor());
						o.println("status : " + existingBook.getStatus());


						o.println("Enter new book titre (or press Enter to keep existing) : ");
						String newTitre = i.readLine();

						o.println("Enter new book author (or press Enter to keep existing) : ");
						String newAuthor = i.readLine();

						o.println("Enter new book status (or press Enter to keep existing) : ");
						o.println("1- Available.");
						o.println("2- Borrowed.");
						o.println("3- Lost.");
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


						bookDao1.updateBook(existingBook);
						o.println("book updated successfully");
					} else {
						o.println("Book with isbn" + bookId + "not found");
					}

//
					break;
				case 3:
					o.println("Delete book from database");
					o.println("Enter the isbn of the book you want to delete: ");
					int bookIsbn = i.readInt();
					BookDao bookDao2 = new BookDao();
					bookDao2.deleteBook(bookIsbn);
					o.println("the book is deleted successfully");
					break;
				case 4:
					o.println("All books available in library");
					BookDao bookDao3 = new BookDao();

					List<Book> books = bookDao3.getAllBooksAvailable();
					if (!books.isEmpty()){
						o.println("List of books available");
						for (Book book1 : books) {
							o.println("Book isbn : " + book1.getIsbn());
							o.println("Titre : " + book1.getTitre());
							o.println("Author : " + book1.getAuthor());
							o.println("status : " + book1.getStatus());
						}
					}else {
						o.println("no books available inside library");
					}
					break;
				case 5:
						o.println("All books borrowed by members");
						BookDao bookDao4 = new BookDao();

						List<Book> books2 = bookDao4.getAllBooksBorrow();
						if (!books2.isEmpty()){
							o.println("List of books borrowed :");
							for (Book book2 : books2){
								o.println("Book isbn : " + book2.getIsbn());
								o.println("Titre : " + book2.getTitre());
								o.println("Author : " + book2.getAuthor());
								o.println("Status : " + book2.getStatus());
							}
						}else {
							o.println("no books borrowed by members");
						}
						break;
				case 6:
					o.println("Welcome to form add Member");
					o.println("Enter number of member");
					int numMember = i.readInt();
					o.println("Enter name");
					String name = i.readLine();
					o.println("Enter cin");
					String cin = i.readLine();

					Membre membre = new Membre(numMember,name,cin);
					MembreDao membreDao = new MembreDao();
					membreDao.saveMember(membre);
					o.println("Member added");
						break;
				case 7:
					o.println("update Member");
					o.println("enter the number of Member : ");
					int memberId = i.readInt();
					MembreDao membreDao1 = new MembreDao();
					Membre existingMember = membreDao1.getMemberByNumMember(memberId);

					if (existingMember != null){
						o.println("existing Member information: ");
						o.println("number of member : " + existingMember.getNumMember());
						o.println("name : " + existingMember.getName());
						o.println("cin : " + existingMember.getCin());


						o.println("Enter new member name (or press Enter to keep existing) : ");
						String newName = i.readLine();

						o.println("Enter new member cin (or press Enter to keep existing) : ");
						String newCin = i.readLine();


						if (!newName.isEmpty()){
							existingMember.setName(newName);
						}
						if (!newCin.isEmpty()){
							existingMember.setCin(newCin);
						}
						membreDao1.updateMember(existingMember);
						o.println("Member updated successfully");
					} else {
						o.println("Member with isbn" + memberId + "not found");
					}

					break;
				case 8:
					o.println("Delete Member from database");
					o.println("Enter the number of member you want to delete: ");
					int numberOfMember = i.readInt();
					MembreDao membreDao2 = new MembreDao();
					membreDao2.deleteMember(numberOfMember);
					o.println("the member is deleted successfully");
					break;
				case 9:
					o.println("All Members");
					MembreDao membreDao3 = new MembreDao();

					List<Membre> membres = membreDao3.getAllMembers();
					if (!membres.isEmpty()){
						o.println("List of Member");
						for (Membre membre1 : membres) {
							o.println("number of member : " + membre1.getNumMember());
							o.println("name : " + membre1.getName());
							o.println("cin : " + membre1.getCin());
						}
					}else {
						o.println("no member in library");
					}
					break;
				case 10:
					o.println("search books by: ");
					o.println("1- titre :");
					o.println("2- author :");
					o.println("choose search by title or author :");
					int searchChoice = i.readInt();
					switch (searchChoice){
						case 1:
							o.println("enter titre of the book : ");
							String titreSearch = i.readLine();
							BookDao bookDao5 = new BookDao();
							List<Book> books1 = bookDao5.searchBookByTitre(titreSearch);
							if (!books1.isEmpty()){
								o.println("List of the book");
								for (Book book1 : books1){
									o.println("isbn of the book : " + book1.getIsbn());
									o.println("titre book : " + book1.getTitre());
									o.println("author of the book : " + book1.getAuthor());
									o.println("status of the book : " + book1.getStatus());
								}
							}else {
								o.println("no book with this title.");
							}
							break;
						case 2:
							o.println("enter author of the book : ");
							String authorSearch = i.readLine();
							BookDao bookDao6 = new BookDao();
							List<Book> books3 = bookDao6.searchBookByAuthor(authorSearch);
							if (!books3.isEmpty()){
								o.println("List of the book : ");
								for (Book book1 : books3) {
									o.println("isbn of the book : " + book1.getIsbn());
									o.println("titre book : " + book1.getTitre());
									o.println("author of the book : " + book1.getAuthor());
									o.println("status of the book : " + book1.getStatus());
								}
							}else {
								o.println("no book with the author");
							}
							break;
					}
					break;
				case 11:
					o.println("take book from ibrary");
					break;
				case 12:
					break;
				case 13:
					o.println("=>Statistics of book in library : ");
					BookDao bookDao5 = new BookDao();
					o.print("--------------------------All books      : ");
					bookDao5.allBooksInLibrary();
					o.print("--------------------------book available : ");
					bookDao5.bookAvailable();
					o.print("--------------------------book borrowed  : ");
					bookDao5.bookBorrowed();
					o.print("--------------------------book Lost      : ");
					bookDao5.bookLost();
					break;
				case 0:
					o.println("exit");
					System.exit(1);
					break;
				default:
					o.println("invalid choice");
					break;
			}

		}
	}

}
