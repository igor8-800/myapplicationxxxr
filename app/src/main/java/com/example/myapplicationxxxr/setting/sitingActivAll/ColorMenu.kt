package com.example.myapplicationxxxr.setting.sitingActivAll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.myapplicationxxxr.R
import com.example.myapplicationxxxr.databinding.ActivityColorMenuBinding
import com.example.myapplicationxxxr.databinding.ActivitySettingBinding
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1

class ColorMenu : AppCompatActivity() {
    private lateinit var  binding: ActivityColorMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorMenuBinding.inflate(layoutInflater)
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

        binding.setting0.setOnClickListener {colorCreate(0); bagrauntMenuButton(0);number(0)}
        binding.setting1.setOnClickListener {colorCreate(1); bagrauntMenuButton(1);number(0)}
        binding.setting2.setOnClickListener {colorCreate(2); bagrauntMenuButton(2);number(0)}
        binding.setting3.setOnClickListener {colorCreate(3); bagrauntMenuButton(3);number(0)}
        binding.setting4.setOnClickListener {colorCreate(4); bagrauntMenuButton(4);number(0)}
        binding.setting5.setOnClickListener {colorCreate(5); bagrauntMenuButton(5);number(0)}
        binding.setting6.setOnClickListener {colorCreate(6); bagrauntMenuButton(6);number(0)}
        binding.setting7.setOnClickListener {colorCreate(7); bagrauntMenuButton(7);number(0)}
        binding.setting8.setOnClickListener {colorCreate(8); bagrauntMenuButton(8);number(0)}
        binding.setting9.setOnClickListener {colorCreate(9); bagrauntMenuButton(9);number(0)}
        binding.setting10.setOnClickListener {colorCreate(10); bagrauntMenuButton(10);number(0)}
        binding.setting11.setOnClickListener {colorCreate(11); bagrauntMenuButton(11);number(0)}
        binding.setting12.setOnClickListener {colorCreate(12); bagrauntMenuButton(12);number(0)}
        binding.setting13.setOnClickListener {colorCreate(13); bagrauntMenuButton(13);number(0)}
        binding.setting14.setOnClickListener {colorCreate(14); bagrauntMenuButton(14);number(0)}
        binding.setting15.setOnClickListener {colorCreate(15); bagrauntMenuButton(15);number(0)}
        binding.setting16.setOnClickListener {colorCreate(16); bagrauntMenuButton(16);number(0)}
        binding.setting17.setOnClickListener {colorCreate(17); bagrauntMenuButton(17);number(0)}
        binding.setting18.setOnClickListener {colorCreate(18); bagrauntMenuButton(18);number(0)}
        binding.setting19.setOnClickListener {colorCreate(19); bagrauntMenuButton(19);number(0)}
        binding.setting20.setOnClickListener {colorCreate(20); bagrauntMenuButton(20);number(0)}
        binding.setting21.setOnClickListener {colorCreate(21); bagrauntMenuButton(21);number(0)}
        binding.setting22.setOnClickListener {colorCreate(22); bagrauntMenuButton(22);number(0)}
        binding.setting23.setOnClickListener {colorCreate(23); bagrauntMenuButton(23);number(0)}
        binding.setting24.setOnClickListener {colorCreate(24); bagrauntMenuButton(24);number(0)}
        binding.setting25.setOnClickListener {colorCreate(25); bagrauntMenuButton(25);number(0)}

        binding.setting26.setOnClickListener {colorCreate(26); bagrauntMenuButton(26);number(0)}
        binding.setting27.setOnClickListener {colorCreate(27); bagrauntMenuButton(27);number(0)}
        binding.setting28.setOnClickListener {colorCreate(28); bagrauntMenuButton(28);number(0)}
        binding.setting29.setOnClickListener {colorCreate(29); bagrauntMenuButton(29);number(0)}
        binding.setting30.setOnClickListener {colorCreate(30); bagrauntMenuButton(30);number(0)}
        binding.setting31.setOnClickListener {colorCreate(31); bagrauntMenuButton(31);number(0)}
        binding.setting32.setOnClickListener {colorCreate(32); bagrauntMenuButton(32);number(0)}
        binding.setting33.setOnClickListener {colorCreate(33); bagrauntMenuButton(33);number(0)}
        binding.setting34.setOnClickListener {colorCreate(34); bagrauntMenuButton(34);number(0)}
        binding.setting35.setOnClickListener {colorCreate(35); bagrauntMenuButton(35);number(0)}
        binding.setting36.setOnClickListener {colorCreate(36); bagrauntMenuButton(36);number(0)}
        binding.setting37.setOnClickListener {colorCreate(37); bagrauntMenuButton(37);number(0)}
        binding.setting38.setOnClickListener {colorCreate(38); bagrauntMenuButton(38);number(0)}
        binding.setting39.setOnClickListener {colorCreate(39); bagrauntMenuButton(39);number(0)}
        binding.setting40.setOnClickListener {colorCreate(40); bagrauntMenuButton(40);number(0)}
        binding.setting41.setOnClickListener {colorCreate(41); bagrauntMenuButton(41);number(0)}
        binding.setting42.setOnClickListener {colorCreate(42); bagrauntMenuButton(42);number(0)}
        binding.setting43.setOnClickListener {colorCreate(43); bagrauntMenuButton(43);number(0)}
        binding.setting44.setOnClickListener {colorCreate(44); bagrauntMenuButton(44);number(0)}
        binding.setting45.setOnClickListener {colorCreate(45); bagrauntMenuButton(45);number(0)}
        binding.setting46.setOnClickListener {colorCreate(46); bagrauntMenuButton(46);number(0)}
    }



    fun colorCreate (int: Int){

        val sharedPreference: SharedPreference = SharedPreference(this)
        sharedPreference.save("bagrauntMenuButton", int)
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
        binding.shodylSet2.setBackgroundResource(shodylSet)
    }
}