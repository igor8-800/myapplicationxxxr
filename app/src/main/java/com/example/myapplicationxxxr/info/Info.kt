package com.example.myapplicationxxxr.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationxxxr.databinding.ActivityMainBinding

class Info : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}