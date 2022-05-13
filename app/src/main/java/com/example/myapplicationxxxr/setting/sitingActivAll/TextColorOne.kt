package com.example.myapplicationxxxr.setting.sitingActivAll

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myapplicationxxxr.R
import com.example.myapplicationxxxr.databinding.ActivityTextColorOneBinding
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1

class TextColorOne : AppCompatActivity() {
    private lateinit var  binding: ActivityTextColorOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextColorOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference: SharedPreference = SharedPreference(this)
        if(  sharedPreference.getValueInt("number") == 1) {
            if (sharedPreference.getValueInt("size") != 0) {
                sizeText(sharedPreference.getValueInt("size").toFloat())
            }

            if (sharedPreference.getValueInt("colorText") != 0) {
                colorText(sharedPreference.getValueInt("colorText"))
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
            if (sharedPreference.getValueInt("Themes") != 0) {
                ThemesSet(sharedPreference.getValueInt("Themes"))
            }else{
                ThemesSet(2)
            }
            if (sharedPreference.getValueInt("size") != 0) {
                sizeText(sharedPreference.getValueInt("size").toFloat())
            }

            if (sharedPreference.getValueInt("colorText") != 0) {
                colorText(sharedPreference.getValueInt("colorText"))
            }
            if (sharedPreference.getValueInt("bagrauntMenuButton") != 0) {
                bagrauntMenuButton(sharedPreference.getValueInt("bagrauntMenuButton"))
            }

            if (sharedPreference.getValueInt("backgronteFon") != 0) {
                backgronteFon(sharedPreference.getValueInt("backgronteFon"))
            }
        }

        binding.setting0.setOnClickListener {textCriate(0); colorText(0);number(0)}
        binding.setting1.setOnClickListener {textCriate(1); colorText(1);number(0)}
        binding.setting2.setOnClickListener {textCriate(2); colorText(2);number(0)}
        binding.setting3.setOnClickListener {textCriate(3); colorText(3);number(0)}
        binding.setting4.setOnClickListener {textCriate(4); colorText(4);number(0)}
        binding.setting5.setOnClickListener {textCriate(5); colorText(5);number(0)}
        binding.setting6.setOnClickListener {textCriate(6); colorText(6);number(0)}
        binding.setting7.setOnClickListener {textCriate(7); colorText(7);number(0)}
        binding.setting8.setOnClickListener {textCriate(8); colorText(8);number(0)}
        binding.setting9.setOnClickListener {textCriate(9); colorText(9);number(0)}
        binding.setting10.setOnClickListener {textCriate(10); colorText(10);number(0)}
        binding.setting11.setOnClickListener {textCriate(11); colorText(11);number(0)}
        binding.setting12.setOnClickListener {textCriate(12); colorText(12);number(0)}
        binding.setting13.setOnClickListener {textCriate(13); colorText(13);number(0)}
        binding.setting14.setOnClickListener {textCriate(14); colorText(14);number(0)}
        binding.setting15.setOnClickListener {textCriate(15); colorText(15);number(0)}
        binding.setting16.setOnClickListener {textCriate(16); colorText(16);number(0)}
        binding.setting17.setOnClickListener {textCriate(17); colorText(17);number(0)}
        binding.setting18.setOnClickListener {textCriate(18); colorText(18);number(0)}
        binding.setting19.setOnClickListener {textCriate(19); colorText(19);number(0)}
        binding.setting20.setOnClickListener {textCriate(20); colorText(20);number(0)}
        binding.setting21.setOnClickListener {textCriate(21); colorText(21);number(0)}
        binding.setting22.setOnClickListener {textCriate(22); colorText(22);number(0)}
        binding.setting23.setOnClickListener {textCriate(23); colorText(23);number(0)}
        binding.setting24.setOnClickListener {textCriate(24); colorText(24);number(0)}
        binding.setting25.setOnClickListener {textCriate(25); colorText(25);number(0)}

        binding.setting26.setOnClickListener {textCriate(26); colorText(26);number(0)}
        binding.setting27.setOnClickListener {textCriate(27); colorText(27);number(0)}
        binding.setting28.setOnClickListener {textCriate(28); colorText(28);number(0)}
        binding.setting29.setOnClickListener {textCriate(29); colorText(29);number(0)}
        binding.setting30.setOnClickListener {textCriate(30); colorText(30);number(0)}
        binding.setting31.setOnClickListener {textCriate(31); colorText(31);number(0)}
        binding.setting32.setOnClickListener {textCriate(32); colorText(32);number(0)}
        binding.setting33.setOnClickListener {textCriate(33); colorText(33);number(0)}
        binding.setting34.setOnClickListener {textCriate(34); colorText(34);number(0)}
        binding.setting35.setOnClickListener {textCriate(35); colorText(35);number(0)}
        binding.setting36.setOnClickListener {textCriate(36); colorText(36);number(0)}
        binding.setting37.setOnClickListener {textCriate(37); colorText(37);number(0)}
        binding.setting38.setOnClickListener {textCriate(38); colorText(38);number(0)}
        binding.setting39.setOnClickListener {textCriate(39); colorText(39);number(0)}
        binding.setting40.setOnClickListener {textCriate(40); colorText(40);number(0)}
        binding.setting41.setOnClickListener {textCriate(41); colorText(41);number(0)}
        binding.setting42.setOnClickListener {textCriate(42); colorText(42);number(0)}
        binding.setting43.setOnClickListener {textCriate(43); colorText(43);number(0)}
        binding.setting44.setOnClickListener {textCriate(44); colorText(44);number(0)}
        binding.setting45.setOnClickListener {textCriate(45); colorText(45);number(0)}
        binding.setting46.setOnClickListener {textCriate(46); colorText(46);number(0)}


        binding.byrgerbook.setOnClickListener {
            finish()
        }


    }

    //колор текста
    fun textCriate (int: Int){

        val sharedPreference: SharedPreference = SharedPreference(this)
        sharedPreference.save("colorText", int)
    }

    fun sizeText (size:Float){
        binding.textSizeSetting1.textSize = size
        binding.textSizeSetting2.textSize = size
        binding.textSizeSetting3.textSize = size
        binding.textSizeSetting4.textSize = size - 2
        binding.textSizeSetting5.textSize = size
        binding.titleByrgerSize.textSize = size
        binding.infoProtect.textSize = size
    }

    fun colorText(int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int).toString()
     binding.textSizeSetting3.setTextColor(getResources().getColor(textColor.toInt()))
    }
    fun bagrauntMenuButton (int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.menuPackButton.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.menuPack.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }

    fun backgronteFon(int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.fonTest.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.fon.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }
    fun number(int: Int) {
        val sharedPreference: SharedPreference = SharedPreference(this)
        sharedPreference.save("number", int)
    }
    fun ThemesSet(int: Int){
        val color = Themes()
        val menuSet = color.menuSet(int)
        val fontSet = color.fontSet(int)
        val inputSet = color.inputSet(int)
        val notesSet = color.notesSet(int)
        val popapSet = color.popapSet(int)
        val textSet1 = color.textSet1(int)
        val textSet2 = color.textSet2(int)
        val shodylSet = color.shodylSet(int)

        getWindow().setStatusBarColor(ContextCompat.getColor(this, menuSet))
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,menuSet))

        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.menuPack.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.menuPackButton.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))



        binding.fon.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),fontSet))
        binding.fonTest.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),fontSet))
        binding.corpus.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),notesSet))

        binding.textSizeSetting1.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.textSizeSetting2.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.textSizeSetting3.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textSizeSetting4.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.textSizeSetting5.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))

        binding.titleByrgerSize.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.infoProtect.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

        binding.shodylSet.setBackgroundResource(shodylSet)
        binding.shodylSet2.setBackgroundResource(shodylSet)
        binding.shodylSet1.setBackgroundResource(shodylSet)
        binding.shodylSe4.setBackgroundResource(shodylSet)
    }
}