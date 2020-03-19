package com.mycompany.app.model;
import lombok.Data;

@Data   //this is lombok. сеттеров-геттеров нет, но они есть!
public class User {

    private long id;
    private String name;
    private String basic_language;
    private String time_created;

    public User() {

    }

    public User(long id) {
        this.id = id;
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name, String basic_language) {
        this.name = name;
        this.basic_language = basic_language;
    }

    public User(long id, String name, String basic_language, String time_created) {
        this.id = id;
        this.name = name;
        this.basic_language = basic_language;
        this.time_created = time_created;
    }

    public User(long id, String name, String basic_language) {
        this.id = id;
        this.name = name;
        this.basic_language = basic_language;
    }
}
