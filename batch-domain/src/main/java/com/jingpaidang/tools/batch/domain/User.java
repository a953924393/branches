package com.jingpaidang.tools.batch.domain;

/**
 * Created with IntelliJ IDEA.
 * User: JackChan
 * Date: 7/29/13
 * Time: 5:37 PM
 */
public class User {
    private int id;
    private String name;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
