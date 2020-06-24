package com.byrinat.arabiclearn.activityes.study;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.byrinat.arabiclearn.R;
import com.byrinat.arabiclearn.Utils.Constants;
import com.byrinat.arabiclearn.app.App;
import com.byrinat.arabiclearn.app.AppPreferences;
import com.byrinat.arabiclearn.objects.Letter;
import com.byrinat.arabiclearn.objects.LetterVowel;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class StudyPresenter   {
    StudyModel studyModel;
    private StudyView studyView;
    private String text;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private int testCount=0;
    private  int idForIpenLetter;
    private int testLength=2;
    private int trueAnswer=0;
    Disposable disposable;
 // public ObservableField<String> bnt1Text = new ObservableField<>();
 // public ObservableField<String> bnt2Text;
 // public ObservableField<String> bnt3Text;
  public ArrayList<ObservableField<String>> bntsText=new ArrayList<>();
  public ObservableField<String> textView;

    StudyPresenter(StudyView studyView) {
        this.studyView = studyView;
        studyModel = new StudyModel();
        getTestLetters();
        textView=new ObservableField<>();

        bntsText.add(new ObservableField<>());
        bntsText.add(new ObservableField<>());
        bntsText.add(new ObservableField<>());
        bntsText.add(new ObservableField<>());

       // bnt1Text.set("123");
    }
    void getTestLetters() {

       Flowable<ArrayList<Letter>> flowable=studyModel.getTestLetters();
                flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
                disposable = flowable
                .subscribe(this::onSuccsesReadLetters );
 }


    public void   onClick(@NonNull final View view){
        System.out.println("123 "+((Button) view).getText()+" "+text);
        if(((Button) view).getText().toString().equals(text)){
            getStudyView().showMessage("Верно");
            trueAnswer++;
        }else {
            getStudyView().showMessage("Не верно");
        };
        testCount++;
        getStudyView().showProgress((int) (((float)testCount/testLength)*100));
        if(testCount<=testLength-1){


            getTestLetters();
        }else {
            getStudyView().showResult(trueAnswer,testLength);

        }

    }
    void getOpenLetters() {
if(idForIpenLetter==-1){
    Flowable<List<Letter>> flowable= studyModel.getOpenLetters();
    flowable .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    disposable=flowable.subscribe(this::onSuccsesOpenLetters);
}else {
    for(Letter letter:Constants.getLetters()){
        if(letter.getId()==idForIpenLetter){
           saveLetterInFirebase(letter);  // firebaseFirestore

            System.out.println("onSuccsesOpenLetters" +letter.name +" "+letter.id);
            letter.enable=true;
            studyModel.updateLetter(letter);

            getStudyView().openNewLetter(letter);
            break;
        }
    }
}

    }

    private void onSuccsesOpenLetters(List<Letter> letters) {
        disposable.dispose();
        if(letters!=null&&letters.size()>=1){
            saveLetterInFirebase(letters.get(0));
             // firebaseFirestore
            Letter letter =letters.get(0);
            System.out.println("onSuccsesOpenLetters" +letters.get(0).name +" "+letters.get(0).id);
            letter.enable=true;
            studyModel.updateLetter(letter);

            getStudyView().openNewLetter(letter);

        }else {
            getStudyView().finish();
        }

        //  System.out.println(bnt1Text.get());

    }
    private void onSuccesGetVowelLetters(List<LetterVowel> vowels){
        int randListPosition= (int) (Math.random()*3);
        for(int i=0;i<vowels.size();i++){
           // String randomName=(vowels.get(i).getRandomNameFromPosition());
            bntsText.get(i).set(vowels.get(i).getArabic_letter());
            if(i==randListPosition){

                text=vowels.get(i).getArabic_letter();
                textView.set(vowels.get(i).getTranscription());
            }
        }
        getStudyView().speakCurrenText(text);
        getStudyView().initTestButtons();
        disposable.dispose();
    }
    private void onSuccsesReadLetters(ArrayList<Letter> letters) {

        Flowable<List<LetterVowel>> flowable= studyModel.getVowelLetters(letters.get(0).id,letters.get(1).id,letters.get(2).id,letters.get(3).id);
        flowable .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        disposable=flowable.subscribe(this::onSuccesGetVowelLetters);
        //-------------------
                    // int randListPosition= (int) (Math.random()*3);
                    // for(int i=0;i<letters.size();i++){
                    //     String randomName=(letters.get(i).getRandomNameFromPosition());
                    //     bntsText.get(i).set(randomName);
                    //    if(i==randListPosition){

                    //        text=randomName;
                    //       textView.set(letters.get(i).russian_name);
                    //    }
                    // }
                    // getStudyView().speakCurrenText(text);
                    //  getStudyView().initTestButtons();

    }


    void onResume() {
       // if (studyView != null) {
       //     studyView.showProgress();
       // }


    }
    void onErrorConnection(){

    }
    void onItemClicked(String item) {
        if (studyView != null) {
            studyView.showMessage(String.format("%s clicked", item));
        }
    }

    void onDestroy() {
        studyView = null;
    }

    public StudyView getStudyView() {
        return studyView;
    }


    public void setView(@NotNull StudyActivity studyActivity) {
        studyView = studyActivity;
    }

    public void setOpenLetter(int idForIpenLetter) {

        this.idForIpenLetter= idForIpenLetter;
    }
  private void saveLetterInFirebase(Letter letter){
        if(!AppPreferences.isOflineMode()){
            Map<String,Object> map = new HashMap<>();
            map.put(letter.id+"",new Integer(letter.id));
            firebaseFirestore.collection(AppPreferences.getEmail()).document(App.getInstance().getApplicationContext().getString(R.string.openLetters) ).update(map);

        }

  }
}