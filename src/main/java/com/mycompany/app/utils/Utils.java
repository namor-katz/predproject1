package com.mycompany.app.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
    public static String HashPassword(String password) throws NoSuchAlgorithmException {
        //this method create hash string of password string
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes());
        String encryptedString = new String(messageDigest.digest());
        return encryptedString;
    }
}
