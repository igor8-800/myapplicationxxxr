package com.example.myapplicationxxxr.notes.ui

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Checkable
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationxxxr.R
import com.example.myapplicationxxxr.databinding.ActivityMainBinding
import com.example.myapplicationxxxr.databinding.ActivityMainDiaryBinding
import com.example.myapplicationxxxr.databinding.LinkDiaryBinding
import com.example.myapplicationxxxr.databinding.NotesonyBinding
import com.example.myapplicationxxxr.diary.MyDbManager
import com.example.myapplicationxxxr.diary.MyIntentConstants
import com.example.myapplicationxxxr.hemes.Notes
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1
import java.security.acl.LastOwnerException

class MyAdapter1(listMain: ArrayList<ListItem1>, contextM: Context, dbmanajer: MyDbManager1): RecyclerView.Adapter<MyAdapter1.MyHolder>() {

    var listArray = listMain
    var context = contextM
    var dbmanajerL = dbmanajer

    class MyHolder(view: View, contextM: Context, dbmanajer: MyDbManager1): RecyclerView.ViewHolder(view) {
        val binding = NotesonyBinding.bind(view)
        var context = contextM
        var dbmanajerL = dbmanajer

        fun bind (item: ListItem1) = with(binding){
            val sharedPreference: SharedPreference = SharedPreference(context)
// показ
            textNotes.text = item.text
            rang.text = item.rang

            //setting
            if (sharedPreference.getValueInt("size") != 0) {
                textNotes.textSize = sharedPreference.getValueInt("size").toFloat()
                rang.textSize = sharedPreference.getValueInt("size").toFloat()
            }
            if (sharedPreference.getValueInt("colorText") != 0){
                val color = TextColor1()
                val textColor = color.colorTextFun(sharedPreference.getValueInt("colorText"))
                textNotes.setTextColor(ContextCompat.getColor(context, textColor.toInt()))
            }
            if (sharedPreference.getValueInt("bagrauntNotes") != 0){
                val color = Notes()
                val textColor = color.colorTextFun(sharedPreference.getValueInt("bagrauntNotes"))
                binding.linsony.setBackgroundResource(textColor.toInt())
            }else{
                linsony.setBackgroundResource(R.drawable.noti_sony)
            }


// показ ранга
            when(item.rang){
                "1" -> rang.setBackgroundResource(R.drawable.rang_1)
                "2" -> rang.setBackgroundResource(R.drawable.rang_2)
                "3" -> rang.setBackgroundResource(R.drawable.rang_3)
                else -> rang.setBackgroundResource(R.drawable.rang_1)
            }
            // клик выбранных заметок
            when (item.check){
                "2" -> {
                    val site = checkBoxNotes.isChecked
                    if (site){
                        checkBoxNotes.toggle()
                        if (sharedPreference.getValueInt("bagrauntNotes") != 0){
                            val color = Notes()
                            val textColor = color.colorTextFun(sharedPreference.getValueInt("bagrauntNotes"))
                            linsony.setBackgroundResource(textColor.toInt())
                        }else{
                            linsony.setBackgroundResource(R.drawable.noti_sony)
                        }
                    }else{
                    }
                }
                "1" -> {
                    val site = checkBoxNotes.isChecked
                    if (site){
                    }else{
                        checkBoxNotes.toggle()
                        linsony.setBackgroundResource(R.drawable.noti_sony_ht)
                    }
                }
                else -> {}

            }
            checkBoxNotes.setOnClickListener {

                when (item.check){
                    "1" -> {
                            binding.checkBoxNotes.resources.getBoolean(R.bool.check0)
                        dbmanajerL.updateItem1(item.text,item.rang, "2", item.id)
                        item.check = "2"
                          }
                    "2" -> {
                        binding.checkBoxNotes.resources.getBoolean(R.bool.check)
                        dbmanajerL.updateItem1(item.text,item.rang, "1", item.id)
                        item.check = "1"

                    }
                }
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notesony, parent, false)
        return MyHolder(view, context, dbmanajerL)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(listArray[position])
    }

    override fun getItemCount(): Int {

        return listArray.size
    }

    // обновление
    fun obdat () {
        notifyDataSetChanged()
    }

    // добовление
    fun  addPlant(linkDiary: List<ListItem1>){
        listArray.clear()
        listArray.addAll(linkDiary.sortedByDescending { it.check })
        notifyDataSetChanged()
    }

    //удаление
    fun  removePlant(index:Int, dbmanajer: MyDbManager1){
        dbmanajer.removeItemFromDB1(listArray[index].id.toString())
        listArray.removeAt(index)
        notifyItemChanged(0,listArray.size)
        notifyItemRemoved(index)
    }

}