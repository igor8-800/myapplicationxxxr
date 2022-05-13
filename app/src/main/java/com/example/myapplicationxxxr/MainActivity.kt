package com.example.myapplicationxxxr

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.ActionMenuView
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.ColorRes
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.example.myapplicationxxxr.databinding.ActivityMainBinding
import com.example.myapplicationxxxr.diary.MainActivity_diary
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.notes.MainActivity_notes
import com.example.myapplicationxxxr.notes.ui.MyDbManager1
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1
import com.example.myapplicationxxxr.setting.setting
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private var launcher: ActivityResultLauncher<Intent>? = null
    val myDbManagerNotes = MyDbManager1(this)
    var i = 0
    var v = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


// меню кнопка назад
        binding.byrgerMain.setOnClickListener {
            binding.mainblock.openDrawer(GravityCompat.START)
        }

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

        // нажатие на другое активити
        binding.imageButtonDiary.setOnClickListener{activityDiary()}
        binding.imageButtonNotes.setOnClickListener{activityNotes()}

        //vip
        binding.bauyVip.setOnClickListener {
            Toast.makeText(this, R.string.vipERRORE, Toast.LENGTH_SHORT).show()

        }

        binding.cencelBuyVip.setOnClickListener {
            binding.vipStatusBuy.visibility = View.GONE
            i -= 1
        }

        //Навигация в меню
        var fg = findViewById<Button>(R.id.homedome)
        fg.setOnClickListener {
                binding.mainblock.closeDrawer(GravityCompat.START)
        }
        binding.apply {
            def.setNavigationItemSelectedListener {

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
                        activitySetting()
                        true
                    }
                    R.id.Item05 -> {

                        activityMessage()
                        true
                    }

            }

                mainblock.closeDrawer(GravityCompat.START)
                true
            }
        }


//Быстрая заметка
    binding.fastNotesButton.setOnClickListener {fistNotesSave()}
        binding.fastNotesContainer.setOnClickListener {
            binding.fastNotesContainer.visibility = View.GONE
        }


        binding.fastNotesContainer.setOnClickListener {
            binding.fastNotesContainer.visibility = View.GONE
            i -= 1
        }
    }

    // функции перехода на активити
    fun activityDiary (){

        launcher?.launch(Intent(this, MainActivity_diary::class.java))
    }
    fun activityNotes (){

        launcher?.launch(Intent(this, MainActivity_notes::class.java))
    }
    fun activitySetting (){

        launcher?.launch(Intent(this, setting::class.java))
    }
    fun activityMessage (){

        launcher?.launch(Intent(this, com.example.myapplicationxxxr.Message::class.java))
    }



    override fun onResume() {
        super.onResume()

        // настройки приложения
        val sharedPreference: SharedPreference = SharedPreference(this)
        if(  sharedPreference.getValueInt("number") == 1) {
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
            if (sharedPreference.getValueInt("bagrauntMenuButton") != 0){
                bagrauntMenuButton(sharedPreference.getValueInt("bagrauntMenuButton"))
            }
            if (sharedPreference.getValueInt("backgronteFon") != 0){
                backgronteFon(sharedPreference.getValueInt("backgronteFon"))
            }
            if (sharedPreference.getValueInt("size") != 0) {
                sizeText(sharedPreference.getValueInt("size").toFloat())
            }
        }
    }

    // настройки размера текста
    fun sizeText (size:Float){
        val sharedPreference: SharedPreference = SharedPreference(this)
        binding.textView.textSize = size
        binding.textView2.textSize = size
        binding.textView3.textSize = size
        binding.textView4.textSize = size
        binding.fastNotesValues.textSize = size
        if(  sharedPreference.getValueInt("number") == 1) {
            if (sharedPreference.getValueInt("size") == 12) {
                binding.def.setItemTextAppearance(R.style.MenuItems0)
            }
            if (sharedPreference.getValueInt("size") == 14) {
                binding.def.setItemTextAppearance(R.style.MenuItems1)
            }
            if (sharedPreference.getValueInt("size") == 16) {
                binding.def.setItemTextAppearance(R.style.MenuItems2)
            }
            if (sharedPreference.getValueInt("size") == 18) {
                binding.def.setItemTextAppearance(R.style.MenuItems3)
            }
            if (sharedPreference.getValueInt("size") == 20) {
                binding.def.setItemTextAppearance(R.style.MenuItems4)
            }
        }else{

        }
    }

    //настройка меню и кнопок
    fun bagrauntMenuButton (int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.def.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.imageView2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }

    // настройки фона приложения
    fun backgronteFon(int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.mainblock.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }


    // настройка темы
    fun ThemesSet(int: Int){
        val color = Themes()
        val menuSet = color.menuSet(int)
        val fontSet = color.fontSet(int)
        val inputSet = color.inputSet(int)
        val notesSet = color.notesSet(int)
        val popapSet = color.popapSet(int)
        val textSet1 = color.textSet1(int)
        val textSet2 = color.textSet2(int)
        val shodylSet = color.shodylSet1(int)

        getWindow().setStatusBarColor(ContextCompat.getColor(this, menuSet))
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,menuSet))

        binding.imageView2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.def.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))

        binding.mainblock.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),fontSet))

        binding.fistNotesFone.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),popapSet))
        binding.textView.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.textView2.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.textView3.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))

        binding.mainTitle.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.textView4.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.fastNotesValues.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

        binding.imageButtonNotes.setBackgroundResource(shodylSet)
        binding.imageButtonDiary.setBackgroundResource(shodylSet)
        binding.imageButton3.setBackgroundResource(shodylSet)
    }

    // быстрая заметка, open,
 fun fistNotesOpen (){
     myDbManagerNotes.openDb()
     binding.fastNotesContainer.visibility = View.VISIBLE
     i += 1
 }

    // быстрая заметка, next,
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


    //aeyrwbz dfphfnf yfpfl
    override fun onBackPressed() {
        if ( i > 0){
            binding.vipStatusBuy.visibility = View.GONE
            binding.fastNotesContainer.visibility = View.GONE
            i -= 1
        }else{
            finish()
        }
    }

}