package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    private var launcher: ActivityResultLauncher<Intent>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->

            if (result.resultCode == RESULT_OK){
                val text = result.data?.getStringExtra("key2")
            }
        }

    }

    fun onClick (view: View){
    launcher?.launch(Intent(this, MainActivity2::class.java))

    }
    fun onClick1 (view: View){
        launcher?.launch(Intent(this, MainActivity3::class.java))
        var df = resources.getString(R.string.mane)


    }
}