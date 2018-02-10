package io.jamalahi.neptuna.presenters;

import io.jamalahi.neptuna.database.models.User;

/**
 * Created by amanatu on 31/01/18.
 */

public class Authentication {

    public static User signIn(User u)
    {
        return new User(1, "Amaanatu DIOP", "jamalahi30", "elichou");

    }

}
