package com.byrinat.arabiclearn.activityes.main;

import android.util.Log;

import androidx.annotation.NonNull;

import com.byrinat.arabiclearn.R;
import com.byrinat.arabiclearn.Utils.Constants;
import com.byrinat.arabiclearn.app.App;
import com.byrinat.arabiclearn.app.AppPreferences;
import com.byrinat.arabiclearn.objects.Letter;
import com.byrinat.arabiclearn.objects.LetterVowel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

class MainPresenter {
    MainModel mainModel;
    private MainView mainView;
private  static String TAG = "MainPresenter";
Disposable disposable;


    MainPresenter(MainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModel();
        getLetters();
    }
    void getLetters() {

    disposable= mainModel.getAllLetters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccsesReadLetters );




    }

    private void onSuccsesReadLetters(ArrayList<Letter> letters) {
    disposable.dispose();
        if(letters==null||letters.size()==0){
            System.out.println("lettes is 0");
            letters= Constants.getLetters();
            mainModel.addAllLetters(letters);
            mainModel.addAllLetterVowels( Constants.getVowels());
           // mainView.setLetters(letters);

        }else {


                Log.d(TAG,"is firstLogin");
                Map<String,Object> currentOpenDbLetters = new HashMap<>();
                for(Letter letter:letters){
                if(letter.isEnable()) currentOpenDbLetters.put(letter.id+"",letter.id);
                }

                FirebaseFirestore.getInstance().collection(AppPreferences.getEmail()).document(App.getInstance().getString(R.string.openLetters) ).update(currentOpenDbLetters);
                AppPreferences.setFirstLogin(false);



            System.out.println("lettes was in db");
            //mainView.setLetters(letters);
        }

        ArrayList<LetterVowel> vowels= Constants.getVowels();
        for(LetterVowel letterVowel:vowels){
            System.out.println(letterVowel.getArabic_letter()+" "+letterVowel.getTranscription());
        }

      //  for(Letter letter: letters){
      //   if(letter.ge)
      //  }

        DocumentReference docRef = FirebaseFirestore.getInstance().collection(AppPreferences.getEmail()).document(App.getInstance().getString(R.string.openLetters));
        ArrayList<Letter> finalLetters = letters;
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        Map<String,Object> openLetters=document.getData();
                       for(Letter letter: finalLetters){
                          if(openLetters.containsKey(letter.getId()+"")){
                              letter.setEnable(true);
                              Log.d(TAG, "ID data: " + letter.getId());
                          }

                       }
                    mainModel.updateAllLetters(finalLetters);
                        getMainView().setLetters(finalLetters);
                    } else {
                        getMainView().setLetters(finalLetters);
                        Log.d(TAG, "No such document");
                    }
                } else {
                    getMainView().setLetters(finalLetters);
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

       // getMainView().setLetters(finalLetters);
    }


    void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }


    }
    void onErrorConnection(){

    }
    void onItemClicked(String item) {
        if (mainView != null) {
            mainView.showMessage(String.format("%s clicked", item));
        }
    }

    void onDestroy() {
        mainView = null;
    }




    public MainView getMainView() {
        return mainView;
    }
}