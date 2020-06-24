package com.byrinat.arabiclearn.activityes.letterInfo

import com.byrinat.arabiclearn.app.App
import com.byrinat.arabiclearn.db.DbHelper
import com.byrinat.arabiclearn.objects.Letter
import com.byrinat.arabiclearn.objects.LetterVowel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers

class LetterIfoModel{
    private val app: App? = null
    private val letterDao= DbHelper.getInstance().db.letterDao()
    private val letterVowelDao= DbHelper.getInstance().db.letterVowelDao()
    fun  getLetterFromId(id:Int)
            : Flowable<Letter>? {

        return letterDao!!.loadByIs(id) as Flowable<Letter>
    }
    fun  getLetterVowelsById(id:Int)
            : Flowable<ArrayList<LetterVowel>>? {

        return letterVowelDao!!.loadVowelsById(id) as Flowable<ArrayList<LetterVowel>>
    }

    fun  addAllLetters(letters: ArrayList<Letter>) {
        Completable.fromAction(Action {
            letterDao.insertAll(letters)
        }) .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( );
    }

    fun addAllLetterVowels(vowels: java.util.ArrayList<LetterVowel>) {
        Completable.fromAction(Action {
            letterVowelDao.insertAll(vowels)
        }) .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( );
    }

}
