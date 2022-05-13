package com.example.myapplicationxxxr.setting.sitingActivAll

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplicationxxxr.R
import com.example.myapplicationxxxr.databinding.ActivityTextSizeBinding
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1
import java.io.IOException

class TextSize : AppCompatActivity() {
    private lateinit var  binding: ActivityTextSizeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextSizeBinding.inflate(layoutInflater)
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

        binding.less.setOnClickListener {sizeCriate( 12.toFloat(), 12);}
        binding.little.setOnClickListener {sizeCriate( 14.toFloat(), 14);}
        binding.standard.setOnClickListener { sizeCriate( 16.toFloat(), 16);}
        binding.big.setOnClickListener {sizeCriate( 18.toFloat(), 18);}
        binding.more.setOnClickListener { sizeCriate( 20.toFloat(), 20);}

        binding.byrgerbook.setOnClickListener {
            finish()
        }


    }

    //размер текста
    fun sizeCriate (size:Float, int: Int){
        binding.textSizeSetting1.textSize = size
        binding.textSizeSetting2.textSize = size
        binding.textSizeSetting3.textSize = size
        binding.textSizeSetting4.textSize = size
        binding.textSizeSetting5.textSize = size
        binding.less.textSize = size
        binding.little.textSize = size
        binding.standard.textSize = size
        binding.big.textSize = size
        binding.more.textSize = size
        binding.titleByrgerSize.textSize = size
        binding.infoProtect.textSize = size
        val sharedPreference: SharedPreference = SharedPreference(this)
            sharedPreference.save("size", int)
    }
    fun sizeText (size:Float){
        binding.textSizeSetting1.textSize = size
        binding.textSizeSetting2.textSize = size
        binding.textSizeSetting3.textSize = size
        binding.textSizeSetting4.textSize = size - 2
        binding.textSizeSetting5.textSize = size
        binding.less.textSize = size
        binding.little.textSize = size
        binding.standard.textSize = size
        binding.big.textSize = size
        binding.more.textSize = size
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

        binding.less.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.little.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.standard.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.big.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.more.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))


        binding.fon.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),fontSet))
        binding.fonTest.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),fontSet))
        binding.corpus.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),notesSet))

        binding.textSizeSetting1.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.textSizeSetting2.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.textSizeSetting3.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textSizeSetting4.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.textSizeSetting5.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))

        binding.titleByrgerSize.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))

        binding.less.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.little.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.standard.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.big.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.more.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.infoProtect.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

        binding.shodylSet.setBackgroundResource(shodylSet)
        binding.shodylSet1.setBackgroundResource(shodylSet)
        binding.shodylSet2.setBackgroundResource(shodylSet)
        binding.shodylSet3.setBackgroundResource(shodylSet)
        binding.shodylSet4.setBackgroundResource(shodylSet)

    }
}