package com.bins.bean;

public class Role {

    private int id;
    private String name;
    private String desc;

    public Role() {
    }

    public Role(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
