package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    private var launcher2: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main2)
        launcher2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result: ActivityResult ->



            if (result.resultCode == RESULT_OK && result.data.toString() == "key1"){
                val text = result.data?.getStringExtra("key1")

            }else{
                val i = Intent()
                i.putExtra( "key2", resources.getString(R.string.mane))// зачение из папки
                setResult(RESULT_OK, i)
                finish()
            }



        }

    }
    fun onClick2 (view: View){
        launcher2?.launch(Intent(this, MainActivity3::class.java))

    }
}