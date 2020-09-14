package ru.alexxx.biblio.model;

public class User {
    private Long userid;
    private String username;

    public User(Long userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public User() {

    }

    public Long getUserid(long id) {
        return userid;
    }

    public Long setUserid(Long userid) {
        this.userid = userid;
        return userid;
    }

    public String getUsername(String name) {
        return username;
    }

    public String setUsername(String username) {
        this.username = username;
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                '}';
    }
}
