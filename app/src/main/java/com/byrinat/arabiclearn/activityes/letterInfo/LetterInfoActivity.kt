package com.byrinat.arabiclearn.activityes.letterInfo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.byrinat.arabiclearn.objects.Letter
import com.byrinat.arabiclearn.databinding.ActivityLetterInfoBinding
import com.byrinat.arabiclearn.objects.LetterVowel
import kotlinx.android.synthetic.main.activity_letter_info.*
import java.util.ArrayList
import android.util.Log
import android.view.View
import android.widget.TextView


class LetterInfoActivity : AppCompatActivity() , LetterInfoView {



    companion object {
        private var presenter: LetterInfoPresenter?=null

    }
    private var TAG="LetterInfoActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        //setContentView(R.layout.activity_letter_info)
        var bindig: ActivityLetterInfoBinding = DataBindingUtil.setContentView(this,
            com.byrinat.arabiclearn.R.layout.activity_letter_info)
        var intent = getIntent()
        if(presenter !=null){
            presenter?.setView(this)
        }else{
            presenter = LetterInfoPresenter(this,intent.getIntExtra("id",0));
        }
        bindig.presenter= presenter;


       //setTitle("Буква ["+intent.getStringExtra("name")+"]");

       //tv_name.setText(intent.getStringExtra("name"))
       //tv_end.setText(intent.getStringExtra("end_position"))
       //tv_mid.setText(intent.getStringExtra("mid_position"))
       //tv_start.setText(intent.getStringExtra("start_position"))
       //tv_rus_name.setText(intent.getStringExtra("russian_name"))

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            android.R.id.home -> {
                setResult(RESULT_CANCELED)
                finish()
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun setLetter(letters: Letter?) {
        setTitle("Буква ["+letters?.name+"]");
        tv_name.setText(letters?.name)
        tv_end.setText(letters?.end_position)
        tv_mid.setText(letters?.mid_position)
        tv_start.setText(letters?.start_position)
        tv_rus_name.setText(letters?.russian_name)

    }
    override fun setLetterVowels(letterVowels: ArrayList<LetterVowel>) {


        Log.d(TAG,"letterVowels size is "+ letterVowels.size);
        if(letterVowels.size==9){
            lastTableRow.visibility=View.GONE;
        }else{
            lastTableRow.visibility=View.VISIBLE;
        }


        initLetter(r13,a13,0,letterVowels)
        initLetter(r23,a23,0,letterVowels)
        initLetter(r33,a33,0,letterVowels)
        initLetter(r43,a43,0,letterVowels)

        initLetter(r12,a12,1,letterVowels)
        initLetter(r22,a22,1,letterVowels)
        initLetter(r32,a32,1,letterVowels)
        initLetter(r42,a42,1,letterVowels)

        initLetter(r11,a11,2,letterVowels)
        initLetter(r21,a21,2,letterVowels)
        initLetter(r31,a31,2,letterVowels)
        initLetter(r41,a41,2,letterVowels)


        }

        fun initLetter(rv_rus:TextView,tv_arabic:TextView,letterPosition:Int,letterVowels: ArrayList<LetterVowel>?){
            for (i in 0 until letterVowels?.size!!) {
                val letterVowel=letterVowels.get(i)
                if(letterVowel.position==letterPosition){
                    rv_rus.text=letterVowel.transcription
                    tv_arabic.text=letterVowel.arabic_letter
                    letterVowels.remove(letterVowel)
                    break;
                }
        }
      // val layoutManager= GridLayoutManager(getApplicationContext(), 3,GridLayoutManager.VERTICAL,false);
      //rvLetterVowels.layoutManager=layoutManager
      //rvLetterVowels.adapter= AdapterLetterVowels(letterVowels)
    }
    override fun finish() {
        super.finish()
        if(this.isFinishing) presenter =null;

    }
}
