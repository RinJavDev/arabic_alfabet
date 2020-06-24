package com.byrinat.arabiclearn.app;

import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class AppPreferences {
    private static String PREF_NAME="Preference";
    private static String EMAIL="email";
    private static String FIRST_LOGIN="firs_login";
    private static String offlineMode="offline_Mode";

    public  static void saveEmail(String email){
        SharedPreferences prefs = App.getInstance().getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString(EMAIL, email);
        prefEdit.commit();
    }

    public  static String getEmail(){
        SharedPreferences prefs = App.getInstance().getSharedPreferences(PREF_NAME, MODE_PRIVATE);
       return prefs.getString(EMAIL,null);

    }
    public  static void setOflliteMode(boolean isFirstLogin){
        SharedPreferences prefs = App.getInstance().getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putBoolean(offlineMode, isFirstLogin);
        prefEdit.commit();
    }
    public  static boolean isOflineMode(){
        SharedPreferences prefs = App.getInstance().getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return prefs.getBoolean(offlineMode,false);

    }
    public  static void setFirstLogin(boolean isFirstLogin){
        SharedPreferences prefs = App.getInstance().getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putBoolean(FIRST_LOGIN, isFirstLogin);
        prefEdit.commit();
    }
    public  static boolean isFirstLogin(){
        SharedPreferences prefs = App.getInstance().getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return prefs.getBoolean(FIRST_LOGIN,true);

    }
}
