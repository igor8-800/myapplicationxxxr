package com.example.myapplicationxxxr.setting.sitingActivAll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.myapplicationxxxr.R
import com.example.myapplicationxxxr.databinding.ActivityNotesColorBinding
import com.example.myapplicationxxxr.databinding.ActivitySettingBinding
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1

class NotesColor : AppCompatActivity() {
    private lateinit var  binding: ActivityNotesColorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesColorBinding.inflate(layoutInflater)
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
            if (sharedPreference.getValueInt("bagrauntNotes") != 0) {
                bagrauntNotes(sharedPreference.getValueInt("bagrauntNotes"))
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
            if (sharedPreference.getValueInt("bagrauntNotes") != 0) {
                bagrauntNotes(sharedPreference.getValueInt("bagrauntNotes"))
            }

            if (sharedPreference.getValueInt("backgronteFon") != 0) {
                backgronteFon(sharedPreference.getValueInt("backgronteFon"))
            }
        }

        binding.byrgerbook.setOnClickListener {
            finish()
        }

        binding.setting0.setOnClickListener {colorCreateNotes(0); bagrauntNotes(0);number(0)}
        binding.setting1.setOnClickListener {colorCreateNotes(1); bagrauntNotes(1);number(0)}
        binding.setting2.setOnClickListener {colorCreateNotes(2); bagrauntNotes(2);number(0)}
        binding.setting3.setOnClickListener {colorCreateNotes(3); bagrauntNotes(3);number(0)}
        binding.setting4.setOnClickListener {colorCreateNotes(4); bagrauntNotes(4);number(0)}
        binding.setting5.setOnClickListener {colorCreateNotes(5); bagrauntNotes(5);number(0)}
        binding.setting6.setOnClickListener {colorCreateNotes(6); bagrauntNotes(6);number(0)}
        binding.setting7.setOnClickListener {colorCreateNotes(7); bagrauntNotes(7);number(0)}
        binding.setting8.setOnClickListener {colorCreateNotes(8); bagrauntNotes(8);number(0)}
        binding.setting9.setOnClickListener {colorCreateNotes(9); bagrauntNotes(9);number(0)}
        binding.setting10.setOnClickListener {colorCreateNotes(10); bagrauntNotes(10);number(0)}
        binding.setting11.setOnClickListener {colorCreateNotes(11); bagrauntNotes(11);number(0)}
        binding.setting12.setOnClickListener {colorCreateNotes(12); bagrauntNotes(12);number(0)}
        binding.setting13.setOnClickListener {colorCreateNotes(13); bagrauntNotes(13);number(0)}
        binding.setting14.setOnClickListener {colorCreateNotes(14); bagrauntNotes(14);number(0)}
        binding.setting15.setOnClickListener {colorCreateNotes(15); bagrauntNotes(15);number(0)}
        binding.setting16.setOnClickListener {colorCreateNotes(16); bagrauntNotes(16);number(0)}
        binding.setting17.setOnClickListener {colorCreateNotes(17); bagrauntNotes(17);number(0)}
        binding.setting18.setOnClickListener {colorCreateNotes(18); bagrauntNotes(18);number(0)}
        binding.setting19.setOnClickListener {colorCreateNotes(19); bagrauntNotes(19);number(0)}
        binding.setting20.setOnClickListener {colorCreateNotes(20); bagrauntNotes(20);number(0)}
        binding.setting21.setOnClickListener {colorCreateNotes(21); bagrauntNotes(21);number(0)}
        binding.setting22.setOnClickListener {colorCreateNotes(22); bagrauntNotes(22);number(0)}
        binding.setting23.setOnClickListener {colorCreateNotes(23); bagrauntNotes(23);number(0)}
        binding.setting24.setOnClickListener {colorCreateNotes(24); bagrauntNotes(24);number(0)}
        binding.setting25.setOnClickListener {colorCreateNotes(25); bagrauntNotes(25);number(0)}

        binding.setting26.setOnClickListener {colorCreateNotes(26); bagrauntNotes(26);number(0)}
        binding.setting27.setOnClickListener {colorCreateNotes(27); bagrauntNotes(27);number(0)}
        binding.setting28.setOnClickListener {colorCreateNotes(28); bagrauntNotes(28);number(0)}
        binding.setting29.setOnClickListener {colorCreateNotes(29); bagrauntNotes(29);number(0)}
        binding.setting30.setOnClickListener {colorCreateNotes(30); bagrauntNotes(30);number(0)}
        binding.setting31.setOnClickListener {colorCreateNotes(31); bagrauntNotes(31);number(0)}
        binding.setting32.setOnClickListener {colorCreateNotes(32); bagrauntNotes(32);number(0)}
        binding.setting33.setOnClickListener {colorCreateNotes(33); bagrauntNotes(33);number(0)}
        binding.setting34.setOnClickListener {colorCreateNotes(34); bagrauntNotes(34);number(0)}
        binding.setting35.setOnClickListener {colorCreateNotes(35); bagrauntNotes(35);number(0)}
        binding.setting36.setOnClickListener {colorCreateNotes(36); bagrauntNotes(36);number(0)}
        binding.setting37.setOnClickListener {colorCreateNotes(37); bagrauntNotes(37);number(0)}
        binding.setting38.setOnClickListener {colorCreateNotes(38); bagrauntNotes(38);number(0)}
        binding.setting39.setOnClickListener {colorCreateNotes(39); bagrauntNotes(39);number(0)}
        binding.setting40.setOnClickListener {colorCreateNotes(40); bagrauntNotes(40);number(0)}
        binding.setting41.setOnClickListener {colorCreateNotes(41); bagrauntNotes(41);number(0)}
        binding.setting42.setOnClickListener {colorCreateNotes(42); bagrauntNotes(42);number(0)}
        binding.setting43.setOnClickListener {colorCreateNotes(43); bagrauntNotes(43);number(0)}
        binding.setting44.setOnClickListener {colorCreateNotes(44); bagrauntNotes(44);number(0)}
        binding.setting45.setOnClickListener {colorCreateNotes(45); bagrauntNotes(45);number(0)}
        binding.setting46.setOnClickListener {colorCreateNotes(46); bagrauntNotes(46);number(0)}

    }

    fun colorCreateNotes (int: Int){

        val sharedPreference: SharedPreference = SharedPreference(this)
        sharedPreference.save("bagrauntNotes", int)
    }


    fun sizeText (size:Float){
        binding.textSizeSetting1.textSize = size
        binding.textSizeSetting3.textSize = size
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
    fun bagrauntNotes (int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.linsony1.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
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
            binding.linsony1.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),notesSet))

            binding.textSizeSetting1.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
            binding.textSizeSetting3.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
            binding.textSizeSetting5.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))

            binding.titleByrgerSize.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
            binding.infoProtect.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

            binding.shodylSet.setBackgroundResource(shodylSet)
            binding.shodylSet2.setBackgroundResource(shodylSet)
            binding.shodylSet1.setBackgroundResource(shodylSet)
            binding.shodylSet3.setBackgroundResource(shodylSet)
        }
}