import XCases.ListFunction;
import models.Status;
import utils.InputReader;
import utils.OutputWriter;

import java.text.ParseException;

public class ChoiceList {
    static InputReader i = new InputReader(System.in);
    static OutputWriter o = new OutputWriter(System.out);
    Status status = null;
    public void choiceOfList() throws ParseException {
        ListFunction listFunction = new ListFunction();

        while (true) {
            o.println("**************************************************************************************************************************************");
            o.println("*-----------------------------------------------------------Library Management-------------------------------------------------------*");
            o.println("**************************************************************************************************************************************");
            o.println("*****                                                   1. add books to library                                                  *****");
            o.println("*****                                                   2. update book                                                           *****");
            o.println("*****                                                   3. Delete book from database                                             *****");
            o.println("*****                                                   4. get all books available                                               *****");
            o.println("*****                                                   5. get all books borrowed                                                *****");
            o.println("*****                                                   6. add member                                                            *****");
            o.println("*****                                                   7. update member                                                         *****");
            o.println("*****                                                   8. delete member                                                         *****");
            o.println("*****                                                   9. getAllMembers                                                         *****");
            o.println("*****                                                  10. search for book in library                                            *****");
            o.println("*****                                                  11. take book from library                                                *****");
            o.println("*****                                                  12. return book to library                                                *****");
            o.println("*****                                                  13. Statistics of book                                                    *****");
            o.println("*****                                                   0. exit                                                                  *****");
            o.println("**************************************************************************************************************************************");
            o.print("                                                        =>enter your choice: ");
            int choice = i.readInt();
            switch (choice){
                case 1:
                    listFunction.addBook();
                    break;
                case 2:
                    listFunction.editBook();
                    break;
                case 3:
                    listFunction.dropBook();
                    break;
                case 4:
                    listFunction.allBooksAvailable();
                    break;
                case 5:
                    listFunction.allBooksBorrowed();
                    break;
                case 6:
                    listFunction.addMember();
                    break;
                case 7:
                    listFunction.editMember();
                    break;
                case 8:
                    listFunction.dropMember();
                    break;
                case 9:
                    listFunction.allMembers();
                    break;
                case 10:
                    listFunction.searchBook();
                    break;
                case 11:
                    listFunction.takeBook();
                    break;
                case 12:
                    listFunction.returnBooks();
                    break;
                case 13:
                    listFunction.bookStatistics();
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
