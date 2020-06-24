package com.byrinat.arabiclearn.objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LetterVowel {
   // @PrimaryKey(autoGenerate = true)
   @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "position")
    int position;  // 0-start,1-mid,2-end

    @ColumnInfo(name = "transcription")
    String transcription;

    @ColumnInfo(name = "letter_id")
    int letter_id;

    @ColumnInfo(name = "arabic_letter")
    String arabic_letter;




    public LetterVowel(int position, String transcription, String arabic_letter, int letter_id) {
        this.position = position;
        this.transcription = transcription;
        this.arabic_letter = arabic_letter;
        this.letter_id = letter_id;
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public String getTranscription() {
        return transcription;
    }

    public String getArabic_letter() {
        return arabic_letter;
    }

    public int getLetter_id() {
        return letter_id;
    }
}
