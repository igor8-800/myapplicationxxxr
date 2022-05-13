package com.example.myapplicationxxxr.scrin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.myapplicationxxxr.MainActivity
import com.example.myapplicationxxxr.databinding.ActivityMainBinding
import com.example.myapplicationxxxr.databinding.ActivityScrinActivitiBinding
import com.example.myapplicationxxxr.hemes.Themes
import com.example.myapplicationxxxr.setting.SharedPreference

class ScrinActiviti : AppCompatActivity() {
    private lateinit var  binding: ActivityScrinActivitiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrinActivitiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var launcher: ActivityResultLauncher<Intent>? = null
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
        val sharedPreference: SharedPreference = SharedPreference(this)
        if (sharedPreference.getValueInt("Themes") != 0) {
            ThemesSet(sharedPreference.getValueInt("Themes"))
        }

        binding.scrinApp.alpha =0f
        binding.scrinApp.animate().setDuration(1500).alpha(1f).withEndAction {
            launcher.launch(Intent(this, com.example.myapplicationxxxr.MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }

    }


    // получение темы приложения
    fun ThemesSet(int: Int){
        val color = Themes()
        val fontSet = color.fontSet(int)
        binding.fon.setBackgroundResource(fontSet)
    }
}