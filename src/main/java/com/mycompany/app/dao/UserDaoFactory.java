package com.mycompany.app.dao;
import java.io.*;
import java.util.Properties;

public class UserDaoFactory {

    public UserDaoFactory() throws FileNotFoundException {
    }

    public static String parseConfig() {

        FileInputStream fis;
        Properties property = new Properties();
        String typeDao;

        try {
            fis = new FileInputStream("/home/guest/my-app/src/main/resources/config.properties");
            property.load(fis);
            typeDao = property.getProperty("daotype");
            System.out.println("УРЯЯЯЯ! JDBC!");
            return typeDao;
        }
        catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
            typeDao = "fuck";
            return typeDao;
        }
    }


    private static String typeDao;

    static {
        typeDao = parseConfig();
    }

    public static UserDao getUserDAO() {
        if (typeDao.equalsIgnoreCase("jdbc")) {
            return new UserJdbcDao();
        } else {
            return new UserHibernateDao();
        }
    }
}