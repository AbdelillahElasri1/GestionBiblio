import Dao.BookBorrowDao;
import Dao.BookDao;
import Dao.MembreDao;
import Database.DatabaseConnectionManager;
import XCases.ListFunction;
import models.Book;
import models.BookBorrow;
import models.Membre;
import models.Status;
import utils.InputReader;
import utils.OutputWriter;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GestionDeBiblio {
	static InputReader i = new InputReader(System.in);
	static OutputWriter o = new OutputWriter(System.out);



	public static void main(String[] args) throws ParseException {
		ChoiceList choiceList = new ChoiceList();
		choiceList.choiceOfList();
	}

}
