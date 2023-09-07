package models;

import java.util.Date;

public class BookBorrow {
    private Date dateOfBorrow;
    private Date dateOfReturn;
    private Book bookId;
    private Membre memberId;

    public BookBorrow(){

    }

    public BookBorrow(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public BookBorrow(Date dateOfReturn, Book bookId, Membre memberId) {
        this.dateOfReturn = dateOfReturn;
        this.bookId = bookId;
        this.memberId = memberId;
    }

    public Date getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(Date dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }

    public Date getDateOfReturn() {
        return  dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Membre getMemberId() {
        return memberId;
    }

    public void setMemberId(Membre memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "BookBorrow{" +
                "dateOfBorrow=" + dateOfBorrow +
                ", dateOfReturn=" + dateOfReturn +
                ", bookId=" + bookId +
                ", memberId=" + memberId +
                '}';
    }
}
