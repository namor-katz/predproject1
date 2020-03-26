package com.mycompany.app.dao;
import java.io.*;
import java.util.Properties;

public class UserDaoFactory {

    public UserDaoFactory() throws FileNotFoundException {
    }

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


    private static String typeDao;

    static {
        try {
            typeDao = parseConfig();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static UserDao getUserDAO() {
        if (typeDao.equalsIgnoreCase("jdbc")) {
            return new UserJdbcDao();
        } else {
            return new UserHibernateDao();
        }
    }
}