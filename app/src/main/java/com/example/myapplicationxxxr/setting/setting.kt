package com.example.myapplicationxxxr.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.example.myapplicationxxxr.MainActivity
import android.os.Message
import com.example.myapplicationxxxr.R
import com.example.myapplicationxxxr.databinding.ActivitySettingBinding
import com.example.myapplicationxxxr.diary.MainActivity_diary
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.notes.MainActivity_notes
import com.example.myapplicationxxxr.notes.ui.MyDbManager1
import com.example.myapplicationxxxr.setting.sitingActivAll.*

class setting : AppCompatActivity() {
    private lateinit var  binding: ActivitySettingBinding
    private var launcher: ActivityResultLauncher<Intent>? = null
    val myDbManagerNotes = MyDbManager1(this)
    var i = 0
    var v = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference: SharedPreference = SharedPreference(this)


        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result: ActivityResult ->

            if (result.resultCode == RESULT_OK){
                // для передачи класса из активити не забыть класс после  as ....
                // и в самом класе обьевить что он принимает значение Serializable
                //adapter.addPlant(result.data?.getSerializableExtra("asds") as LinkDiary)
                // смотреть видео здесь https://www.youtube.com/watch?v=H7EGC9M2CPk&list=PLmjT2NFTgg1fdHN-9Wn4XYr-IOuadxMm5&index=28
                val text = result.data?.getSerializableExtra("key2")
            }
        }

        binding.byrgernotes.setOnClickListener {
            binding.settingMain.openDrawer(GravityCompat.START)
        }

        binding.buttonSettingMain1.setOnClickListener{
            launcher?.launch(Intent(this, Thimes::class.java))
        }
        binding.buttonSettingMain2.setOnClickListener{
            launcher?.launch(Intent(this, TextSize::class.java))
        }
        binding.buttonSettingMain3.setOnClickListener{
            if (v == 1){
            launcher?.launch(Intent(this, TextColorOne::class.java))
        }else{
            binding.vipStatusBuy.visibility = View.VISIBLE
                i += 1
        }
        }
        binding.buttonSettingMain6.setOnClickListener{
            if (v == 1){
            launcher?.launch(Intent(this, ColorMenu::class.java))
        }else{
            binding.vipStatusBuy.visibility = View.VISIBLE
                i += 1
        }
        }
        binding.buttonSettingMain8.setOnClickListener{
            if (v == 1){
                launcher?.launch(Intent(this, NotesColor::class.java))
            }else{
                binding.vipStatusBuy.visibility = View.VISIBLE
                i += 1
            }
        }
        binding.buttonSettingMain7.setOnClickListener{
            if (v == 1){
            launcher?.launch(Intent(this, FieldColor::class.java))
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

        //title
        supportActionBar?.title = resources.getString(R.string.settings)

        // activiti are the inslalid
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result: ActivityResult ->

            if (result.resultCode == RESULT_OK){
                // для передачи класса из активити не забыть класс после  as ....
                // и в самом класе обьевить что он принимает значение Serializable
                //adapter.addPlant(result.data?.getSerializableExtra("asds") as LinkDiary)
                // смотреть видео здесь https://www.youtube.com/watch?v=H7EGC9M2CPk&list=PLmjT2NFTgg1fdHN-9Wn4XYr-IOuadxMm5&index=28
                val text = result.data?.getSerializableExtra("key2")
            }
        }

        //Навигация в меню
        var fg = findViewById<Button>(R.id.homedome)
        fg.setOnClickListener {
            activityMain()
        }
        binding.apply {
            defntes.setNavigationItemSelectedListener {
                when(it.itemId){

                    R.id.Item01 -> {
                        if (v == 1){
                             fistNotesOpen()
                         }else{
                             binding.vipStatusBuy.visibility = View.VISIBLE
                              i += 1
                               }
                        true
                    }
                    R.id.Item02 -> {
                        activityDiary()
                        true
                    }
                    R.id.Item03 -> {

                        activityNotes()
                        true
                    }
                    R.id.Item04 -> {
                        binding.settingMain.closeDrawer(GravityCompat.START)
                    }
                    R.id.Item05 -> {
                        activityMessage()
                        true

                    }
                }
                settingMain.closeDrawer(GravityCompat.START)
                true
            }
        }

        binding.fastNotesButton.setOnClickListener {fistNotesSave()}
        binding.fastNotesContainer.setOnClickListener {
                binding.fastNotesContainer.visibility = View.GONE
                i -= 1
        }

    }
    fun activityMain (){
        launcher?.launch(Intent(this, com.example.myapplicationxxxr.MainActivity::class.java))

    }
    fun activityDiary (){

        launcher?.launch(Intent(this, MainActivity_diary::class.java))
    }
    fun activityMessage (){

        launcher?.launch(Intent(this, Message::class.java))
    }
    fun activityNotes (){

        launcher?.launch(Intent(this, MainActivity_notes::class.java))
    }

    override fun onResume() {
        super.onResume()
        val sharedPreference: SharedPreference = SharedPreference(this)
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
            if (sharedPreference.getValueInt("Themes") != 0) {
                ThemesSet(sharedPreference.getValueInt("Themes"))
            }else{
                ThemesSet(2)
            }
            if (sharedPreference.getValueInt("size") != 0) {
                sizeText(sharedPreference.getValueInt("size").toFloat())
            }
            if (sharedPreference.getValueInt("bagrauntMenuButton") != 0) {
                bagrauntMenuButton(sharedPreference.getValueInt("bagrauntMenuButton"))
            }
            if (sharedPreference.getValueInt("backgronteFon") != 0) {
                backgronteFon(sharedPreference.getValueInt("backgronteFon"))
            }
        }
    }


    fun sizeText (size:Float){
        val sharedPreference: SharedPreference = SharedPreference(this)
        binding.titleSettingMain1.textSize = size - 1
        binding.titleSettingMain2.textSize = size - 1
        binding.titleSettingMain3.textSize = size - 1
        binding.buttonSettingMain1.textSize = size
        binding.buttonSettingMain2.textSize = size
        binding.buttonSettingMain3.textSize = size
        binding.buttonSettingMain6.textSize = size
        binding.buttonSettingMain7.textSize = size
        binding.buttonSettingMain8.textSize = size
        binding.titleBurger.textSize = size
        binding.textView4.textSize = size
        binding.fastNotesValues.textSize = size

        if(sharedPreference.getValueInt("size") == 12){
            binding.defntes.setItemTextAppearance(R.style.MenuItems0)
        }
        if(sharedPreference.getValueInt("size") == 14){
            binding.defntes.setItemTextAppearance(R.style.MenuItems1)
        }
        if(sharedPreference.getValueInt("size") == 16){
            binding.defntes.setItemTextAppearance(R.style.MenuItems2)
        }
        if(sharedPreference.getValueInt("size") == 18){
            binding.defntes.setItemTextAppearance(R.style.MenuItems3)
        }
        if(sharedPreference.getValueInt("size") == 20){
            binding.defntes.setItemTextAppearance(R.style.MenuItems4)
        }
    }
    fun bagrauntMenuButton (int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.tableRow.setBackgroundResource(textColor.toInt())
        binding.defntes.setBackgroundResource(textColor.toInt())
        binding.imageView2.setBackgroundResource(textColor.toInt())
    }
    fun backgronteFon(int: Int ){

        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.settingMain.setBackgroundResource(textColor.toInt())
    }

    fun fistNotesOpen (){
        myDbManagerNotes.openDb()
        binding.fastNotesContainer.visibility = View.VISIBLE
        i += 1
    }
    fun fistNotesSave () {
        val values = binding.fastNotesValues.text.toString()
        val rang = "1"
        val check = "2"
        val id = 1
        if(values != "") {
            myDbManagerNotes.insertToDb1(values, rang, check, id)
            binding.fastNotesContainer.visibility = View.GONE
            myDbManagerNotes.closeDb()
            binding.fastNotesValues.setText("")
            i -= 1
        }
    }

    fun ThemesSet(int: Int){
        val color = Themes()
        val menuSet = color.menuSet(int)
        val fontSet = color.fontSet(int)
        val popapSet = color.popapSet(int)
        val textSet1 = color.textSet1(int)
        val textSet2 = color.textSet2(int)
        val shodylSet = color.shodylSet(int)

        getWindow().setStatusBarColor(ContextCompat.getColor(this, menuSet))
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,menuSet))

        binding.tableRow.setBackgroundResource(menuSet.toInt())
        binding.defntes.setBackgroundResource(menuSet.toInt())

        binding.imageView2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.settingMain.setBackgroundResource(fontSet.toInt())
        binding.fastNotesFonbg.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),popapSet))
        binding.titleSettingMain1.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.titleSettingMain2.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.titleSettingMain3.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

        binding.buttonSettingMain1.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.buttonSettingMain2.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.buttonSettingMain3.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.buttonSettingMain6.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.buttonSettingMain7.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.buttonSettingMain8.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.titleBurger.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))

        binding.textView4.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.fastNotesValues.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))

        binding.shodylSet.setBackgroundResource(shodylSet)
        binding.shodylSet1.setBackgroundResource(shodylSet)
        binding.shodylSet2.setBackgroundResource(shodylSet)


    }

    override fun onBackPressed() {
        if ( i > 0){
            binding.fastNotesContainer.visibility = View.GONE
            binding.vipStatusBuy.visibility = View.GONE
            i -= 1
        }else{
            finish()
        }
    }


}