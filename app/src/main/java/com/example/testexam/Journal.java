package com.example.testexam;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "journal_table")
public class Journal {


    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "_id")
    private   int _id;


    @ColumnInfo(name = "date")
    private String date;


    @ColumnInfo(name = "Journal")
    private String Journal;

    public Journal() {
    }

    public Journal(String date, String journal) {
        this.date = date;
        this.Journal = journal;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJournal() {
        return Journal;
    }

    public void setJournal(String journal) {
        Journal = journal;
    }
}


