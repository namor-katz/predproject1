package com.mycompany.app.dao;
import java.io.*;
import java.util.Properties;

/*
public class UserDaoFactory {

    public static void main(String[] args) {

        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            String type = property.getProperty("db.host");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }
*/
public class UserDaoFactory {

    public static String parseConfig() throws FileNotFoundException {

        FileInputStream fis;
        Properties property = new Properties();
        String typeDao;

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            typeDao = property.getProperty("daotype");
            return typeDao;
        }
        catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
            typeDao = "fuck";
            return typeDao;
        }
    }



    public static UserDAO getUserDAO(String type) {
        if (type.equalsIgnoreCase("jdbc")) {
            return new UserDAOImpl();
        } else {
            return new UserDAOImpl();
        }
    }
}