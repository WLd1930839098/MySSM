package com.bins.bean;

//对用v_book视图
public class Book {
    private int id;
    private int nameId;
    private String name;
    private boolean free;

    public Book() {
    }

    public Book(int id, int nameId, String name, boolean free) {
        this.id = id;
        this.nameId = nameId;
        this.name = name;
        this.free = free;
    }

    public int getId() {
        return id;
    }

    public int getNameId() {
        return nameId;
    }

    public String getName() {
        return name;
    }

    public boolean isFree() {
        return free;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", nameId=" + nameId +
                ", name='" + name + '\'' +
                ", free=" + free +
                '}';
    }
}
