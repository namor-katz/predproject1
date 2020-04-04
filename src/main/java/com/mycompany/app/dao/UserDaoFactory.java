package com.mycompany.app.dao;
import java.io.*;
import java.util.Properties;

public class UserDaoFactory {

    public UserDaoFactory() throws FileNotFoundException {
    }

    public String parseConfig() {
        String typeDao;
        try {
            Properties property = new Properties();
            String propFileName = "config.properties";
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            property.load(inputStream);
            typeDao = property.getProperty("daotype");
            return typeDao;
        }
        catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсутствует!");
            typeDao = "ff";
            return typeDao;
        }
    }

    public static UserDao getUserDAO() {
        UserDaoFactory userDaoFactory = null;
        try {
            userDaoFactory = new UserDaoFactory();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String typeDao = userDaoFactory.parseConfig();
        if (typeDao.equalsIgnoreCase("jdbc")) {
            return new UserJdbcDao();
        } else {
            return new UserHibernateDao();
        }
    }
}