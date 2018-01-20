package io.jamalahi.neptuna.database.models;

/**
 * Created by amanatu on 20/01/18.
 */

public class User {

    public String name,login,password;
    public int id;

    public User(String login, String password){

        this.login = login;
        this.password = password;
    }
    public User(String name, String login, String password){

        this(login, password);
        this.name = name;
    }

    public User(int id, String name,String login, String password){

        this(name,login,password);
        this.id = id;
    }

    public boolean isValid() {
        return login.length()>0 && password.length()>0;

    }

}
