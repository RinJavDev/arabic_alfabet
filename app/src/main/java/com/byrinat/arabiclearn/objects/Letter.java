package com.byrinat.arabiclearn.objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Letter  {
    @PrimaryKey //(autoGenerate = true)
    public int id;

    public Letter() {
    }

    public Letter(int id,String russian_name, String end_position, String mid_position, String start_position, String name, boolean enable) {
        this.name = name;
        this.id=id;
        this.start_position = start_position;
        this.mid_position = mid_position;
        this.end_position = end_position;
        this.russian_name = russian_name;
        this.enable = enable;
    }
public String getRandomNameFromPosition(){
    int randPosition= (int) (Math.random()*3);
    switch (randPosition){
        case 0: return name;
        case 1: return start_position;
        case 2: return mid_position;
        case 3: return end_position;
    }
    return name;
}
    @ColumnInfo(name = "letter_name")
    public String name;

    @ColumnInfo(name = "start_position")
    public String start_position;
    @ColumnInfo(name = "mid_position")
    public String mid_position;

    @ColumnInfo(name = "end_position")
    public String end_position;

    @ColumnInfo(name = "russian_name")
    public String russian_name;

    @ColumnInfo(name = "enable")
    public boolean enable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}