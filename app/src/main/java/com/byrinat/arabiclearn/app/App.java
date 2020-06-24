package com.byrinat.arabiclearn.app;

import android.app.Application;

import androidx.room.Room;


import com.byrinat.arabiclearn.db.AppDatabase;
import com.byrinat.arabiclearn.db.DbHelper;

public class App extends Application {

static  App instance;
  private   AppDatabase db;
  private  String id;
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("App is creating");

        db = Room.databaseBuilder(this.getBaseContext(),
                AppDatabase.class, "database-name").build();

        DbHelper.getInstance().setDb(db);
        instance=this;
    }

    public static App getInstance() {
        return instance;
    }

    public void setId(String id) {
        this.id=id;
    }

}
