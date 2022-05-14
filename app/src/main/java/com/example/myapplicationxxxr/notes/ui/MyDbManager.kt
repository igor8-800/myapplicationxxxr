package com.example.myapplicationxxxr.notes.ui

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.provider.BaseColumns
//import com.example.myapplication.diary.MyDBNameClass
import com.example.myapplicationxxxr.notes.ui.ListItem1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyDbManager1 (context: Context) {
    val myDbHelper1 = MydbHelper1(context)
    var db1: SQLiteDatabase? = null

    fun openDb(){
        db1 = myDbHelper1.writableDatabase
    }

    // дабовление
    suspend fun insertToDb1 ( title: String, content: String, check: String, id:Int)= withContext(Dispatchers.IO)  {
        val selection = BaseColumns._ID + "=$id"

        val values = ContentValues().apply {
            put(MyDBNameClass1.COLUMN_NAME_TEXT_1, title)
            put(MyDBNameClass1.COLUMN_NAME_RANG_1, content)
            put(MyDBNameClass1.COLUMN_NAME_CHECK_1, check)
        }
        db1?.insert(MyDBNameClass1.TABLE_NAME_1,null, values)
    }

    // обновление
    suspend fun updateItem1( title: String, content: String, check: String, id:Int) = withContext(Dispatchers.IO)  {
        val selection = BaseColumns._ID + "=$id"
        val values = ContentValues().apply {
            put(MyDBNameClass1.COLUMN_NAME_TEXT_1, title)
            put(MyDBNameClass1.COLUMN_NAME_RANG_1, content)
            put(MyDBNameClass1.COLUMN_NAME_CHECK_1, check)

        }
        db1?.update(MyDBNameClass1.TABLE_NAME_1, values,selection,null)
    }

    //удаление
    suspend fun removeItemFromDB1(id:String) = withContext(Dispatchers.IO) {
        val selection = BaseColumns._ID + "=$id"
        db1?.delete(MyDBNameClass1.TABLE_NAME_1, selection, null)
    }

    // показ данных
    suspend fun readDbDate(searchText: String = "") : ArrayList<ListItem1> = withContext(Dispatchers.IO) {
        val dateList1 = ArrayList<ListItem1>()
        //поиск
        val selection = "${MyDBNameClass1.COLUMN_NAME_TEXT_1} like ?"

        val cursor = db1?.query(MyDBNameClass1.TABLE_NAME_1, null,
            selection, arrayOf("%$searchText%"), null, null, null)

        while (cursor?.moveToNext()!!){
            val dateText = cursor.getString(cursor.getColumnIndex(MyDBNameClass1.COLUMN_NAME_TEXT_1))
            val dateContent = cursor.getString(cursor.getColumnIndex(MyDBNameClass1.COLUMN_NAME_RANG_1))
            val dateCheck = cursor.getString(cursor.getColumnIndex(MyDBNameClass1.COLUMN_NAME_CHECK_1))
            val dateID = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))

            val item = ListItem1()
            item.text = dateText
            item.rang = dateContent
            item.check = dateCheck
            item.id = dateID
            dateList1.add(item)
        }
        cursor.close()
        return@withContext dateList1
    }

    fun  closeDb(){
        myDbHelper1.close()
    }
}
