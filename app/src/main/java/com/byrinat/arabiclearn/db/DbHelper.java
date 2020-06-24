package com.byrinat.arabiclearn.db;

public class DbHelper {
    private static final DbHelper ourInstance = new DbHelper();
    private   AppDatabase db;
    public static DbHelper getInstance() {
        return ourInstance;
    }

    private DbHelper() {
    }



    public AppDatabase getDb() {
        return db;
    }

    public void setDb(AppDatabase db) {
        this.db = db;
    }
}
