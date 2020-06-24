package com.byrinat.arabiclearn.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.byrinat.arabiclearn.objects.Letter;
import com.byrinat.arabiclearn.objects.LetterVowel;

@Database(entities = {Letter.class, LetterVowel.class}, version = 4,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
   public abstract LetterDao letterDao();
   public abstract LetterVowelDao letterVowelDao();
}