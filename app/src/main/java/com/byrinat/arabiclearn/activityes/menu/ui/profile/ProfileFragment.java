package com.byrinat.arabiclearn.activityes.menu.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.byrinat.arabiclearn.R;


public class ProfileFragment extends Fragment {

    private ProfileViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
     //   notificationsViewModel =
     //           ViewModelProviders.of(this).get(ProfileViewModel.class);
       View root = inflater.inflate(R.layout.profile_fragment, container, false);
     //   final TextView textView = root.findViewById(R.id.navigation_notifications);
     //   notificationsViewModel.getText().observe(this, new Observer<String>() {
     //       @Override
     //       public void onChanged(@Nullable String s) {
     //           textView.setText(s);
     //       }
     //   });
       return root;
    }
}