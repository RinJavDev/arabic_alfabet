package com.byrinat.arabiclearn.activityes.menu.ui.questions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuestionsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QuestionsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Раздел 'Задачи' находится в разработке");
    }

    public LiveData<String> getText() {
        return mText;
    }
}