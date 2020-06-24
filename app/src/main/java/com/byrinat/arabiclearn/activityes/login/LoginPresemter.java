package com.byrinat.arabiclearn.activityes.login;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.byrinat.arabiclearn.R;
import com.byrinat.arabiclearn.app.App;
import com.byrinat.arabiclearn.app.AppPreferences;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.opencensus.resource.Resource;

public class LoginPresemter {
    LoginActivity view;
    private GoogleApiClient googleApiClient;
private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    public LoginPresemter(LoginActivity view) {
        this.view = view;

if(!AppPreferences.isFirstLogin()){
    onGoogleSignIn();
}else {
    view.doEnableSign();
}

    }


    public void onGoogleSignIn(){
        GoogleSignInOptions gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient=new GoogleApiClient.Builder(App.getInstance().getApplicationContext())
                .enableAutoManage(view, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        view.doEnableSign();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();


        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        view.startGoogleSignIn(intent);
    }

    public void setView(@NotNull LoginActivity loginActivity) {
    this.view=view;
    }

    public void handleSignInResult(@Nullable Intent data) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

        if (result.isSuccess()) {
            AppPreferences.saveEmail(result.getSignInAccount().getEmail());
       //     result.getSignInAccount().getId();

           view. gotoProfile();

            firebaseFirestore.collection(result.getSignInAccount().getEmail())
                   // .whereEqualTo("title", "Task1")
                    .get()
                    .addOnSuccessListener(querySnapshot -> {

                        // Успешно получили данные. Список в querySnapshot.documents
                        List<DocumentSnapshot> snapshots= querySnapshot.getDocuments();
                        initLetters(result,snapshots);
                      //

                      //  firebaseFirestore.collection("MyDB2").document("title");
                    } ).addOnFailureListener(  exception ->{
                        view.showToast("Данныx там нету, " + exception.getMessage());
                        // Произошла ошибка при получении данных
            }
            );

        }



    }
    private void initLetters(GoogleSignInResult result ,  List<DocumentSnapshot> snapshots){

    for(DocumentSnapshot documentSnapshot:snapshots){
        System.out.println("getId "+documentSnapshot.getId());
        if(documentSnapshot.getId().equals(view.getString(R.string.openLetters))){
            System.out.println("collection Close");
              return;
        }

    }
    Map<String,Object> map = new HashMap<>();
    map.put("0",new Integer(0));
    map.put("1",new Integer(1));
    map.put("2",new Integer(2));
    map.put("3",new Integer(3));
    System.out.println("collection initLetters");
   firebaseFirestore.collection(AppPreferences.getEmail()).document(view.getString(R.string.openLetters) ).set(map);
}
   public void onGoogleSignInOfflineMode(){
        AppPreferences.setOflliteMode(true);
        view.gotoProfile();
   }
}
