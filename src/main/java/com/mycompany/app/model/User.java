package com.mycompany.app.model;
import lombok.Data;

import javax.persistence.*;

@Data   //this is lombok. create all utils method
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "is_admin")
    private boolean is_admin;

    @Column(name = "basic_language")
    private String basic_language;

    @Column
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

    public User(String name, String basic_language, boolean is_admin) {
//        this.id = id;
        this.name = name;
        this.basic_language = basic_language;
        this.is_admin = is_admin;
    }


    public User(long id, String name, String basic_language) {
        this.id = id;
        this.name = name;
        this.basic_language = basic_language;
    }

    public User(long id, String name, String password, boolean isAdmin, String basic_language, String time_created) {

    }
}
