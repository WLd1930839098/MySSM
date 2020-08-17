package com.bins.bean;

import java.sql.Timestamp;

public class Borrow {

    private int userId;
    private String userName;
    private int bookId;
    private String bookName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookName() {
        return bookName;
    }

    private Timestamp timestamp;

    public Borrow() {
    }

    public Borrow(int userId, String userName, int bookId, String bookName, Timestamp timestamp) {
        this.userId = userId;
        this.userName = userName;
        this.bookId = bookId;
        this.bookName = bookName;
        this.timestamp = timestamp;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {

        return bookId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
