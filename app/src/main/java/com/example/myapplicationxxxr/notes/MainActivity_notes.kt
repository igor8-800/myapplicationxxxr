package com.example.myapplicationxxxr.notes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationxxxr.MainActivity
import android.os.Message
import com.example.myapplicationxxxr.R
import com.example.myapplicationxxxr.databinding.ActivityMainNotesBinding
import com.example.myapplicationxxxr.diary.MainActivity_diary
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.notes.ui.MyAdapter1
import com.example.myapplicationxxxr.notes.ui.MyDbManager1
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1
import com.example.myapplicationxxxr.setting.setting
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class MainActivity_notes : AppCompatActivity(){
    private lateinit var  binding: ActivityMainNotesBinding
    private var launcher: ActivityResultLauncher<Intent>? = null

    private  var job: Job? = null

    //список
    lateinit var option : Spinner
    lateinit var result : EditText
    var item = "1null"

    var i = 0
    var v = 0

    var items = "1null"
    var id = 0
    var isEdetStite = false

    val myDbManager1 = MyDbManager1(this)

    val myAdapter = MyAdapter1(ArrayList(), this, myDbManager1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // кнопка назад
        binding.byrgernotes.setOnClickListener {
            binding.mainnotes.openDrawer(GravityCompat.START)
        }


        // переход с активити
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
            activityMain()
        }
        //Навигация в меню клики
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

                        mainnotes.closeDrawer(GravityCompat.START)

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
                mainnotes.closeDrawer(GravityCompat.START)
                true
            }
        }

            //список rang
        option = findViewById(R.id.spinner_sample)
   val options = arrayOf(resources.getString(R.string.low), resources.getString(R.string.medium),
       resources.getString(R.string.high))
        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            @SuppressLint("SetTextI18n")
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                items(options.get(p2))
            }
        }

        init()

        // сохранение
binding.imageButtonNotesw.setOnClickListener {onCliclSive("")}

        // сохранение быстрой заметки
        binding.fastNotesButton.setOnClickListener {fistNotesSave()}

        //уход с быстрой заметки
        binding.fastNotesContainer.setOnClickListener {
            binding.fastNotesContainer.visibility = View.GONE
            i -= 1
        }

    }

    // определение ранга выброного
 fun items (text: String){
     when(text){
         resources.getString(R.string.low) -> items = "1"
         resources.getString(R.string.medium) -> items = "2"
         resources.getString(R.string.high) -> items = "3"
         else -> items = "1"
     }
}

    override fun onDestroy() {
        super.onDestroy()
        myDbManager1.closeDb()
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

        // открытие базы данных
        myDbManager1.openDb()

        fillAdapter("")

    }



    // включение адаптера
    fun init(){
        binding.recyclerViewNoes.layoutManager = LinearLayoutManager(this)

        //удаление
        val swapHelper = getSwapMG()
        swapHelper.attachToRecyclerView(binding.recyclerViewNoes)

        binding.recyclerViewNoes.adapter = myAdapter

    }

    //адптер
    fun fillAdapter(newText: String){

        //АПТИМЕЗАЦИЯ
        job?.cancel()
        job = CoroutineScope(Dispatchers.Main).launch {
            //

            val list1 = myDbManager1.readDbDate(newText)
            myAdapter.addPlant(list1)
            // показ надписи что пусто (нет записей)
            if (list1.size > 0){
                binding.noteaNone.visibility = View.GONE
            }else{
                binding.noteaNone.visibility = View.VISIBLE
            }

        }
    }



    //  дабавлением в Б.Д.
    fun onCliclSive (colorItem: String){
        val myText = binding.editTextTextPersonName.text.toString()
        val myLord = items
        val check = "2"
        CoroutineScope(Dispatchers.Main).launch {

            if(myText != "") {
                myDbManager1.insertToDb1(myText, myLord, check, id)
            }
        }
        binding.editTextTextPersonName.setText("")
        fillAdapter("")
    }

    // переход на активити
    fun activityMain (){

        launcher?.launch(Intent(this, com.example.myapplicationxxxr.MainActivity::class.java))
    }

    fun activityDiary (){

        launcher?.launch(Intent(this, MainActivity_diary::class.java))
    }
    fun activityMessage (){

        launcher?.launch(Intent(this, Message::class.java))
    }
    fun activitySetting (){
        launcher?.launch(Intent(this, setting::class.java))
    }

    // удаление
    private fun getSwapMG(): ItemTouchHelper {
        return ItemTouchHelper(object:
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                delet(viewHolder)

//                popap(viewHolder)
                myAdapter.removePlant(viewHolder.adapterPosition, myDbManager1)

            }
        })
    }

//    fun popap (viewHolder: RecyclerView.ViewHolder){
//        binding.popap.visibility = View.VISIBLE
//        binding.button.setOnClickListener {
//            myAdapter.obdat()
//            binding.popap.visibility = View.GONE
//        }
//        binding.popap.setBackgroundResource(R.drawable.krugliye_ugli)
//        binding.button2.setOnClickListener {
//            myAdapter.removePlant(viewHolder.adapterPosition, myDbManager)
//            binding.popap.visibility = View.GONE
//        }
//    }





    // настройки размера текста
    fun sizeText (size:Float){
        val sharedPreference: SharedPreference = SharedPreference(this)
        binding.noteaNone.textSize = size
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

    // настройки цвета меню и кнопак
    fun bagrauntMenuButton (int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.constraintLayoutBottun.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.defntes.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.imageView2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }

    // настройки цвета фона
    fun backgronteFon(int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.mainnotes.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }

    // настройки темы
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

        binding.imageView2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.constraintLayoutBottun.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.defntes.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))

        binding.mainnotes.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),fontSet))

        binding.fastNotesFonbg.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),popapSet))

        binding.textView4.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.noteaNone.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.titleNotes.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.editTextTextPersonName.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.fastNotesValues.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

    }

    // быстрая заметка
    fun fistNotesOpen (){
        myDbManager1.openDb()
        binding.fastNotesContainer.visibility = View.VISIBLE
        i += 1
    }

    // сохранение быстрой заметки
    fun fistNotesSave () {

        val values = binding.fastNotesValues.text.toString()
        val rang = "1"
        val check = "2"
        val id = 1
        if(values != ""){
            myDbManager1.insertToDb1(values, rang, check, id )
            binding.fastNotesContainer.visibility = View.GONE
            myDbManager1.closeDb()
            binding.fastNotesValues.setText("")
            i -= 1
        }
    }

    // выход с быстрой заметки
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