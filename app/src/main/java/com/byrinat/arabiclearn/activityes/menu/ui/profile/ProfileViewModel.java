package com.byrinat.arabiclearn.activityes.menu.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Раздел 'Профиль' в разработке");
    }

    public LiveData<String> getText() {
        return mText;
    }
}