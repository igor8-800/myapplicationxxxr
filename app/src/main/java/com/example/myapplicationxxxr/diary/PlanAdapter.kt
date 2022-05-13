package com.example.myapplicationxxxr.diary

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.example.myapplicationxxxr.diary.book.BookActivity
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1
import java.security.acl.LastOwnerException

class MyAdapter(listMain: ArrayList<ListItem>, contextM: Context,dbmanajer:MyDbManager): RecyclerView.Adapter<MyAdapter.MyHolder>() {

    var listArray = listMain
    var context = contextM
    var dbmanajerL = dbmanajer

    class MyHolder(view: View, contextM: Context,dbmanajer:MyDbManager): RecyclerView.ViewHolder(view) {
        val binding = LinkDiaryBinding.bind(view)
        var context = contextM
        var dbmanajerL = dbmanajer

        fun bind (item: ListItem, dbmanajer:MyDbManager) = with(binding){
            val sharedPreference: SharedPreference = SharedPreference(context)

            // показ данных
            textViewIarTitle.text = item.title
            buttonIar.text = item.date
            textView9.text = item.time

            // настройка
            if (sharedPreference.getValueInt("size") != 0) {
                textViewIarTitle.textSize = (sharedPreference.getValueInt("size") + 1).toFloat()
                buttonIar.textSize = sharedPreference.getValueInt("size").toFloat()
                textView9.textSize = (sharedPreference.getValueInt("size") - 2).toFloat()
            }

            // настройка
            if (sharedPreference.getValueInt("colorText") != 0){
                val color = TextColor1()
                val textColor = color.colorTextFun(sharedPreference.getValueInt("colorText"))
                textViewIarTitle.setTextColor(ContextCompat.getColor(context, textColor.toInt()))
            }

            // фон заметки
            when(item.color){
                "#9E9595" ->  corpus.setBackgroundResource(R.drawable.link_diary)
                "#B5AC5B" ->  corpus.setBackgroundResource(R.drawable.link_diary_1)
                "#89D46B" ->  corpus.setBackgroundResource(R.drawable.link_diary_2)
                "#2F322E" ->  corpus.setBackgroundResource(R.drawable.link_diary_3)
                "#476A39" ->  corpus.setBackgroundResource(R.drawable.link_diary_4)
                "#ff00ff" ->  corpus.setBackgroundResource(R.drawable.link_diary_5)
                "#fe0002" ->  corpus.setBackgroundResource(R.drawable.link_diary_6)
                "#ff6600" ->  corpus.setBackgroundResource(R.drawable.link_diary_7)
                "#01ffff" ->  corpus.setBackgroundResource(R.drawable.link_diary_8)
                "#020181" ->  corpus.setBackgroundResource(R.drawable.link_diary_9)
                "#610163" ->  corpus.setBackgroundResource(R.drawable.link_diary_10)
                "#993302" ->  corpus.setBackgroundResource(R.drawable.link_diary_11)
            }


            //клик, передача данных
            corpus.setOnClickListener{
                val intent = Intent(context, BookActivity::class.java).apply {

                    putExtra(MyIntentConstants.I_TITLE_KEY, item.title)
                    putExtra(MyIntentConstants.I_CONTENT_KEY, item.text)
                    putExtra(MyIntentConstants.I_COLOR_KEY, item.color)
                    putExtra(MyIntentConstants.I_ID_KEY, item.id)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.link_diary, parent, false)
        return MyHolder(view, context,dbmanajerL)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(listArray[position],dbmanajerL)
    }

    override fun getItemCount(): Int {
        return listArray.size
    }
    // обновление
    fun obdat () {
        notifyDataSetChanged()
    }

    // добавление
    fun  addPlant(linkDiary: List<ListItem>){
        listArray.clear()
        listArray.addAll(linkDiary.sortedByDescending { it.id })
        notifyDataSetChanged()
    }
    //удаление
    fun  removePlant(index:Int, dbmanajer:MyDbManager){
        dbmanajer.removeItemFromDB(listArray[index].id.toString())
        listArray.removeAt(index)
        notifyItemChanged(0,listArray.size)
        notifyItemRemoved(index)
    }

}