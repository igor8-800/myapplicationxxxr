package com.example.myapplicationxxxr.notes.ui

import android.provider.BaseColumns

object MyDBNameClass1 {



    const val DATABASE_VERSION_1 = 3
    const val DATABASE_NAME_1 = "MyLessonDb12.db"

    const val TABLE_NAME_1 = "my_table1"
    const val COLUMN_NAME_TEXT_1 = "title_1"
    const val COLUMN_NAME_RANG_1 = "rang_1"
    const val COLUMN_NAME_CHECK_1 = "check_1"

    const val CREAT_TABLE_1 = "CREATE TABLE IF NOT EXISTS $TABLE_NAME_1 (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_NAME_TEXT_1 TEXT,$COLUMN_NAME_RANG_1 TEXT,$COLUMN_NAME_CHECK_1 TEXT)"
    const val SQL_DELETE_TABLE_1 = "DROP TABLE IF EXISTS $TABLE_NAME_1"

}