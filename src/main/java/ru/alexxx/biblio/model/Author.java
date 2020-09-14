package ru.alexxx.biblio.model;

public class Author {
    private Long authorid;
    private String authorname;

    public Author(Long authorid, String authorname) {
        this.authorid = authorid;
        this.authorname = authorname;
    }

    public Author() {

    }

    public Long getAuthorid() {
        return authorid;
    }

    public Long setAuthorid(Long authorid) {
        this.authorid = authorid;
        return authorid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public String setAuthorname(String authorname) {
        this.authorname = authorname;
        return authorname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorid=" + authorid +
                ", authorname='" + authorname + '\'' +
                '}';
    }
}
