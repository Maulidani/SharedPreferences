package com.example.testsharedpreferences.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

public class SessionManager {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String NAME = "Sname";
    public static final String USERNAME = "Susername";
    public static final String PASSWORD = "Spassword";
    public static final String JOB = "Sjob";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void CreatLoginSession(String name,String user,String password,String job){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(NAME, name);
        editor.putString(USERNAME, user);
        editor.putString(PASSWORD, password);
        editor.putString(JOB, job);
        editor.commit();
    }

    public HashMap<String, String> getDataCommit(){
        HashMap<String,String> data = new HashMap<>();
        data.put(NAME, sharedPreferences.getString(NAME, null));
        data.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        data.put(PASSWORD, sharedPreferences.getString(PASSWORD, null));
        data.put(JOB, sharedPreferences.getString(JOB, null));
        return data;
    }

    public boolean isLogin(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

    public void logOut(){
        editor.clear();
        editor.commit();
    }

}
