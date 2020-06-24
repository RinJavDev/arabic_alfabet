package com.byrinat.arabiclearn.activityes.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.byrinat.arabiclearn.R

import com.google.android.gms.auth.api.Auth
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import kotlinx.android.synthetic.main.activity_login.*

import android.content.Intent
import android.util.Log

import com.google.android.gms.auth.api.signin.GoogleSignInResult


import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.byrinat.arabiclearn.activityes.letterInfo.LetterInfoActivity
import com.byrinat.arabiclearn.activityes.letterInfo.LetterInfoPresenter


import com.byrinat.arabiclearn.activityes.main.MainActivity
import com.byrinat.arabiclearn.activityes.menu.MenuActivity
import com.byrinat.arabiclearn.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity(),LoginView {

    companion object {
        private var presenter: LoginPresemter?=null

    }
    private val TAG = "LoginActivity"
    private val RC_SIGN_IN = 1
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_login)

        var bindig: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        if(presenter !=null){
            presenter?.setView(this)
        }else{
           presenter = LoginPresemter(this);
        }
        bindig.presenter= presenter;


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG,"requestCode is"+requestCode)
        if (requestCode === RC_SIGN_IN) {
            presenter?.handleSignInResult(data);

        }
    }



     fun gotoProfile() {
        val intent = Intent(this, MenuActivity ::class.java)
        startActivity(intent)
         finish()
    }
    fun showToast(text:String){
        Toast.makeText(applicationContext,text,Toast.LENGTH_LONG).show()
    }
    fun startGoogleSignIn(intent: Intent) {
        startActivityForResult(intent,RC_SIGN_IN)
    }

    override fun doEnableSign() {
        SignInButtonGoogle.isEnabled=true
    }
}
