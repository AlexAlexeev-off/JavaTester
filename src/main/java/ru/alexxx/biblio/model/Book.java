package ru.alexxx.biblio.model;

public class Book {
    private Long bookid;
    private Long authorid;
    private String bookname;
    private Long bookswho;

    public Book(Long bookid, Long authorid, String bookname, Long bookswho) {
        this.bookid = bookid;
        this.authorid = authorid;
        this.bookname = bookname;
        this.bookswho = bookswho;
    }

    public Book() {

    }

    public Long getBookid() {
        return bookid;
    }

    public Long setBookid(Long bookid) {
        this.bookid = bookid;
        return bookid;
    }

    public Long getAuthorid(long i) {
        return authorid;
    }

    public Long setAuthorid(Long authorid) {
        this.authorid = authorid;
        return authorid;
    }

    public String getBookname() {
        return bookname;
    }

    public String setBookname(String bookname) {
        this.bookname = bookname;
        return bookname;
    }

    public Long getBookswho(Long i) {
        return bookswho;
    }

    public Long setBookswho(Long bookswho) {
        this.bookswho = bookswho;
        return bookswho;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", authorid=" + authorid +
                ", bookname='" + bookname + '\'' +
                ", bookswho=" + bookswho +
                '}';
    }

    public Long getBookswho() {
        return getBookswho();
    }
}
