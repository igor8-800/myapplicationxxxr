package com.example.myapplicationxxxr.diary

import android.provider.BaseColumns

object MyDBNameClass {
    const val TABLE_NAME = "my_table"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_CONTENT = "content"
    const val COLUMN_NAME_DATE = "date"
    const val COLUMN_NAME_TIME = "time"
    const val COLUMN_NAME_COLOR = "color"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyLessonDb.db"

    const val CREAT_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_NAME_TITLE TEXT,$COLUMN_NAME_CONTENT TEXT," +
            "$COLUMN_NAME_DATE TEXT,$COLUMN_NAME_TIME TEXT,$COLUMN_NAME_COLOR TEXT)"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}