package io.jamalahi.neptuna.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import io.jamalahi.neptuna.database.models.User;

public class Session {

    private static final String FILENAME = "neptuna.app";
    private static final String USER = "user";

    SharedPreferences preferences;

    SharedPreferences.Editor editor;

    public Session(Context context) {
        preferences = context.getSharedPreferences(FILENAME, 0);
        editor = preferences.edit();
    }

    public void start(User user) {
        editor.putString(USER, new Gson().toJson(user));
        editor.commit();
    }

    public void finish() {
        if (preferences.contains(USER)) {
            editor.remove(USER);
            editor.commit();
        }
    }

    public boolean isActive() {
        return (preferences.contains(USER));
    }

}
