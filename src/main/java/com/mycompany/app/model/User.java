package com.mycompany.app.model;
//import javax.persistence.*;
import com.mycompany.app.utils.Utils;
import lombok.Data;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Data   //this is lombok. сеттеров-геттеров нет, но они есть!
public class User {

    private long id;
    private String name;
    private String hash_password;

    public User() {

    }

    public User(String name, String password) throws NoSuchAlgorithmException {
        this.name = name;
        this.hash_password = Utils.HashPassword(password);
    }
}
