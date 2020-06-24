package com.byrinat.arabiclearn.activityes.study

import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.byrinat.arabiclearn.R
import com.byrinat.arabiclearn.Utils.Constants
import com.byrinat.arabiclearn.databinding.ActivityStudyBinding
import com.byrinat.arabiclearn.objects.Letter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_study.*


class StudyActivity : AppCompatActivity(), StudyView {

    companion object {
        private var presenter: StudyPresenter?=null
    }
    private var anim:Animation?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_study)
       val idForIpenLetter= intent.getIntExtra("idForIpenLetter",-1)
       // throw RuntimeException("Мой тестовый краш");
        anim= AnimationUtils.loadAnimation (this,R.anim.anim_for_test_btns);
       var bindig:ActivityStudyBinding =DataBindingUtil.setContentView(this,R.layout.activity_study)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Тестирование");

            if(presenter!=null){
                presenter?.setView(this)
            }else{
                presenter=StudyPresenter(this);
                presenter!!.setOpenLetter(idForIpenLetter)
            }

        bindig.presenter=presenter
    }

    override fun onBackPressed() {
       doFinish()
    }
    override fun initTestButtons() {
        runOnUiThread({
            println("startAnimBtns")
            btnTest.startAnimation(anim)
            btnTest2.startAnimation(anim)
            btnTest1.startAnimation(anim)
            btnTest4.startAnimation(anim)
            tv_name2.startAnimation(anim)})

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            android.R.id.home -> {
               doFinish()
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun showResult(trueAnswer:Int,answerLength:Int) {
       AlertDialog.Builder(this)
           .setTitle("Результат")
           .setCancelable(false)
           .setMessage("Правильных ответов " +trueAnswer+" из "+answerLength)
           .setPositiveButton("OK",object :DialogInterface.OnClickListener{
               override fun onClick(p0: DialogInterface?, p1: Int) {
                   if(answerLength==trueAnswer)
                       presenter?.getOpenLetters()
                   else finish()
                      }

           }).show()
    }
        private  fun doFinish(){

            setResult(Constants.LOAD_LETTERS)
            AlertDialog.Builder(this)
                .setTitle("Завершение тестирования")

                .setMessage("При досрочном завершении тестирования, результаты не будут сохранены. Вы уверены что хотите завершить тестирование?")
                .setPositiveButton("Завершить",object :DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        setResult(RESULT_CANCELED)
                        finish()
                    }

                }).setNegativeButton("Отмена",object :DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {

                    }

                })
                .show()
        }
     override fun openNewLetter(letter: Letter) {
         runOnUiThread({ AlertDialog.Builder(this)
             .setTitle("Поздравляем")
             .setCancelable(false)
             .setMessage("Открыта новая буква (" +letter.name+")  "+letter.russian_name)
             .setPositiveButton("OK",object :DialogInterface.OnClickListener{
                 override fun onClick(p0: DialogInterface?, p1: Int) {
                     finish()
                 }

             }).show()
         })

    }

    override fun onResume() {
        super.onResume()

    }

    override fun finish() {
        super.finish()
        if(this.isFinishing) presenter=null;

    }

    override fun speakCurrenText(message: String?) {




    }

    override fun showMessage(message: String?) {
      Toast.makeText(baseContext,message,Toast.LENGTH_LONG).show()  }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress(prgress:Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            progressBar.setProgress(prgress,true)
        } else{
            progressBar.progress=prgress;
        }
        }



}



