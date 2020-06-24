package com.byrinat.arabiclearn.activityes.study


  import com.byrinat.arabiclearn.app.App
  import com.byrinat.arabiclearn.db.DbHelper
  import com.byrinat.arabiclearn.objects.Letter
  import com.byrinat.arabiclearn.objects.LetterVowel
  import io.reactivex.Completable
  import io.reactivex.Flowable
  import io.reactivex.android.schedulers.AndroidSchedulers
  import io.reactivex.functions.Action
  import io.reactivex.schedulers.Schedulers


class StudyModel {


    private val app: App? = null
    private var letterDao= DbHelper.getInstance().db.letterDao()
    private var letterVovelDao= DbHelper.getInstance().db.letterVowelDao()
    fun  getTestLetters()
            : Flowable<ArrayList<Letter>>? {

        return letterDao!!.testLetter as Flowable< ArrayList<Letter>>
    }
    fun  getOpenLetters()
            :  Flowable<List<Letter>>? {

        return letterDao!!.openLetter as  Flowable<List<Letter>>
    }
    fun  getVowelLetters(id1:Int,id2:Int,id3:Int,id4:Int)
            :  Flowable<List<LetterVowel>>? {

        return letterVovelDao!!.getVowelLetters(id1,id2,id3,id4) as  Flowable<List<LetterVowel>>
    }

    fun  updateLetter(letter: Letter) {
        Completable.fromAction(Action {
            letterDao.update(letter)
        }) .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( );
    }





}
