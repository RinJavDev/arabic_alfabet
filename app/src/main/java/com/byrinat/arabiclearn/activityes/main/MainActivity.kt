package com.byrinat.arabiclearn.activityes.main

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.byrinat.arabiclearn.R
import com.byrinat.arabiclearn.Utils.Constants
import com.byrinat.arabiclearn.activityes.letterInfo.LetterInfoActivity
import com.byrinat.arabiclearn.activityes.study.StudyActivity
import com.byrinat.arabiclearn.objects.Letter
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainView {


val  MY_REQUEST_CODE=1;
    val spanCount=4;
    val  TAG="MainActivity"
    private val dbFireBase = FirebaseFirestore.getInstance()
    private var presenter: MainPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)
       // FirebaseAnalytics.getInstance().c

       // throw RuntimeException("Мой тестовый краш");
        presenter =  MainPresenter(this);
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_study, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_study -> {
                val intent = Intent(this@MainActivity, StudyActivity::class.java)
                intent.putExtra("idForIpenLetter",-1)

                startActivityForResult(intent,Constants.LOAD_LETTERS)
            }
            android.R.id.home -> {
                setResult(RESULT_CANCELED)
                finish()
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onResume() {
        super.onResume()
//        App.getInstance().onCreate()
    }
    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun setLetters(letters:ArrayList<Letter>) {
        println("letters "+letters.size)
        val layoutManager= GridLayoutManager(getApplicationContext(), spanCount);
        layoutManager.setSpanSizeLookup(object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position  == 0) {
                   4
                } else 1
            }
        })
        rv_letters.layoutManager=layoutManager
        rv_letters.adapter=AdapterLetters(letters,object :
            AdapterLetters.OnCurrentItemClickListener {
            override fun onItemClick(letter: Letter?, position: Int) {
                dbFireBase.document("This is my Email/OpenLetters").update(mapOf("azxcsda" to 123))
                //dbFireBase.collection("This is my Email").document("OpenLetters").set(mapOf("one" to 1, "three" to 3, "10" to 10))
               if(letter?.enable!!){
                   val intent = Intent(this@MainActivity, LetterInfoActivity::class.java)
                   intent.putExtra("id", letter?.id)
                  //intent.putExtra("name", letter?.name)
                  //intent.putExtra("russian_name", letter?.russian_name)
                  //intent.putExtra("end_position", letter?.end_position)
                  //intent.putExtra("mid_position", letter?.mid_position)
                  //intent.putExtra("start_position", letter?.start_position)

                   startActivityForResult(intent,MY_REQUEST_CODE)
               }else{
                   AlertDialog.Builder(this@MainActivity)
                       .setTitle(letter.russian_name+" "+letter.name)

                       .setMessage("Буква не открыта, чтобы открыть букву, завершите тестирование без ошибок ")
                       .setPositiveButton("К тестирвоанию",object : DialogInterface.OnClickListener{
                           override fun onClick(p0: DialogInterface?, p1: Int) {
                               val intent = Intent(this@MainActivity, StudyActivity::class.java)
                                intent.putExtra("idForIpenLetter",letter.id)

                               startActivityForResult(intent,Constants.LOAD_LETTERS)
                           }

                       }).show()
                      }


                }

        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "requestCode is "+requestCode)
        if(requestCode==Constants.LOAD_LETTERS){

            presenter?.getLetters()
        }

    }
    override fun showMessage(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
