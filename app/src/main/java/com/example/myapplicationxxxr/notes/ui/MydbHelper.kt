package com.example.myapplicationxxxr.notes.ui

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MydbHelper1(context: Context) : SQLiteOpenHelper(context, MyDBNameClass1.DATABASE_NAME_1,
    null, MyDBNameClass1.DATABASE_VERSION_1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(MyDBNameClass1.CREAT_TABLE_1)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(MyDBNameClass1.SQL_DELETE_TABLE_1)
        onCreate(p0)
    }
}
