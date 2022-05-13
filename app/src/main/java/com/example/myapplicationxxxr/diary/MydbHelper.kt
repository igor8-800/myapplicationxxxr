package com.example.myapplicationxxxr.diary

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MydbHelper(context: Context) : SQLiteOpenHelper(context, MyDBNameClass.DATABASE_NAME,
    null, MyDBNameClass.DATABASE_VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(MyDBNameClass.CREAT_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(MyDBNameClass.SQL_DELETE_TABLE)
        onCreate(p0)
    }
}
