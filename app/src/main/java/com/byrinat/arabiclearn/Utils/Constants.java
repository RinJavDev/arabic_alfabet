package com.byrinat.arabiclearn.Utils;

import android.content.Context;

import com.byrinat.arabiclearn.R;
import com.byrinat.arabiclearn.app.App;
import com.byrinat.arabiclearn.objects.Letter;
import com.byrinat.arabiclearn.objects.LetterVowel;

import java.util.ArrayList;

public class Constants {

public  static  int LOAD_LETTERS=1000;
    public static ArrayList<Letter> getLetters() {
        ArrayList<Letter> letters = new ArrayList<>();
        letters.add(new Letter(0 ,"Алиф"    ,"ـا","ـا","ا","ا",true));
        letters.add(new Letter(1 ,"Ба"    ,"ـب","ـبـ","بـ","ب",true));
        letters.add(new Letter(2 ,"Та"    ,"ـت","ـتـ","تـ","ت",true));
        letters.add(new Letter(3 ,"Са"    ,"ـث","ـثـ","ثـ","ث",true));
        letters.add(new Letter(4 ,"Джим"    ,"ـج","ـجـ","جـ","ج",false));
        letters.add(new Letter(5 ,"Ха"    ,"ـح","ـحـ","حـ","ح",false));
        letters.add(new Letter(6 ,"Хо"    ,"ـخ","ـخـ","خـ","خ",false));
        letters.add(new Letter(7 ,"Даль"    ,"ـد","ـد","د","د",false));
        letters.add(new Letter(8 ,"Заль"    ,"ـذ","ـذ","ذ","ذ",false));
        letters.add(new Letter(9 ,"Ра"    ,"ـر","ـر","ر","ر" ,false));
        letters.add(new Letter(10,"За"    ,"ـز","ـز","ز","ز",false));
        letters.add(new Letter(11,"Син"    ,"ـس","ـسـ","سـ","س",false));
        letters.add(new Letter(12,"Шин"    ,"ـش","ـشـ","شـ","ش",false));
        letters.add(new Letter(13,"Сад"    ,"ـص","ـصـ","ص","ص",false));
        letters.add(new Letter(14,"Дад"    ,"ـض","ـضـ","ضـ","ض",false));
        letters.add(new Letter(15,"Та"    ,"ـط","ـطـ","طـ","ط",false));
        letters.add(new Letter(16,"За"    ,"ـظ","ـظـ","ظـ","ظ",false));
        letters.add(new Letter(17,"Aъйн"    ,"ـع","ـعـ","عـ","ع",false));
        letters.add(new Letter(18,"Гъайн"    ,"ـغ","ـغـ","غـ","غ",false));
        letters.add(new Letter(19,"Фа"    ,"ـف","ـفـ","فـ","ف",false));
        letters.add(new Letter(20,"Къаф"    ,"ـق","ـقـ","قـ","ق",false));
        letters.add(new Letter(21,"Каф"    ,"ـك","ـكـ","كـ","ك",false));
        letters.add(new Letter(22,"Лам"    ,"ـل","ـلـ","لـ","ل",false));
        letters.add(new Letter(23,"Мим"    ,"ـم","ـمـ","مـ","م",false));
        letters.add(new Letter(24,"Нун"    ,"ـن","ـنـ","نـ","ن",false));
        letters.add(new Letter(25,"Гьа"    ,"ـه","ـهـ","هـ","ه",false));
        letters.add(new Letter(26,"Уау"    ,"ـو","ـو","و",  "و"   ,false));
        letters.add(new Letter(27,"Я"    ,"ـي","ـيـ","يـ","ي",false));


        return letters;
    }

    public static ArrayList<LetterVowel> getVowels() {
       Context context= App.getInstance().getApplicationContext();
        ArrayList<LetterVowel> letters = new ArrayList<>();
        ///Алиф
        letters.add(new LetterVowel(0, context.getString(R.string.a11),"اَ ",0));
        letters.add(new LetterVowel(0, context.getString(R.string.a12),"اِ ",0));
        letters.add(new LetterVowel(0, context.getString(R.string.a13),"اُ",0));

        letters.add(new LetterVowel(1,  context.getString(R.string.a11),"ـاَ ",0));
        letters.add(new LetterVowel(1,  context.getString(R.string.a12),"ـاِ",0));
        letters.add(new LetterVowel(1,  context.getString(R.string.a13),"ـاُ",0));

        letters.add(new LetterVowel(2,  context.getString(R.string.a11),"ـاَ",0));
        letters.add(new LetterVowel(2,  context.getString(R.string.a12),"ـاِ",0));
        letters.add(new LetterVowel(2,  context.getString(R.string.a13),"ـاُ ",0));
        //Ба
        letters.add(new LetterVowel(0,  context.getString(R.string.a21),"بَـ",1));
        letters.add(new LetterVowel(0,  context.getString(R.string.a22),"بِـ",1));
        letters.add(new LetterVowel(0,  context.getString(R.string.a23),"بُـ",1));
        letters.add(new LetterVowel(0,  context.getString(R.string.a24) ,"بْـ",1));

        letters.add(new LetterVowel(1,  context.getString(R.string.a21),"ـبَـ",1));
        letters.add(new LetterVowel(1,  context.getString(R.string.a22),"ـبِـ",1));
        letters.add(new LetterVowel(1,  context.getString(R.string.a23),"ـبُـ",1));
        letters.add(new LetterVowel(1,  context.getString(R.string.a24),"ـبْـ",1));

        letters.add(new LetterVowel(2, context.getString(R.string.a21),"ـبَ",1));
        letters.add(new LetterVowel(2, context.getString(R.string.a22),"ـبِ",1));
        letters.add(new LetterVowel(2, context.getString(R.string.a23),"ـبُ",1));
        letters.add(new LetterVowel(2, context.getString(R.string.a24),"ـبْ",1));
        //TA
        letters.add(new LetterVowel(0,  context.getString(R.string.a31),"تَـ",2));
        letters.add(new LetterVowel(0,  context.getString(R.string.a32),"تِـ",2));
        letters.add(new LetterVowel(0,  context.getString(R.string.a33),"تُـ",2));
        letters.add(new LetterVowel(0,  context.getString(R.string.a34),"تْـ",2));

        letters.add(new LetterVowel(1, context.getString(R.string.a31),"ـتَـ",2));
        letters.add(new LetterVowel(1, context.getString(R.string.a32),"ـتِـ",2));
        letters.add(new LetterVowel(1, context.getString(R.string.a33),"ـتُـ",2));
        letters.add(new LetterVowel(1, context.getString(R.string.a34),"ـتْـ",2));

        letters.add(new LetterVowel(2, context.getString(R.string.a31),"ـتَ",2));
        letters.add(new LetterVowel(2, context.getString(R.string.a32),"ـتِ",2));
        letters.add(new LetterVowel(2, context.getString(R.string.a33),"ـتُ",2));
        letters.add(new LetterVowel(2, context.getString(R.string.a34),"ـتْ",2));
        //Tha
        letters.add(new LetterVowel(0, context.getString(R.string.a41),"ثَـ",3));
        letters.add(new LetterVowel(0, context.getString(R.string.a42),"ثِـ",3));
        letters.add(new LetterVowel(0, context.getString(R.string.a43),"ثُـ",3));
        letters.add(new LetterVowel(0, context.getString(R.string.a44),"ثْـ",3));

        letters.add(new LetterVowel(1,  context.getString(R.string.a41),"ـثَـ",3));
        letters.add(new LetterVowel(1,  context.getString(R.string.a42),"ـثِـ",3));
        letters.add(new LetterVowel(1,  context.getString(R.string.a43),"ـثُـ",3));
        letters.add(new LetterVowel(1,  context.getString(R.string.a44),"ـثْـ",3));

        letters.add(new LetterVowel(2, context.getString(R.string.a41),"ـثَ",3));
        letters.add(new LetterVowel(2, context.getString(R.string.a42),"ـثِ",3));
        letters.add(new LetterVowel(2, context.getString(R.string.a43),"ـثُ",3));
        letters.add(new LetterVowel(2, context.getString(R.string.a44),"ـثْ",3));

        //Джи:м
        letters.add(new LetterVowel(0, context.getString(R.string.a51),"جَـ",4));
        letters.add(new LetterVowel(0, context.getString(R.string.a52),"جِـ",4));
        letters.add(new LetterVowel(0, context.getString(R.string.a53),"جُـ",4));
        letters.add(new LetterVowel(0, context.getString(R.string.a54),"جْـ",4));

        letters.add(new LetterVowel(1, context.getString(R.string.a51),"ـجَـ",4));
        letters.add(new LetterVowel(1, context.getString(R.string.a52),"ـجِـ",4));
        letters.add(new LetterVowel(1, context.getString(R.string.a53),"ـجُـ",4));
        letters.add(new LetterVowel(1, context.getString(R.string.a54),"ـجْـ",4));

        letters.add(new LetterVowel(2, context.getString(R.string.a51),"ـجَ",4));
        letters.add(new LetterVowel(2, context.getString(R.string.a52),"ـجِ",4));
        letters.add(new LetterVowel(2, context.getString(R.string.a53),"ـجُ",4));
        letters.add(new LetterVowel(2, context.getString(R.string.a54),"ـجْ",4));

        //ХА
        letters.add(new LetterVowel(0,  context.getString(R.string.a61),"حَـ",5));
        letters.add(new LetterVowel(0,  context.getString(R.string.a62),"حِـ",5));
        letters.add(new LetterVowel(0,  context.getString(R.string.a63),"حُـ",5));
        letters.add(new LetterVowel(0,  context.getString(R.string.a64),"حْـ",5));

        letters.add(new LetterVowel(1,  context.getString(R.string.a61),"ـحَـ",5));
        letters.add(new LetterVowel(1,  context.getString(R.string.a62),"ـحِـ",5));
        letters.add(new LetterVowel(1,  context.getString(R.string.a63),"ـحُـ",5));
        letters.add(new LetterVowel(1,  context.getString(R.string.a64),"ـحْـ",5));

        letters.add(new LetterVowel(2,  context.getString(R.string.a61),"ـحَ",5));
        letters.add(new LetterVowel(2,  context.getString(R.string.a62),"ـحِ",5));
        letters.add(new LetterVowel(2,  context.getString(R.string.a63),"ـحُ",5));
        letters.add(new LetterVowel(2,  context.getString(R.string.a64),"ـحْ",5));
        //Хo
        letters.add(new LetterVowel(0, context.getString(R.string.a71),"خَـ",6));
        letters.add(new LetterVowel(0, context.getString(R.string.a72),"خِـ",6));
        letters.add(new LetterVowel(0, context.getString(R.string.a73),"خُـ",6));
        letters.add(new LetterVowel(0, context.getString(R.string.a74),"خْـ",6));

        letters.add(new LetterVowel(1, context.getString(R.string.a71),"ـخَـ",6));
        letters.add(new LetterVowel(1, context.getString(R.string.a72),"ـخِـ",6));
        letters.add(new LetterVowel(1, context.getString(R.string.a73),"ـخُـ",6));
        letters.add(new LetterVowel(1, context.getString(R.string.a74),"ـخْـ",6));

        letters.add(new LetterVowel(2, context.getString(R.string.a71),"ـخَ",6));
        letters.add(new LetterVowel(2, context.getString(R.string.a72),"ـخِ",6));
        letters.add(new LetterVowel(2, context.getString(R.string.a73),"ـخُ",6));
        letters.add(new LetterVowel(2, context.getString(R.string.a74),"ـخْ",6));
        //Дэ:ль
        letters.add(new LetterVowel(0, context.getString(R.string.a81),"دَ",7));
        letters.add(new LetterVowel(0, context.getString(R.string.a82),"دِ",7));
        letters.add(new LetterVowel(0, context.getString(R.string.a83),"دُ",7));
        letters.add(new LetterVowel(0, context.getString(R.string.a84),"دْ",7));

        letters.add(new LetterVowel(1, context.getString(R.string.a81),"ـدَ",7));
        letters.add(new LetterVowel(1, context.getString(R.string.a82),"ـدِ",7));
        letters.add(new LetterVowel(1, context.getString(R.string.a83),"ـدُ",7));
        letters.add(new LetterVowel(1, context.getString(R.string.a84),"ـدْ",7));

        letters.add(new LetterVowel(2, context.getString(R.string.a81),"ـدَ",7));
        letters.add(new LetterVowel(2, context.getString(R.string.a82),"ـدِ",7));
        letters.add(new LetterVowel(2, context.getString(R.string.a83),"ـدُ",7));
        letters.add(new LetterVowel(2, context.getString(R.string.a84),"ـدْ",7));
        //Thэ:ль
        letters.add(new LetterVowel(0, context.getString(R.string.a91),"ذََ",8));
        letters.add(new LetterVowel(0, context.getString(R.string.a92),"ذِِ",8));
        letters.add(new LetterVowel(0, context.getString(R.string.a93),"ذُُ",8));
        letters.add(new LetterVowel(0, context.getString(R.string.a94),"ذْْ",8));

        letters.add(new LetterVowel(1, context.getString(R.string.a91),"ـذََ",8));
        letters.add(new LetterVowel(1, context.getString(R.string.a92),"ـذِِ",8));
        letters.add(new LetterVowel(1, context.getString(R.string.a93),"ـذُُ",8));
        letters.add(new LetterVowel(1, context.getString(R.string.a94),"ـذْْ",8));

        letters.add(new LetterVowel(2, context.getString(R.string.a91),"ـذََ",8));
        letters.add(new LetterVowel(2, context.getString(R.string.a92),"ـذِِ",8));
        letters.add(new LetterVowel(2, context.getString(R.string.a93),"ـذُُ",8));
        letters.add(new LetterVowel(2, context.getString(R.string.a94),"ـذْْ",8));
        //Ро
        letters.add(new LetterVowel(0, context.getString(R.string.a101),"رَ",9));
        letters.add(new LetterVowel(0, context.getString(R.string.a102),"رِ",9));
        letters.add(new LetterVowel(0, context.getString(R.string.a103),"رُ",9));
        letters.add(new LetterVowel(0, context.getString(R.string.a104),"رْ",9));

        letters.add(new LetterVowel(1, context.getString(R.string.a101),"ـرَ",9));
        letters.add(new LetterVowel(1, context.getString(R.string.a102),"ـرِ",9));
        letters.add(new LetterVowel(1, context.getString(R.string.a103),"ـرُ",9));
        letters.add(new LetterVowel(1, context.getString(R.string.a104),"ـرْ",9));

        letters.add(new LetterVowel(2, context.getString(R.string.a101),"ـرَ",9));
        letters.add(new LetterVowel(2, context.getString(R.string.a102),"ـرِ",9));
        letters.add(new LetterVowel(2, context.getString(R.string.a103),"ـرُ",9));
        letters.add(new LetterVowel(2, context.getString(R.string.a104),"ـرْ",9));
        //Зэ:йй
        letters.add(new LetterVowel(0, context.getString(R.string.a111),"زََ",10));
        letters.add(new LetterVowel(0, context.getString(R.string.a112),"زِِ",10));
        letters.add(new LetterVowel(0, context.getString(R.string.a113),"زُُ",10));
        letters.add(new LetterVowel(0, context.getString(R.string.a114),"زْْ",10));

        letters.add(new LetterVowel(1, context.getString(R.string.a111),"ـزََ",10));
        letters.add(new LetterVowel(1, context.getString(R.string.a112),"ـزِِ",10));
        letters.add(new LetterVowel(1, context.getString(R.string.a113),"ـزُُ",10));
        letters.add(new LetterVowel(1, context.getString(R.string.a114),"ـزْْ",10));

        letters.add(new LetterVowel(2, context.getString(R.string.a111),"ـزََ",10));
        letters.add(new LetterVowel(2, context.getString(R.string.a112),"ـزِِ",10));
        letters.add(new LetterVowel(2, context.getString(R.string.a113),"ـزُُ",10));
        letters.add(new LetterVowel(2, context.getString(R.string.a114),"ـزْْ",10));

        //Си:н

        letters.add(new LetterVowel(0,  context.getString(R.string.a121),"سَـ",11));
        letters.add(new LetterVowel(0,  context.getString(R.string.a122),"سِـ",11));
        letters.add(new LetterVowel(0,  context.getString(R.string.a123),"سُـ",11));
        letters.add(new LetterVowel(0,  context.getString(R.string.a124),"سْـ",11));

        letters.add(new LetterVowel(1,  context.getString(R.string.a121),"ـسَـ",11));
        letters.add(new LetterVowel(1,  context.getString(R.string.a122),"ـسِـ",11));
        letters.add(new LetterVowel(1,  context.getString(R.string.a123),"ـسُـ",11));
        letters.add(new LetterVowel(1,  context.getString(R.string.a124),"ـسْـ",11));

        letters.add(new LetterVowel(2,  context.getString(R.string.a121),"ـسَ",11));
        letters.add(new LetterVowel(2,  context.getString(R.string.a122),"ـسِ",11));
        letters.add(new LetterVowel(2,  context.getString(R.string.a123),"ـسُ",11));
        letters.add(new LetterVowel(2,  context.getString(R.string.a124),"ـسْ",11));
        //шин
        letters.add(new LetterVowel(0,  context.getString(R.string.a131),"شَـ",12));
        letters.add(new LetterVowel(0,  context.getString(R.string.a132),"شِـ",12));
        letters.add(new LetterVowel(0,  context.getString(R.string.a133),"شُـ",12));
        letters.add(new LetterVowel(0,  context.getString(R.string.a134),"شْـ",12));

        letters.add(new LetterVowel(1,   context.getString(R.string.a131),"ـشَـ",12));
        letters.add(new LetterVowel(1,   context.getString(R.string.a132),"ـشِـ",12));
        letters.add(new LetterVowel(1,   context.getString(R.string.a133),"ـشُـ",12));
        letters.add(new LetterVowel(1,   context.getString(R.string.a134),"ـشْـ",12));

        letters.add(new LetterVowel(2,   context.getString(R.string.a131),"ـشَ",12));
        letters.add(new LetterVowel(2,   context.getString(R.string.a132),"ـشِ",12));
        letters.add(new LetterVowel(2,   context.getString(R.string.a133),"ـشُ",12));
        letters.add(new LetterVowel(2,   context.getString(R.string.a134),"ـشْ",12));

        //cod
        letters.add(new LetterVowel(0,  context.getString(R.string.a141),"صَـ",13));
        letters.add(new LetterVowel(0,  context.getString(R.string.a142),"صِـ",13));
        letters.add(new LetterVowel(0,  context.getString(R.string.a143),"صُـ",13));
        letters.add(new LetterVowel(0,  context.getString(R.string.a144),"صْـ",13));

        letters.add(new LetterVowel(1,  context.getString(R.string.a141),"ـصَـ",13));
        letters.add(new LetterVowel(1,  context.getString(R.string.a142),"ـصِـ",13));
        letters.add(new LetterVowel(1,  context.getString(R.string.a143),"ـصُـ",13));
        letters.add(new LetterVowel(1,  context.getString(R.string.a144),"ـصْـ",13));

        letters.add(new LetterVowel(2,  context.getString(R.string.a141),"ـصَ",13));
        letters.add(new LetterVowel(2,  context.getString(R.string.a142),"ـصِ",13));
        letters.add(new LetterVowel(2,  context.getString(R.string.a143),"ـصُ",13));
        letters.add(new LetterVowel(2,  context.getString(R.string.a144),"ـصْ",13));
        //dod

        letters.add(new LetterVowel(0,  context.getString(R.string.a151),"ضَـ",14));
        letters.add(new LetterVowel(0,  context.getString(R.string.a152),"ضِـ",14));
        letters.add(new LetterVowel(0,  context.getString(R.string.a153),"ضُـ",14));
        letters.add(new LetterVowel(0,  context.getString(R.string.a154),"ضْـ",14));

        letters.add(new LetterVowel(1,context.getString(R.string.a151),"ـضَـ",14));
        letters.add(new LetterVowel(1,context.getString(R.string.a152),"ـضِـ",14));
        letters.add(new LetterVowel(1,context.getString(R.string.a153),"ـضُـ",14));
        letters.add(new LetterVowel(1,context.getString(R.string.a154),"ـضْـ",14));

        letters.add(new LetterVowel(2, context.getString(R.string.a151),"ـضَ",14));
        letters.add(new LetterVowel(2, context.getString(R.string.a152),"ـضِ",14));
        letters.add(new LetterVowel(2, context.getString(R.string.a153),"ـضُ",14));
        letters.add(new LetterVowel(2, context.getString(R.string.a154),"ـضْ",14));
        //То

        letters.add(new LetterVowel(0, context.getString(R.string.a161),"طَـ",15));
        letters.add(new LetterVowel(0, context.getString(R.string.a162),"طِـ",15));
        letters.add(new LetterVowel(0, context.getString(R.string.a163),"طُـ",15));
        letters.add(new LetterVowel(0, context.getString(R.string.a164),"طْـ",15));

        letters.add(new LetterVowel(1,  context.getString(R.string.a161),"ـطَـ",15));
        letters.add(new LetterVowel(1,  context.getString(R.string.a162),"ـطِـ",15));
        letters.add(new LetterVowel(1,  context.getString(R.string.a163),"ـطُـ",15));
        letters.add(new LetterVowel(1,  context.getString(R.string.a164),"ـطْـ",15));

        letters.add(new LetterVowel(2,  context.getString(R.string.a161),"ـطَ",15));
        letters.add(new LetterVowel(2,  context.getString(R.string.a162),"ـطِ",15));
        letters.add(new LetterVowel(2,  context.getString(R.string.a163),"ـطُ",15));
        letters.add(new LetterVowel(2,  context.getString(R.string.a164),"ـطْ",15));

        //Зо
        letters.add(new LetterVowel(0, context.getString(R.string.a171),"ظَـ",16));
        letters.add(new LetterVowel(0, context.getString(R.string.a172),"ظِـ",16));
        letters.add(new LetterVowel(0, context.getString(R.string.a173),"ظُـ",16));
        letters.add(new LetterVowel(0, context.getString(R.string.a174),"ظْـ",16));

        letters.add(new LetterVowel(1, context.getString(R.string.a171),"ـظَـ",16));
        letters.add(new LetterVowel(1, context.getString(R.string.a172),"ـظِـ",16));
        letters.add(new LetterVowel(1, context.getString(R.string.a173),"ـظُـ",16));
        letters.add(new LetterVowel(1, context.getString(R.string.a174),"ـظْـ",16));

        letters.add(new LetterVowel(2, context.getString(R.string.a171),"ـظَ",16));
        letters.add(new LetterVowel(2, context.getString(R.string.a172),"ـظِ",16));
        letters.add(new LetterVowel(2, context.getString(R.string.a173),"ـظُ",16));
        letters.add(new LetterVowel(2, context.getString(R.string.a174),"ـظْ",16));

        //Ъайн
        letters.add(new LetterVowel(0, context.getString(R.string.a181),"عَـ",17));
        letters.add(new LetterVowel(0, context.getString(R.string.a182),"عِـ",17));
        letters.add(new LetterVowel(0, context.getString(R.string.a183),"عُـ",17));
        letters.add(new LetterVowel(0, context.getString(R.string.a184),"عْـ",17));

        letters.add(new LetterVowel(1,  context.getString(R.string.a181),"ـعَـ",17));
        letters.add(new LetterVowel(1,  context.getString(R.string.a182),"ـعِـ",17));
        letters.add(new LetterVowel(1,  context.getString(R.string.a183),"ـعُـ",17));
        letters.add(new LetterVowel(1,  context.getString(R.string.a184),"ـعْـ",17));

        letters.add(new LetterVowel(2,  context.getString(R.string.a181),"ـعَ",17));
        letters.add(new LetterVowel(2,  context.getString(R.string.a182),"ـعِ",17));
        letters.add(new LetterVowel(2,  context.getString(R.string.a183),"ـعُ",17));
        letters.add(new LetterVowel(2,  context.getString(R.string.a184),"ـعْ",17));
        //гъайн
        letters.add(new LetterVowel(0,  context.getString(R.string.a191),"غَـ",18));
        letters.add(new LetterVowel(0,  context.getString(R.string.a192),"غِـ",18));
        letters.add(new LetterVowel(0,  context.getString(R.string.a193),"غُـ",18));
        letters.add(new LetterVowel(0,  context.getString(R.string.a194) ,"غْـ",18));

        letters.add(new LetterVowel(1,  context.getString(R.string.a191),"ـغَـ",18));
        letters.add(new LetterVowel(1,  context.getString(R.string.a192),"ـغِـ",18));
        letters.add(new LetterVowel(1,  context.getString(R.string.a193),"ـغُـ",18));
        letters.add(new LetterVowel(1,  context.getString(R.string.a194),"ـغْـ",18));

        letters.add(new LetterVowel(2,  context.getString(R.string.a191),"ـغَ",18));
        letters.add(new LetterVowel(2,  context.getString(R.string.a192),"ـغِ",18));
        letters.add(new LetterVowel(2,  context.getString(R.string.a193),"ـغُ",18));
        letters.add(new LetterVowel(2,  context.getString(R.string.a194),"ـغْ",18));
//Фа
        letters.add(new LetterVowel(0,  context.getString(R.string.a201),"فَـ",19));
        letters.add(new LetterVowel(0,  context.getString(R.string.a202),"فِـ",19));
        letters.add(new LetterVowel(0,  context.getString(R.string.a203),"فُـ",19));
        letters.add(new LetterVowel(0,  context.getString(R.string.a204),"فْـ",19));

        letters.add(new LetterVowel(1, context.getString(R.string.a201),"ـفَـ",19));
        letters.add(new LetterVowel(1, context.getString(R.string.a202),"ـفِـ",19));
        letters.add(new LetterVowel(1, context.getString(R.string.a203),"ـفُـ",19));
        letters.add(new LetterVowel(1, context.getString(R.string.a204),"ـفْـ",19));

        letters.add(new LetterVowel(2, context.getString(R.string.a201),"ـفَ",19));
        letters.add(new LetterVowel(2, context.getString(R.string.a202),"ـفِ",19));
        letters.add(new LetterVowel(2, context.getString(R.string.a203),"ـفُ",19));
        letters.add(new LetterVowel(2, context.getString(R.string.a204),"ـفْ",19));
        //коф
        letters.add(new LetterVowel(0,  context.getString(R.string.a211),"قَـ",20));
        letters.add(new LetterVowel(0,  context.getString(R.string.a212),"قِـ",20));
        letters.add(new LetterVowel(0,  context.getString(R.string.a213),"قُـ",20));
        letters.add(new LetterVowel(0,  context.getString(R.string.a214),"قْـ",20));

        letters.add(new LetterVowel(1, context.getString(R.string.a211),"ـقَـ",20));
        letters.add(new LetterVowel(1, context.getString(R.string.a212),"ـقِـ",20));
        letters.add(new LetterVowel(1, context.getString(R.string.a213),"ـقُـ",20));
        letters.add(new LetterVowel(1, context.getString(R.string.a214),"ـقْـ",20));

        letters.add(new LetterVowel(2, context.getString(R.string.a211),"ـقَ",20));
        letters.add(new LetterVowel(2, context.getString(R.string.a212),"ـقِ",20));
        letters.add(new LetterVowel(2, context.getString(R.string.a213),"ـقُ",20));
        letters.add(new LetterVowel(2, context.getString(R.string.a214),"ـقْ",20));
        //каф
        letters.add(new LetterVowel(0, context.getString(R.string.a221),"كَـ",21));
        letters.add(new LetterVowel(0, context.getString(R.string.a222),"كِـ",21));
        letters.add(new LetterVowel(0, context.getString(R.string.a223),"كُـ",21));
        letters.add(new LetterVowel(0, context.getString(R.string.a224),"كْـ",21));

        letters.add(new LetterVowel(1,  context.getString(R.string.a221),"ـكَـ",21));
        letters.add(new LetterVowel(1,  context.getString(R.string.a222),"ـكِـ",21));
        letters.add(new LetterVowel(1,  context.getString(R.string.a223),"ـكُـ",21));
        letters.add(new LetterVowel(1,  context.getString(R.string.a224),"ـكْـ",21));

        letters.add(new LetterVowel(2,  context.getString(R.string.a221),"ـكَ",21));
        letters.add(new LetterVowel(2,  context.getString(R.string.a222),"ـكِ",21));
        letters.add(new LetterVowel(2,  context.getString(R.string.a223),"ـكُ",21));
        letters.add(new LetterVowel(2,  context.getString(R.string.a224),"ـكْ",21));

        // лям
        letters.add(new LetterVowel(0,  context.getString(R.string.a231),"لَـ",22));
        letters.add(new LetterVowel(0,  context.getString(R.string.a232),"لِـ",22));
        letters.add(new LetterVowel(0,  context.getString(R.string.a233),"لُـ",22));
        letters.add(new LetterVowel(0,  context.getString(R.string.a234),"لْـ",22));

        letters.add(new LetterVowel(1,  context.getString(R.string.a231),"ـلَـ",22));
        letters.add(new LetterVowel(1,  context.getString(R.string.a232),"ـلِـ",22));
        letters.add(new LetterVowel(1,  context.getString(R.string.a233),"ـلُـ",22));
        letters.add(new LetterVowel(1,  context.getString(R.string.a234),"ـلْـ",22));

        letters.add(new LetterVowel(2,  context.getString(R.string.a231),"ـلَ",22));
        letters.add(new LetterVowel(2,  context.getString(R.string.a232),"ـلِ",22));
        letters.add(new LetterVowel(2,  context.getString(R.string.a233),"ـلُ",22));
        letters.add(new LetterVowel(2,  context.getString(R.string.a234),"ـلْ",22));

        //мим
        letters.add(new LetterVowel(0,  context.getString(R.string.a241),"مَـ",23));
        letters.add(new LetterVowel(0,  context.getString(R.string.a242),"مِـ",23));
        letters.add(new LetterVowel(0,  context.getString(R.string.a243),"مُـ",23));
        letters.add(new LetterVowel(0,  context.getString(R.string.a244),"مْـ",23));

        letters.add(new LetterVowel(1, context.getString(R.string.a241),"ـمَـ",23));
        letters.add(new LetterVowel(1, context.getString(R.string.a242),"ـمِـ",23));
        letters.add(new LetterVowel(1, context.getString(R.string.a243),"ـمُـ",23));
        letters.add(new LetterVowel(1, context.getString(R.string.a244),"ـمْـ",23));

        letters.add(new LetterVowel(2,context.getString(R.string.a241),"ـمَ",23));
        letters.add(new LetterVowel(2,context.getString(R.string.a242),"ـمِ",23));
        letters.add(new LetterVowel(2,context.getString(R.string.a243),"ـمُ",23));
        letters.add(new LetterVowel(2,context.getString(R.string.a244),"ـمْ",23));

        //нун
        letters.add(new LetterVowel(0, context.getString(R.string.a251),"نَـ",24));
        letters.add(new LetterVowel(0, context.getString(R.string.a252),"نِـ",24));
        letters.add(new LetterVowel(0, context.getString(R.string.a253),"نُـ",24));
        letters.add(new LetterVowel(0, context.getString(R.string.a254),"نْـ",24));

        letters.add(new LetterVowel(1,  context.getString(R.string.a251),"ـنَـ",24));
        letters.add(new LetterVowel(1,  context.getString(R.string.a252),"ـنِـ",24));
        letters.add(new LetterVowel(1,  context.getString(R.string.a253),"ـنُـ",24));
        letters.add(new LetterVowel(1,  context.getString(R.string.a254),"ـنْـ",24));

        letters.add(new LetterVowel(2, context.getString(R.string.a251),"ـنَ",24));
        letters.add(new LetterVowel(2, context.getString(R.string.a252),"ـنِ",24));
        letters.add(new LetterVowel(2, context.getString(R.string.a253),"ـنُ",24));
        letters.add(new LetterVowel(2, context.getString(R.string.a254),"ـنْ",24));

        //ha
        letters.add(new LetterVowel(0,  context.getString(R.string.a261),"هَـ",25));
        letters.add(new LetterVowel(0,  context.getString(R.string.a262),"هِـ",25));
        letters.add(new LetterVowel(0,  context.getString(R.string.a263),"هُـ",25));
        letters.add(new LetterVowel(0,  context.getString(R.string.a264),"هْـ",25));

        letters.add(new LetterVowel(1,  context.getString(R.string.a261),"ـهَـ",25));
        letters.add(new LetterVowel(1,  context.getString(R.string.a262),"ـهِـ",25));
        letters.add(new LetterVowel(1,  context.getString(R.string.a263),"ـهُـ",25));
        letters.add(new LetterVowel(1,  context.getString(R.string.a264),"ـهْـ",25));

        letters.add(new LetterVowel(2,  context.getString(R.string.a261),"ـهَ",25));
        letters.add(new LetterVowel(2,  context.getString(R.string.a262),"ـهِ",25));
        letters.add(new LetterVowel(2,  context.getString(R.string.a263),"ـهُ",25));
        letters.add(new LetterVowel(2,  context.getString(R.string.a264),"ـهْ",25));

        //waw
        letters.add(new LetterVowel(0,  context.getString(R.string.a271),"وَ",26));
        letters.add(new LetterVowel(0,  context.getString(R.string.a272),"وِ",26));
        letters.add(new LetterVowel(0,  context.getString(R.string.a273),"وُ",26));
        letters.add(new LetterVowel(0,  context.getString(R.string.a274),"وْ",26));

        letters.add(new LetterVowel(1,  context.getString(R.string.a271),"ـوَ",26));
        letters.add(new LetterVowel(1,  context.getString(R.string.a272),"ـوِ",26));
        letters.add(new LetterVowel(1,  context.getString(R.string.a273),"ـوُ",26));
        letters.add(new LetterVowel(1,  context.getString(R.string.a274),"ـوْ",26));

        letters.add(new LetterVowel(2,  context.getString(R.string.a271),"ـوَ",26));
        letters.add(new LetterVowel(2,  context.getString(R.string.a272),"ـوِ",26));
        letters.add(new LetterVowel(2,  context.getString(R.string.a273),"ـوُ",26));
        letters.add(new LetterVowel(2,  context.getString(R.string.a274),"ـوْ",26));

        //ya
        letters.add(new LetterVowel(0,  context.getString(R.string.a281),"يَـ",27));
        letters.add(new LetterVowel(0,  context.getString(R.string.a282),"يِـ",27));
        letters.add(new LetterVowel(0,  context.getString(R.string.a283),"يُـ",27));
        letters.add(new LetterVowel(0,  context.getString(R.string.a284),"يْـ",27));

        letters.add(new LetterVowel(1,  context.getString(R.string.a281),"ـيَـ",27));
        letters.add(new LetterVowel(1,  context.getString(R.string.a282),"ـيِـ",27));
        letters.add(new LetterVowel(1,  context.getString(R.string.a283),"ـيُـ",27));
        letters.add(new LetterVowel(1,  context.getString(R.string.a284),"ـيْـ",27));

        letters.add(new LetterVowel(2,  context.getString(R.string.a281),"ـيَ",27));
        letters.add(new LetterVowel(2,  context.getString(R.string.a282),"ـيِ",27));
        letters.add(new LetterVowel(2,  context.getString(R.string.a283),"ـيُ",27));
        letters.add(new LetterVowel(2,  context.getString(R.string.a284),"ـيْ",27));

               //   َ    ِ     ُ   ْ   asd


        return letters;
    }
}
