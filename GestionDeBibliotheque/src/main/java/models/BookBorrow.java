package models;

import java.util.Date;

public class BookBorrow {
    private Date dateOfBorrow;
    private Date dateOfReturn;

    public BookBorrow(Date dateOfBorrow, Date dateOfReturn) {
        this.dateOfBorrow = dateOfBorrow;
        this.dateOfReturn = dateOfReturn;
    }

    public Date getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(Date dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public String toString() {
        return "BookBorrow{" +
                "dateOfBorrow=" + dateOfBorrow +
                ", dateOfReturn=" + dateOfReturn +
                '}';
    }
}
