package com.byrinat.arabiclearn.activityes.menu.ui.courses;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.byrinat.arabiclearn.R;
import com.byrinat.arabiclearn.activityes.main.MainActivity;


public class CoursesFragment extends Fragment {

    private CoursesViewModel homeViewModel;
Button btnGoAlphabet;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(CoursesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_courses, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        btnGoAlphabet =  root.findViewById(R.id.btn_go_alfabet);
        btnGoAlphabet.setOnClickListener((view -> goAlfabet()));
        return root;
    }
    public void goAlfabet(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}