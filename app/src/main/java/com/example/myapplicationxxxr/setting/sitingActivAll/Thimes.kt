package com.example.myapplicationxxxr.setting.sitingActivAll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myapplicationxxxr.R
import com.example.myapplicationxxxr.databinding.ActivitySettingBinding
import com.example.myapplicationxxxr.databinding.ActivityThimesBinding
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.setting.SettingMape
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1

class Thimes : AppCompatActivity() {
    private lateinit var  binding: ActivityThimesBinding
    val settingMape = SettingMape()
    var v = 0
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThimesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference: SharedPreference = SharedPreference(this)
        if(  sharedPreference.getValueInt("number") == 1){
            if (sharedPreference.getValueInt("size") != 0) {
                sizeText(sharedPreference.getValueInt("size").toFloat())
            }

            if (sharedPreference.getValueInt("bagrauntMenuButton") != 0){
                bagrauntMenuButton(sharedPreference.getValueInt("bagrauntMenuButton"))
            }
            if (sharedPreference.getValueInt("backgronteFon") != 0){
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

            if (sharedPreference.getValueInt("bagrauntMenuButton") != 0){
                bagrauntMenuButton(sharedPreference.getValueInt("bagrauntMenuButton"))
            }
            if (sharedPreference.getValueInt("backgronteFon") != 0){
                backgronteFon(sharedPreference.getValueInt("backgronteFon"))
            }

        }

        binding.byrgerbook.setOnClickListener {
            finish()
        }

        binding.fonTest1.setOnClickListener {themesSive(1); ThemesSet(1); number(1)}
        binding.fonTest2.setOnClickListener {
                themesSive(2); ThemesSet(2); number(1)
           }
        binding.fonTest3.setOnClickListener {
            if (v == 1){
            themesSive(3); ThemesSet(3); number(1)

        }else{
                binding.vipStatusBuy.visibility = View.VISIBLE
                i += 1
        }
        }
        binding.fonTest4.setOnClickListener {
            if (v == 1){
        themesSive(4); ThemesSet(4); number(1)
    }else{
                binding.vipStatusBuy.visibility = View.VISIBLE
                i += 1
    }

        }

        binding.fonTest5.setOnClickListener {
            if (v == 1){
                themesSive(5); ThemesSet(5); number(1)
        }else{
                binding.vipStatusBuy.visibility = View.VISIBLE
                i += 1
        }
        }
        binding.fonTest6.setOnClickListener {
            if (v == 1){
            themesSive(6); ThemesSet(6); number(1)
            }else{
                binding.vipStatusBuy.visibility = View.VISIBLE
                i += 1
            }
            }
        binding.fonTest7.setOnClickListener {
            if (v == 1){
            themesSive(7); ThemesSet(7); number(1)
            }else{
                binding.vipStatusBuy.visibility = View.VISIBLE
                i += 1
            }
        }
        binding.fonTest8.setOnClickListener {
            if (v == 1){
            themesSive(8); ThemesSet(8); number(1)
            }else{
                binding.vipStatusBuy.visibility = View.VISIBLE
                i += 1
            }
        }
        binding.fonTest9.setOnClickListener {
            if (v == 1){
            themesSive(9); ThemesSet(9); number(1)
            }else{
                binding.vipStatusBuy.visibility = View.VISIBLE
                i += 1
            }
        }
        binding.fonTest10.setOnClickListener {
            if (v == 1){
            themesSive(10); ThemesSet(10); number(1)
            }else{
                binding.vipStatusBuy.visibility = View.VISIBLE
                i += 1
            }
        }

        //vip
        binding.bauyVip.setOnClickListener {
            Toast.makeText(this, R.string.vipERRORE, Toast.LENGTH_SHORT).show()

        }

        binding.cencelBuyVip.setOnClickListener {
            binding.vipStatusBuy.visibility = View.GONE
            i -= 1
        }


    }

    fun themesSive (int: Int){

        val sharedPreference: SharedPreference = SharedPreference(this)
        sharedPreference.save("Themes", int)
    }

    //textSize
    fun sizeText (size:Float){
//        binding.thimText1.textSize = size
//        binding.thimText2.textSize = size
//        binding.thimText3.textSize = size
//        binding.thimText4.textSize = size
        binding.titleBurgerThimse.textSize = size

    }
    fun bagrauntMenuButton (int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }

    fun backgronteFon(int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.fon.setBackgroundResource(textColor.toInt())
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
        binding.fon.setBackgroundResource(fontSet)
//        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),inputSet))
//        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),notesSet))
//        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),popapSet))
        binding.titleBurgerThimse.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
//        binding.titleBurgerThimse.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.shodylSet.setBackgroundResource(shodylSet)
        binding.shodylSet1.setBackgroundResource(shodylSet)
        binding.shodylSet2.setBackgroundResource(shodylSet)
        binding.shodylSet3.setBackgroundResource(shodylSet)
        binding.shodylSet4.setBackgroundResource(shodylSet)
    }
    fun number(int: Int) {
        val sharedPreference: SharedPreference = SharedPreference(this)
        sharedPreference.save("number", int)
    }
fun vipInfo () {

}
    fun vip () {
        if (v == 1){
            binding.vipBlock1.visibility = View.GONE
            binding.vipBlock2.visibility = View.GONE
            binding.vipBlock3.visibility = View.GONE
            binding.vipBlock4.visibility = View.GONE
            binding.vipBlock5.visibility = View.GONE
            binding.vipBlock6.visibility = View.GONE
            binding.vipBlock7.visibility = View.GONE
            binding.vipBlock8.visibility = View.GONE
        }else{
            binding.vipBlock1.visibility = View.VISIBLE
            binding.vipBlock2.visibility = View.VISIBLE
            binding.vipBlock3.visibility = View.VISIBLE
            binding.vipBlock4.visibility = View.VISIBLE
            binding.vipBlock5.visibility = View.VISIBLE
            binding.vipBlock6.visibility = View.VISIBLE
            binding.vipBlock7.visibility = View.VISIBLE
            binding.vipBlock8.visibility = View.VISIBLE

        }
    }

    override fun onBackPressed() {
        if ( i > 0){
            binding.vipStatusBuy.visibility = View.GONE
            i -= 1
        }else{
            finish()
        }
    }
}