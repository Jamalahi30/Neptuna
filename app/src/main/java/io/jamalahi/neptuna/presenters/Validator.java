package io.jamalahi.neptuna.presenters;

/**
 * Created by amanatu on 31/01/18.
 */

public class Validator {


    public static boolean validateEmail(String email){

        return email.matches("([a-zA-Z]+[a-zA-Z0-9.-_]*@[a-zA-Z0-9.-_]+\\.[]a-zA-Z]{2,})");
    }
    public static boolean validatePassword(String password){

        return password.length()>=1;
    }

}
