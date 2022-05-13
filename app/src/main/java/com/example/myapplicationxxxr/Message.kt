package com.example.myapplicationxxxr

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.example.myapplicationxxxr.databinding.ActivityMessageBinding
import com.example.myapplicationxxxr.diary.MainActivity_diary
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.notes.MainActivity_notes
import com.example.myapplicationxxxr.notes.ui.MyDbManager1
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1
import com.example.myapplicationxxxr.setting.setting



class Message : AppCompatActivity() {
    private lateinit var  binding: ActivityMessageBinding

    private var launcher: ActivityResultLauncher<Intent>? = null

    val myDbManagerNotes = MyDbManager1(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference: SharedPreference = SharedPreference(this)

        // настройки
        if(  sharedPreference.getValueInt("number") == 1) {
            if (sharedPreference.getValueInt("size") != 0) {
                sizeText(sharedPreference.getValueInt("size").toFloat())
            }
            if (sharedPreference.getValueInt("bagrauntMenuButton") != 0) {
                bagrauntMenuButton(sharedPreference.getValueInt("bagrauntMenuButton"))
            }
            if (sharedPreference.getValueInt("backgronteFon") != 0) {
                backgronteFon(sharedPreference.getValueInt("backgronteFon"))
            }
            if (sharedPreference.getValueInt("Themes") != 0) {
                ThemesSet(sharedPreference.getValueInt("Themes"))
            }else{
                ThemesSet(2)
            }
        }else{
            val sharedPreference: SharedPreference = SharedPreference(this)
            if (sharedPreference.getValueInt("Themes") != 0) {
                ThemesSet(sharedPreference.getValueInt("Themes"))
            }else{
                ThemesSet(2)
            }
            if (sharedPreference.getValueInt("size") != 0) {
                sizeText(sharedPreference.getValueInt("size").toFloat())
            }
            if (sharedPreference.getValueInt("bagrauntMenuButton") != 0){
                bagrauntMenuButton(sharedPreference.getValueInt("bagrauntMenuButton"))
            }
            if (sharedPreference.getValueInt("backgronteFon") != 0){
                backgronteFon(sharedPreference.getValueInt("backgronteFon"))
            }

        }

        // отправка на почту
        binding.button3.setOnClickListener {
            var var1 = binding.TitleMessage.text.toString().trim()
            var var2 = binding.TextMessage.text.toString().trim()
            var var3 = binding.mailMessage.text.toString().trim()
//            sendEmail(var1,var2,var3)


            val intent = Intent(Intent.ACTION_SENDTO) // it's not ACTION_SEND

            intent.putExtra(Intent.EXTRA_SUBJECT, var1)
            intent.putExtra(Intent.EXTRA_TEXT, var2+var3)
            intent.data = Uri.parse("mailto:mumryaef@yandex.ru") // or just "mailto:" for blank

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // this will make such that when user returns to your app, your app is displayed, instead of the email app.

            startActivity(intent)


        }





        //Навигация в меню
        binding.byrgerMain.setOnClickListener {
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        val sharedPreference: SharedPreference = SharedPreference(this)
    }

    // настройка размера текста
    fun sizeText (size:Float){
        val sharedPreference: SharedPreference = SharedPreference(this)
        binding.textView8.textSize = size
        binding.textView10.textSize = size
        binding.textView11.textSize = size
        binding.button3.textSize = size
        binding.TitleMessage.textSize = size
        binding.TextMessage.textSize = size
        binding.mailMessage.textSize = size
        binding.infoProtect.textSize = size
    }

    // настройка цвета меню и кнопок
    fun bagrauntMenuButton (int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.def.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }

    // настройка фона
    fun backgronteFon(int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.message.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }

    // настройка тем
    fun ThemesSet(int: Int){
        val color = Themes()
        val menuSet = color.menuSet(int)
        val fontSet = color.fontSet(int)
        val inputSet = color.inputSet(int)
        val notesSet = color.notesSet(int)
        val popapSet = color.popapSet(int)
        val textSet1 = color.textSet1(int)
        val textSet2 = color.textSet2(int)

        getWindow().setStatusBarColor(ContextCompat.getColor(this,menuSet))
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,menuSet))

        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.def.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.button3.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))

        binding.message.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),fontSet))

        binding.TitleMessage.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),inputSet))
        binding.TextMessage.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),inputSet))
        binding.mailMessage.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),inputSet))


        binding.textView8.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView10.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView11.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.button3.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

        binding.TitleMessage.setHintTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.TextMessage.setHintTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.mailMessage.setHintTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

        binding.TitleMessage.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.TextMessage.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.mailMessage.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.TitleMassege.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.infoProtect.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
    }


}