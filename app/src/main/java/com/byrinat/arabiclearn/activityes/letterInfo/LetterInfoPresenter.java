package com.byrinat.arabiclearn.activityes.letterInfo;

import com.byrinat.arabiclearn.objects.Letter;
import com.byrinat.arabiclearn.objects.LetterVowel;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LetterInfoPresenter {
    LetterIfoModel model;
    private LetterInfoView view;
    private  int letterId ;

    LetterInfoPresenter(LetterInfoView view,int letterId) {
        this.view = view;
        model = new LetterIfoModel();
        this.letterId=letterId;
        getLetterById();
    }
    void getLetterById() {

        model.getLetterFromId(letterId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccsesReadLetters,this::onError );


    }
    void getLetterVowelsById() {

        model.getLetterVowelsById(letterId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccsesReadLetterVowels,this::onError );


    }

    private void onError(Throwable throwable) {
       new RuntimeException(throwable.getMessage());
    }

    private void onSuccsesReadLetterVowels(ArrayList<LetterVowel> letterVowels) {
        for ( LetterVowel letterVowel: letterVowels){
            System.out.println(letterVowel.getArabic_letter()+" "+letterVowel.getTranscription()+" "+letterVowel.getPosition());
        }
        view.setLetterVowels(letterVowels);
    }

    public void setView(LetterInfoView view) {
        this.view = view;
    }

    private void onSuccsesReadLetters(Letter letter) {
        view.setLetter(letter);
        getLetterVowelsById();
    }
}
