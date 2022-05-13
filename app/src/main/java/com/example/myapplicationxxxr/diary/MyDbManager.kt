package com.example.myapplicationxxxr.diary

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.provider.BaseColumns
import com.example.myapplicationxxxr.notes.ui.ListItem1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyDbManager (context: Context) {
    val myDbHelper = MydbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = myDbHelper.writableDatabase
    }
    // добавление
    suspend fun insertToDb ( title: String, content: String, date: String, time: String, color: String) {
        val values = ContentValues().apply {
            put(MyDBNameClass.COLUMN_NAME_TITLE, title)
            put(MyDBNameClass.COLUMN_NAME_CONTENT, content)
            put(MyDBNameClass.COLUMN_NAME_DATE, date)
            put(MyDBNameClass.COLUMN_NAME_TIME, time)
            put(MyDBNameClass.COLUMN_NAME_COLOR, color)
        }
        db?.insert(MyDBNameClass.TABLE_NAME,null, values)
    }

    // обновление
    suspend fun updateItem( title: String, content: String, id:Int, color: String)  {
        val selection = BaseColumns._ID + "=$id"
        val values = ContentValues().apply {
            put(MyDBNameClass.COLUMN_NAME_TITLE, title)
            put(MyDBNameClass.COLUMN_NAME_CONTENT, content)
            put(MyDBNameClass.COLUMN_NAME_COLOR, color)
        }
        db?.update(MyDBNameClass.TABLE_NAME, values,selection,null)
    }

    //удаление
    fun removeItemFromDB(id:String){
        val selection = BaseColumns._ID + "=$id"
        db?.delete(MyDBNameClass.TABLE_NAME, selection, null)
    }

    // Показ данных
    suspend fun readDbDate(searchText: String = "") : ArrayList<ListItem>  {
        val dateList = ArrayList<ListItem>()
        //поиск
        val selection = "${MyDBNameClass.COLUMN_NAME_TITLE} like ?"

        val cursor = db?.query(MyDBNameClass.TABLE_NAME, null,
            selection, arrayOf("%$searchText%"), null, null, null)

        while (cursor?.moveToNext()!!){
            val dateText = cursor.getString(cursor.getColumnIndex(MyDBNameClass.COLUMN_NAME_TITLE))
            val dateContent = cursor.getString(cursor.getColumnIndex(MyDBNameClass.COLUMN_NAME_CONTENT))
            val dateDate = cursor.getString(cursor.getColumnIndex(MyDBNameClass.COLUMN_NAME_DATE))
            val dateTime = cursor.getString(cursor.getColumnIndex(MyDBNameClass.COLUMN_NAME_TIME))
            val dateColor = cursor.getString(cursor.getColumnIndex(MyDBNameClass.COLUMN_NAME_COLOR))
            val dateID = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))

            val item = ListItem()
            item.title = dateText
            item.text = dateContent
            item.date = dateDate
            item.time = dateTime
            item.id = dateID
            item.color = dateColor
            dateList.add(item)
        }
        cursor.close()
        return dateList
    }

    fun  closeDb(){
        myDbHelper.close()
    }
}
