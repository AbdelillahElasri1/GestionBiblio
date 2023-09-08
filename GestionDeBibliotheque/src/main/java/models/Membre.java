package models;

public class Membre {
    private Integer numMember;
    private String name;
    private String cin;
    private BookBorrow bookBorrow;


    public Integer getNumMember() {
        return numMember;
    }

    public void setNumMember(Integer numMember) {
        this.numMember = numMember;
    }

    public Membre(Integer numMember, String name, String cin) {
        this.numMember = numMember;
        this.name = name;
        this.cin = cin;

    }

    public BookBorrow getBookBorrow() {
        return bookBorrow;
    }

    public void setBookBorrow(BookBorrow bookBorrow) {
        this.bookBorrow = bookBorrow;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Membre{" +
                "numMember=" + numMember +
                ", name='" + name + '\'' +
                '}';
    }
}
