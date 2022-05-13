package com.example.myapplicationxxxr.setting.sitingActivAll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.myapplicationxxxr.R
import com.example.myapplicationxxxr.databinding.ActivityFieldColorBinding
import com.example.myapplicationxxxr.databinding.ActivitySettingBinding
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1

class FieldColor : AppCompatActivity() {
    private lateinit var  binding: ActivityFieldColorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFieldColorBinding.inflate(layoutInflater)
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
        binding.byrgerbook.setOnClickListener {
            finish()
        }

        binding.setting0.setOnClickListener {colorCreate(0); backgronteFon(0);number(0)}
        binding.setting1.setOnClickListener {colorCreate(1); backgronteFon(1);number(0)}
        binding.setting2.setOnClickListener {colorCreate(2); backgronteFon(2);number(0)}
        binding.setting3.setOnClickListener {colorCreate(3); backgronteFon(3);number(0)}
        binding.setting4.setOnClickListener {colorCreate(4); backgronteFon(4);number(0)}
        binding.setting5.setOnClickListener {colorCreate(5); backgronteFon(5);number(0)}
        binding.setting6.setOnClickListener {colorCreate(6); backgronteFon(6);number(0)}
        binding.setting7.setOnClickListener {colorCreate(7); backgronteFon(7);number(0)}
        binding.setting8.setOnClickListener {colorCreate(8); backgronteFon(8);number(0)}
        binding.setting9.setOnClickListener {colorCreate(9); backgronteFon(9);number(0)}
        binding.setting10.setOnClickListener {colorCreate(10); backgronteFon(10);number(0)}
        binding.setting11.setOnClickListener {colorCreate(11); backgronteFon(11);number(0)}
        binding.setting12.setOnClickListener {colorCreate(12); backgronteFon(12);number(0)}
        binding.setting13.setOnClickListener {colorCreate(13); backgronteFon(13);number(0)}
        binding.setting14.setOnClickListener {colorCreate(14); backgronteFon(14);number(0)}
        binding.setting15.setOnClickListener {colorCreate(15); backgronteFon(15);number(0)}
        binding.setting16.setOnClickListener {colorCreate(16); backgronteFon(16);number(0)}
        binding.setting17.setOnClickListener {colorCreate(17); backgronteFon(17);number(0)}
        binding.setting18.setOnClickListener {colorCreate(18); backgronteFon(18);number(0)}
        binding.setting19.setOnClickListener {colorCreate(19); backgronteFon(19);number(0)}
        binding.setting20.setOnClickListener {colorCreate(20); backgronteFon(20);number(0)}
        binding.setting21.setOnClickListener {colorCreate(21); backgronteFon(21);number(0)}
        binding.setting22.setOnClickListener {colorCreate(22); backgronteFon(22);number(0)}
        binding.setting23.setOnClickListener {colorCreate(23); backgronteFon(23);number(0)}
        binding.setting24.setOnClickListener {colorCreate(24); backgronteFon(24);number(0)}
        binding.setting25.setOnClickListener {colorCreate(25); backgronteFon(25);number(0)}

        binding.setting26.setOnClickListener {colorCreate(26); backgronteFon(26);number(0)}
        binding.setting27.setOnClickListener {colorCreate(27); backgronteFon(27);number(0)}
        binding.setting28.setOnClickListener {colorCreate(28); backgronteFon(28);number(0)}
        binding.setting29.setOnClickListener {colorCreate(29); backgronteFon(29);number(0)}
        binding.setting30.setOnClickListener {colorCreate(30); backgronteFon(30);number(0)}
        binding.setting31.setOnClickListener {colorCreate(31); backgronteFon(31);number(0)}
        binding.setting32.setOnClickListener {colorCreate(32); backgronteFon(32);number(0)}
        binding.setting33.setOnClickListener {colorCreate(33); backgronteFon(33);number(0)}
        binding.setting34.setOnClickListener {colorCreate(34); backgronteFon(34);number(0)}
        binding.setting35.setOnClickListener {colorCreate(35); backgronteFon(35);number(0)}
        binding.setting36.setOnClickListener {colorCreate(36); backgronteFon(36);number(0)}
        binding.setting37.setOnClickListener {colorCreate(37); backgronteFon(37);number(0)}
        binding.setting38.setOnClickListener {colorCreate(38); backgronteFon(38);number(0)}
        binding.setting39.setOnClickListener {colorCreate(39); backgronteFon(39);number(0)}
        binding.setting40.setOnClickListener {colorCreate(40); backgronteFon(40);number(0)}
        binding.setting41.setOnClickListener {colorCreate(41); backgronteFon(41);number(0)}
        binding.setting42.setOnClickListener {colorCreate(42); backgronteFon(42);number(0)}
        binding.setting43.setOnClickListener {colorCreate(43); backgronteFon(43);number(0)}
        binding.setting44.setOnClickListener {colorCreate(44); backgronteFon(44);number(0)}
        binding.setting45.setOnClickListener {colorCreate(45); backgronteFon(45);number(0)}
        binding.setting46.setOnClickListener {colorCreate(46); backgronteFon(46);number(0)}
    }



    fun colorCreate (int: Int){

        val sharedPreference: SharedPreference = SharedPreference(this)
        sharedPreference.save("backgronteFon", int)
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
        val textColor = color.colorTextFun(int)
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
        binding.shodylSet3.setBackgroundResource(shodylSet)
        binding.shodylSet1.setBackgroundResource(shodylSet)

        binding.shodylSet4.setBackgroundResource(shodylSet)
    }
}

