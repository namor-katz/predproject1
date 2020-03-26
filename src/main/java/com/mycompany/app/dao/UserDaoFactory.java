package com.mycompany.app.dao;
import java.io.*;
import java.util.Properties;

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



    public static UserDao getUserDAO(String typeDao) {
        if (typeDao.equalsIgnoreCase("jdbc")) {
            return new UserJdbcDao();
        } else {
            return new UserHibernateDao();
        }
    }
}