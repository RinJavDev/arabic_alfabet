package com.byrinat.arabiclearn.activityes.menu.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SettingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Раздел 'Настройки' находится в разработке");
    }

    public LiveData<String> getText() {
        return mText;
    }
}