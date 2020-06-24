package com.byrinat.arabiclearn.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.byrinat.arabiclearn.objects.LetterVowel;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface LetterVowelDao {
    @Query("SELECT * FROM LetterVowel")
    List<LetterVowel> getAll();

    @Query("SELECT * FROM LetterVowel WHERE letter_id IN (:id)")
    Flowable<List<LetterVowel>> loadVowelsById(int id);

   // @Query("SELECT * FROM Letter WHERE first_name LIKE :first AND " +
   //        "last_name LIKE :last LIMIT 1")
   // Letter findByName(String first, String last);

    @Query("SELECT * FROM LetterVowel ")
    Flowable<List<LetterVowel>> getAllF();

   @Query("SELECT * FROM LetterVowel WHERE letter_id IN (:id1,:id2,:id3,:id4)  ORDER BY RANDOM() LIMIT 4 ")
   Flowable<List<LetterVowel>> getVowelLetters(int id1,int id2,int id3,int id4);



   //@Query("SELECT * FROM LetterVowel WHERE enable='0'  ORDER BY RANDOM() LIMIT 1 ")
   //Flowable<List<LetterVowel>> getOpenLetter();
    @Insert
    void insertAll(List<LetterVowel> employees);
    @Update
    void update(LetterVowel letter);

    @Delete
    void delete(LetterVowel letter);
}