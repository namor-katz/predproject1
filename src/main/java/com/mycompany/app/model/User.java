package com.mycompany.app.model;

import javax.persistence.*;

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

    @Column(name = "role")
    private String role;

    @Column(name = "basic_language")
    private String basic_language;

    @Column
    private String time_created;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getBasic_language() {
        return basic_language;
    }

    public String getTime_created() {
        return time_created;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setBasic_language(String basic_language) {
        this.basic_language = basic_language;
    }

    public void setTime_created(String time_created) {
        this.time_created = time_created;
    }

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

    public User(String name, String basic_language, String role) {
        this.name = name;
        this.basic_language = basic_language;
        this.role = role;
    }

    public User(long id, String name, String basic_language) {
        this.id = id;
        this.name = name;
        this.basic_language = basic_language;
    }

    public User(long id, String name, String password, boolean isAdmin, String basic_language, String time_created) {

    }

    public User(String name, String password, String basic_language, String role) {
        this.name = name;
        this.password = password;
        this.basic_language = basic_language;
        this.role = role;
    }
}
