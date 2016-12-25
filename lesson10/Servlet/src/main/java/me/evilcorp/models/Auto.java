package me.evilcorp.models;

/**
 * Created by ekzotech on 05.12.16.
 */
public class Auto {
    private Integer id;
    private String model;
    private User user;

    public Auto(Integer id, String model, User user) {
        this.id = id;
        this.model = model;
        this.user = user;
    }

    public Auto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
