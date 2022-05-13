package com.example.myapplicationxxxr.diary.book

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplicationxxxr.R
import com.example.myapplicationxxxr.databinding.ActivityBookBinding
import com.example.myapplicationxxxr.diary.MainActivity_diary
import com.example.myapplicationxxxr.diary.MyDbManager
import com.example.myapplicationxxxr.diary.MyIntentConstants
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class BookActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityBookBinding

    val myDbManager = MyDbManager(this)

    var id = 0
    var isEdetStite = false
    var colorString = "temp"
    var i = 0
    var v = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // клик, сохронение
        binding.floatingActionButtonBook.setOnClickListener{onCliclSive(colorString)}

        // показ данных при введенных данных
        getMyIntents()

        //клик, кнопка назад
        binding.byrgerbook.setOnClickListener {
            onCliclSive(colorString)
            finish()
        }

        //Клик по меню
        binding.imageButtonColor0.setOnClickListener{colorPrint(0)}
        binding.imageButtonColor1.setOnClickListener{colorPrint(1)}
        binding.imageButtonColor2.setOnClickListener{colorPrint(2)}
        binding.imageButtonColor3.setOnClickListener{colorPrint(3)}
        binding.imageButtonColor4.setOnClickListener{colorPrint(4)}

        //функция назад
        binding.Other.setOnClickListener { other() }

        //выбор цвета в сплывающем окне
        binding.color1.setOnClickListener {colorPrintVip(0)  }
        binding.color2.setOnClickListener {colorPrintVip(1)  }
        binding.color3.setOnClickListener {colorPrintVip(2)  }
        binding.color4.setOnClickListener {colorPrintVip(3)  }
        binding.color5.setOnClickListener {colorPrintVip(4)  }
        binding.color6.setOnClickListener {colorPrintVip(5)  }
        binding.color7.setOnClickListener {colorPrintVip(6)  }
        binding.color8.setOnClickListener {colorPrintVip(7)  }
        binding.color9.setOnClickListener {colorPrintVip(8)  }
        binding.color10.setOnClickListener {colorPrintVip(9)  }
        binding.color11.setOnClickListener {colorPrintVip(10)  }
        binding.color12.setOnClickListener {colorPrintVip(11)  }

        //vip
        binding.bauyVip.setOnClickListener {
            Toast.makeText(this, R.string.vipERRORE, Toast.LENGTH_SHORT).show()

        }

        binding.cencelBuyVip.setOnClickListener {
            binding.vipStatusBuy.visibility = View.GONE
            i -= 1
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
    override fun onResume() {
        super.onResume()

        // настройки
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

        // откритие базы данных
        myDbManager.openDb()
    }




    // настройки размера текста
    fun sizeText (size:Float){
        val sharedPreference: SharedPreference = SharedPreference(this)
        binding.inputeValueBookTitle.textSize = size
        binding.inputeValueBook.textSize = size
        binding.textView1.textSize = size
        binding.textView2.textSize = size
        binding.textView3.textSize = size
        binding.textView4.textSize = size
        binding.textView5.textSize = size
        binding.textView6.textSize = size
        binding.textView7.textSize = size
        binding.textView8.textSize = size
        binding.textView9.textSize = size
        binding.textView10.textSize = size
        binding.textView11.textSize = size
        binding.textView12.textSize = size
        binding.textView114.textSize = size
    }

    //настройки цвета меню и кнопки
    fun bagrauntMenuButton (int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.floatingActionButtonBook.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))

    }

    // настройки цвета фона
    fun backgronteFon(int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.inputeValueBookTitle.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.inputeValueBook.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.fon2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }

    // настройки фона
    fun ThemesSet(int: Int){
        val color = Themes()
        val menuSet = color.menuSet(int)
        val fontSet = color.fontSet(int)
        val inputSet = color.inputSet(int)
        val notesSet = color.notesSet(int)
        val popapSet = color.popapSet(int)
        val textSet1 = color.textSet1(int)
        val textSet2 = color.textSet2(int)

        getWindow().setStatusBarColor(ContextCompat.getColor(this, menuSet))
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,menuSet))

        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.floatingActionButtonBook.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))

        binding.bookContainer.setBackgroundResource(fontSet)

        binding.fon2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),popapSet))

        binding.inputeValueBookTitle.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),inputSet))
        binding.inputeValueBook.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),inputSet))

        binding.inputeValueBookTitle.setHintTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.inputeValueBook.setHintTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

        binding.inputeValueBookTitle.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.inputeValueBook.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

        binding.textView114.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView1.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView2.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView3.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView4.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView5.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView6.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView7.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView8.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView9.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView10.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView11.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.textView12.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))


    }

//Активация меню
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.colormenu, menu)
        return true
    }

    //масив с цветами
    var ararrayColor = listOf(
        "#9E9595",
        "#B5AC5B",
        "#89D46B",
        "#2F322E",
        "#476A39",
        "#ff00ff",
        "#fe0002",
        "#ff6600",
        "#01ffff",
        "#020181",
        "#610163",
        "#993302",
        )

    // Выбор цвета
fun colorPrint(number:Int){

    colorString = ararrayColor.get(number)
    val i = intent
    colors(ararrayColor.get(number))
}
    // Выбор цвета для VIP
    fun colorPrintVip (number:Int){
        i -= 1
        colorString = ararrayColor.get(number)
        val i = intent
        colors(ararrayColor.get(number))
        binding.Other
        binding.fastNotesContainer.visibility = View.GONE

    }


    //  дабавлением в Б.Д.
    fun onCliclSive (colorItem: String){
        val myTitle = binding.inputeValueBookTitle.text.toString()
        val myDesc = binding.inputeValueBook.text.toString()
        val date = dateprint()
        val time = timeString()
        val color: String
        if(colorItem == "temp"){

            color = "#9E9595"

        }else{ color = colorItem}

        CoroutineScope(Dispatchers.Main).launch {

            if(myTitle != "" && myDesc != "") {

                if (isEdetStite) {
                    myDbManager.updateItem(myTitle, myDesc, id, color)
                } else {
                    myDbManager.insertToDb(myTitle, myDesc, date, time, color)
                    finish()
                }
            }
        }

        //переход с активити
        if (myTitle != "" && myDesc != ""){
        var i = Intent(this, MainActivity_diary::class.java)
        startActivity(i)
        }else {
            val text = resources.getText(R.string.error01)
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
    }

    //показ данных
    fun getMyIntents(){

        val i = intent

        if(i != null){

            if (i.getStringExtra(MyIntentConstants.I_TITLE_KEY) != null){
                binding.inputeValueBookTitle.setText(i.getStringExtra(MyIntentConstants.I_TITLE_KEY))
                binding.inputeValueBook.setText(i.getStringExtra(MyIntentConstants.I_CONTENT_KEY))
                when(i.getStringExtra(MyIntentConstants.I_COLOR_KEY)){
                    ararrayColor.get(0) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item0));
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                    ararrayColor.get(1) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item1))
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                    ararrayColor.get(2) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item2))
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                    ararrayColor.get(3) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item3))
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                    ararrayColor.get(4) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item4))
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                    ararrayColor.get(5) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item5))
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                    ararrayColor.get(6) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item6))
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                    ararrayColor.get(7) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item7))
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                    ararrayColor.get(8) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item8))
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                    ararrayColor.get(9) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item9))
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                    ararrayColor.get(10) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item10))
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                    ararrayColor.get(11) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item11))
                        colorString = "${i.getStringExtra(MyIntentConstants.I_COLOR_KEY)}"}
                }

                id = i.getIntExtra(MyIntentConstants.I_ID_KEY, 0)

                isEdetStite = true
                var dd = i.getStringExtra(MyIntentConstants.I_COLOR_KEY)
                colors(dd!!)
            }
        }
    }
    // понимание цвета, получение цвета
fun colors (color: String){
   when(color){
       ararrayColor.get(0) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item0))}
       ararrayColor.get(1) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item1))}
       ararrayColor.get(2) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item2))}
       ararrayColor.get(3) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item3))}
       ararrayColor.get(4) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item4))}
       ararrayColor.get(5) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item5))}
       ararrayColor.get(6) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item6))}
       ararrayColor.get(7) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item7))}
       ararrayColor.get(8) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item8))}
       ararrayColor.get(9) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item9))}
       ararrayColor.get(10) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item10))}
       ararrayColor.get(11) -> {binding.bookContainer.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.item11))}
   }

}

    //  создание даты и форматирование её
    @SuppressLint("SimpleDateFormat")
    fun dateprint ():String {

        var printDate: String
// Создание даты
            val sdf = SimpleDateFormat("dd MMMM")
            val currentDate = sdf.format(Date())
            printDate = currentDate.toString()

        // сортировка даты
        val ds = printDate.toCharArray()
        var tr: String = ""
        var tr1: String = ""
        for (index in ds) {
            if (index == '0'
                || index == '1'
                || index == '1'
                || index == '2'
                || index == '3'
                || index == '4'
                || index == '5'
                || index == '6'
                || index == '7'
                || index == '8'
                || index == '9'
            ) {
                tr1 += index.toString()
            } else {
                if (index == ' ') else tr += index.toString()
            }
        }

        val tr2 = tr1.toInt()

        // вывод даты по языку
        when(tr){
            "March" -> tr = resources.getString(R.string.March)
            "January" -> tr = resources.getString(R.string.January)
            "February" -> tr = resources.getString(R.string.February)
            "May" -> tr = resources.getString(R.string.May)
            "April" -> tr = resources.getString(R.string.April)
            "June" -> tr = resources.getString(R.string.June)
            "July" -> tr = resources.getString(R.string.July)
            "August" -> tr = resources.getString(R.string.August)
            "September" -> tr = resources.getString(R.string.September)
            "October" -> tr = resources.getString(R.string.October)
            "November" -> tr = resources.getString(R.string.November)
            "December" -> tr = resources.getString(R.string.December)
            else -> tr
        }

        val trSum = "${tr2.toString()} $tr"

        return trSum
    }
    override fun onBackPressed() {

        if ( i > 0){
            binding.vipStatusBuy.visibility = View.GONE
            binding.fastNotesContainer.visibility = View.GONE
            i -= 1
        }else{
            finish()
        }
    }
    // создание времени
    fun timeString():String{
        val sdf = SimpleDateFormat("hh:mm:ss")
        val currentDate = sdf.format(Date())
        val printDate = currentDate.toString()
        return printDate
    }
    fun other( ) {

        if (v == 1){
            binding.fastNotesContainer.visibility = View.VISIBLE
            i += 1
        }else{
            binding.vipStatusBuy.visibility = View.VISIBLE
            i += 1
        }
    }
}