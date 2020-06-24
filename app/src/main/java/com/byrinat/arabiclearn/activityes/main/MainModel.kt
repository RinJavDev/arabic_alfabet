package com.byrinat.arabiclearn.activityes.main


  import com.byrinat.arabiclearn.app.App
  import com.byrinat.arabiclearn.db.DbHelper
  import com.byrinat.arabiclearn.objects.Letter
  import com.byrinat.arabiclearn.objects.LetterVowel
  import io.reactivex.Completable
  import io.reactivex.Flowable
  import io.reactivex.android.schedulers.AndroidSchedulers
  import io.reactivex.functions.Action
  import io.reactivex.schedulers.Schedulers


class MainModel {

    private val app: App? = null
    private val letterDao= DbHelper.getInstance().db.letterDao()
    private val letterVowelDao= DbHelper.getInstance().db.letterVowelDao()
    fun  getAllLetters()
            : Flowable<ArrayList<Letter>>? {

        return letterDao!!.allF as Flowable< ArrayList<Letter>>
    }


    fun  addAllLetters(letters: ArrayList<Letter>) {
        Completable.fromAction(Action {
            letterDao.insertAll(letters)
        }) .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( );
    }
    fun  updateAllLetters(letters: ArrayList<Letter>) {
        Completable.fromAction(Action {
            letterDao.updateAll(letters)
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
