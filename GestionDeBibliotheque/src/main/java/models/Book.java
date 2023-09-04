package models;
public class Book {
    private Integer isbn;
    private String titre;
    private String author;
    private String status;



    public Book(Integer isbn, String titre, String author, String status) {
        this.isbn = isbn;
        this.titre = titre;
        this.author = author;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", titre='" + titre + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                '}';
    }
}
