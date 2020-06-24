package com.byrinat.arabiclearn.db;

import androidx.room.*;


import com.byrinat.arabiclearn.objects.Letter;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface LetterDao {
    @Query("SELECT * FROM Letter")
    List<Letter> getAll();

    @Query("SELECT * FROM Letter WHERE id IN (:userIds)")
    Flowable<Letter> loadByIs(int userIds);

    @Query("SELECT * FROM Letter WHERE id IN (:userIds)")
    List<Letter> loadAllByIds(int[] userIds);

   // @Query("SELECT * FROM Letter WHERE first_name LIKE :first AND " +
   //        "last_name LIKE :last LIMIT 1")
   // Letter findByName(String first, String last);

    @Query("SELECT * FROM Letter ")
    Flowable<List<Letter>> getAllF();

    @Query("SELECT * FROM Letter WHERE enable  ORDER BY RANDOM() LIMIT 4 ")
    Flowable<List<Letter>> getTestLetter();



    @Query("SELECT * FROM Letter WHERE enable='0'  ORDER BY RANDOM() LIMIT 1 ")
    Flowable<List<Letter>> getOpenLetter();

    @Update
    void updateAll(List<Letter> employees);
    @Insert
    void insertAll(List<Letter> employees);
    @Update
    void update(Letter letter);

    @Delete
    void delete(Letter letter);
}