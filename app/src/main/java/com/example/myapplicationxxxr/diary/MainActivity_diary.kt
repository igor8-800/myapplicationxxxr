package com.example.myapplicationxxxr.diary

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorInt
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationxxxr.MainActivity
import com.example.myapplicationxxxr.R
import com.example.myapplicationxxxr.databinding.ActivityMainDiaryBinding
import com.example.myapplicationxxxr.diary.book.BookActivity
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.notes.MainActivity_notes
import com.example.myapplicationxxxr.notes.ui.MyDbManager1
import com.example.myapplicationxxxr.setting.SharedPreference
import com.example.myapplicationxxxr.setting.TextColor1
import com.example.myapplicationxxxr.setting.setting
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity_diary : AppCompatActivity() {
    private lateinit var  binding: ActivityMainDiaryBinding
    private var launcher: ActivityResultLauncher<Intent>? = null

    private  var job: Job? = null

    val myDbManager = MyDbManager(this)
    val myAdapter = MyAdapter(ArrayList(), this,myDbManager)


var ararrayColor = listOf(
    "#E6CC24",
    "#47FF75",
    "#496EFA",
    "#EC5353",

)
    var i = 0
    var v = 0


    val myDbManagerNotes = MyDbManager1(this)
    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_newtem)
        super.onCreate(savedInstanceState)
        binding = ActivityMainDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //переход на другой активити
        binding.floatingActionButtonDiary.setOnClickListener{
            val i = Intent(this, BookActivity::class.java)
            startActivity(i)
        }
        init()
        torBur()
        binding.byrgerdiary.setOnClickListener {
            binding.maindiary.openDrawer(GravityCompat.START)
        }


        initSereachView()
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
        binding.apply {

            defmenu.setNavigationItemSelectedListener {
//
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
                        maindiary.closeDrawer(GravityCompat.START)
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
                maindiary.closeDrawer(GravityCompat.START)
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

    fun activityNotes (){

        launcher?.launch(Intent(this, MainActivity_notes::class.java))
    }
    fun activityMessage (){

        launcher?.launch(Intent(this, Message::class.java))
    }

    fun activitySetting (){
        launcher?.launch(Intent(this, setting::class.java))
    }


    // активация бара
    fun torBur (){
        // Активайия стрелки назад
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // название
        supportActionBar?.title ="dnivnik"
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.maine_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    // Слушатель нажатий
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //  if(item.itemId== android.R.id.home) finish()
        when (item.itemId){
            android.R.id.home -> finish()
            R.id.sdsd -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }



//------------------------------

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
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

        myDbManager.openDb()
        fillAdapter("")
    }

// включение адаптера
    fun init(){
        binding.list.layoutManager = LinearLayoutManager(this)

           //удаление
        val swapHelper = getSwapMG()
        swapHelper.attachToRecyclerView(binding.list)

         binding.list.adapter = myAdapter

    }

    //адптер
    fun fillAdapter(newText: String){

        //АПТИМЕЗАЦИЯ
        job?.cancel()
        job = CoroutineScope(Dispatchers.Main).launch {
            //

            val list = myDbManager.readDbDate(newText)
            myAdapter.addPlant(list)
            if (list.size > 0){
                binding.textViewNone.visibility = View.GONE
            }else{
                binding.textViewNone.visibility = View.VISIBLE
            }

        }
    }

    //поиск
    private fun initSereachView(){
        binding.serch.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                fillAdapter(newText!!)
                return true
            }
        })
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

                popap(viewHolder)
            }
        })
    }


    ///////////////////

    fun popap (viewHolder: RecyclerView.ViewHolder){
        binding.popap.visibility = View.VISIBLE

        i += 1

        binding.button.setOnClickListener {
         myAdapter.obdat()
            binding.popap.visibility = View.GONE
            i -= 1
        }
        binding.popap.setBackgroundResource(R.drawable.krugliye_ugli)
        binding.button2.setOnClickListener {
            myAdapter.removePlant(viewHolder.adapterPosition, myDbManager)
            binding.popap.visibility = View.GONE
            i -= 1
        }
    }




    fun sizeText (size:Float){
        val sharedPreference: SharedPreference = SharedPreference(this)
        binding.textViewNone.textSize = size
        binding.textView5.textSize = size
        binding.button2.textSize = size
        binding.button.textSize = size
        binding.textView4.textSize = size
        binding.fastNotesValues.textSize = size

        if(sharedPreference.getValueInt("size") == 12){
            binding.defmenu.setItemTextAppearance(R.style.MenuItems0)
        }
        if(sharedPreference.getValueInt("size") == 14){
            binding.defmenu.setItemTextAppearance(R.style.MenuItems1)
        }
        if(sharedPreference.getValueInt("size") == 16){
            binding.defmenu.setItemTextAppearance(R.style.MenuItems2)
        }
        if(sharedPreference.getValueInt("size") == 18){
            binding.defmenu.setItemTextAppearance(R.style.MenuItems3)
        }
        if(sharedPreference.getValueInt("size") == 20){
            binding.defmenu.setItemTextAppearance(R.style.MenuItems4)
        }
    }

    fun bagrauntMenuButton (int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.defmenu.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.floatingActionButtonDiary.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
        binding.imageView2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }

    fun backgronteFon(int: Int = 1){
        val color = TextColor1()
        val textColor = color.colorTextFun(int)
        binding.maindiary.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),textColor.toInt()))
    }

    fun ThemesSet(int: Int){
        val color = Themes()
        val menuSet = color.menuSet(int)
        val fontSet = color.fontSet(int)
        val popapSet = color.popapSet(int)
        val textSet1 = color.textSet1(int)
        val textSet2 = color.textSet2(int)

        getWindow().setStatusBarColor(ContextCompat.getColor(this, menuSet))
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,menuSet))

        binding.imageView2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.tableRow.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.defmenu.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.floatingActionButtonDiary.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.button2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))
        binding.button.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),menuSet))

        binding.maindiary.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),fontSet))

        binding.fastNotesFonbg.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),popapSet))
        binding.popap.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),popapSet))

        binding.textViewNone.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

        binding.textView5.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.button2.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.textView4.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))
        binding.fastNotesValues.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet2))

        binding.TitleDiary.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
        binding.button.setTextColor(ContextCompat.getColorStateList(getApplicationContext(),textSet1))
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
        if(values != ""){

            CoroutineScope(Dispatchers.IO).launch {
                myDbManagerNotes.insertToDb1(values, rang, check, id)
                binding.fastNotesContainer.visibility = View.GONE
                myDbManagerNotes.closeDb()
                binding.fastNotesValues.setText("")
                i -= 1
            }
            }
    }

    override fun onBackPressed() {
        if ( i > 0){
            myAdapter.obdat()
            binding.popap.visibility = View.GONE
            binding.vipStatusBuy.visibility = View.GONE
            binding.fastNotesContainer.visibility = View.GONE
            i -= 1
        }else{
            finish()
        }
    }
}


